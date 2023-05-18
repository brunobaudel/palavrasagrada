package com.mobsky.home.presentation


import com.mobsky.home.data.repository.Books
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class HomeScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val books: Books =  listOf()
): ScreenState(taskState)