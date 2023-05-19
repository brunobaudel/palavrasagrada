package com.mobsky.home.presentation


import com.mobsky.home.domain.model.Verse
import com.mobsky.home.presentation.util.ScreenState
import com.mobsky.home.presentation.util.TaskState

data class HomeScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val verse: Verse =  Verse()
): ScreenState(taskState)