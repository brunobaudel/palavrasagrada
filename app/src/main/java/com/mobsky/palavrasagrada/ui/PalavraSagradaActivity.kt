package com.mobsky.palavrasagrada.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.mobsky.palavrasagrada.navigation.RootNavigationGraph
import com.mobsky.palavrasagrada.ui.theme.GitListUsersTheme

class PalavraSagradaActivity : AppCompatActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitListUsersTheme{
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}