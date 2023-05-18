package com.mobsky.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobsky.home.presentation.components.HomeSection
import com.mobsky.home.presentation.components.ScreenStateView
import com.mobsky.home.presentation.util.TaskState
import com.mobsky.navigate.Navigate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onClickNavigation: (navigate: Navigate) -> Unit) {

    Scaffold(
        topBar = {
            HomeTopBar("Teste", onClickOpenDrawer = {})
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                HomeView(viewModel, onClickNavigation)
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(topBarName: String, onClickOpenDrawer: () -> Unit) {

    Surface(shadowElevation = 4.dp) {
        TopAppBar(title = { Text(text = topBarName) },
            navigationIcon = {
                IconButton(onClick = { onClickOpenDrawer() }) {
                    Icon(Icons.Filled.Menu, "")
                }
            }
        )
    }
}

@Composable
fun HomeView(viewModel: HomeScreenViewModel, onClickNavigation: (navigate: Navigate) -> Unit) {

    val uiState by viewModel.uiState.collectAsState()

    if (uiState.taskState == TaskState.NotStarted) {
        viewModel.getBooks()
    }

    ScreenStateView(uiState,
        tryAgainCallBack = { viewModel.getBooks() },
        content = {

        }
    )
}

@Composable
fun HomeBody(){

    Column {

        HomeSection(title = "") {

        }

        HomeSection(title = "") {

        }
    }
}

