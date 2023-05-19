package com.mobsky.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.domain.model.Verse
import com.mobsky.home.domain.usecase.GetBooksUseCase
import com.mobsky.home.domain.usecase.GetVerseRandomUseCase
import com.mobsky.home.domain.usecase.invoke
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val getBooksUseCase: GetBooksUseCase,
    private val getVerseRandom: GetVerseRandomUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    fun getBooks() {
        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                getBooksUseCase.invoke()
                val verse = getVerseRandom.invoke()
                updateScreenStateSuccess(verse)
            } catch (e: Exception) {
                updateScreenStateError(e)
            }
        }
    }

    private fun updateScreenStateSuccess(verse: Verse) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                verse = verse
            )
        }
    }

    private fun updateScreenStateError(exception: Exception) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Error(exception)
            )
        }
    }

    private fun updateScreenStateProgress() {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.InProgress
            )
        }
    }

}