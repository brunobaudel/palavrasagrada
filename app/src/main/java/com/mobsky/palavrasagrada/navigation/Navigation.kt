package com.mobsky.palavrasagrada.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mobsky.home.navigation.homeNavGraph
import com.mobsky.navigate.HomeGraph
import com.mobsky.navigate.RootGraph


@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootGraph.Root().rote,
        startDestination = HomeGraph.Root().rote
    ) {

        homeNavGraph(navController)

    }
}