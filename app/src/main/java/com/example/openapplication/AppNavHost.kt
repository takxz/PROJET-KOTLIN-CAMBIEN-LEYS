package com.example.openapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.openapplication.viewmodel.OpenViewModel
import com.example.openapplication.ui.screens.ProfileScreen
import com.example.openapplication.ui.screens.AddActionScreen
import com.example.openapplication.ui.screens.ActionsScreen

@Composable
fun AppNavHost(viewModel: OpenViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "profile",
            modifier = Modifier.padding(padding)
        ) {
            composable("add") { AddActionScreen(viewModel) }
            composable("actions") { ActionsScreen() }
            composable("profile") { ProfileScreen(viewModel) }
        }
    }
}
