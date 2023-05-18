package com.mobsky.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobsky.home.data.repository.Books
import com.mobsky.home.domain.usecase.GetUserUseCase
import com.mobsky.home.domain.usecase.invoke
import com.mobsky.home.presentation.util.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState.asStateFlow()

    fun getBooks() {
        viewModelScope.launch {
            try {
                updateScreenStateProgress()
                val books = getUserUseCase.invoke()
                updateScreenStateSuccess(books)
            }catch (e: Exception){
                updateScreenStateError(e)
            }
        }
    }

    private fun updateScreenStateSuccess(users: Books) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                books = users
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