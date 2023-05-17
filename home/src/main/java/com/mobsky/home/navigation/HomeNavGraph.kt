package com.mobsky.home.navigation


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mobsky.home.presentation.HomeScreen
import com.mobsky.home.presentation.HomeScreenViewModel
import com.mobsky.navigate.HomeGraph
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        route = HomeGraph.Root().rote,
        startDestination = HomeGraph.Home().rote
    ) {

        composable(route = HomeGraph.Home().rote) {
            val viewModel = koinViewModel<HomeScreenViewModel>()
            HomeScreen(viewModel) {
                val destination = when (it) {
                    else -> ""
                }
                navController.navigate(destination)
            }
        }
    }
}