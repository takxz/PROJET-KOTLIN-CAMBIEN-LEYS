package com.example.openapplication

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == "add",
            onClick = { navController.navigate("add") },
            label = { Text("Ajouter") },
            icon = { Icon(Icons.Default.Add, contentDescription = null) }
        )
        NavigationBarItem(
            selected = currentRoute == "actions",
            onClick = { navController.navigate("actions") },
            label = { Text("Actions") },
            icon = { Icon(Icons.Default.List, contentDescription = null) }
        )
        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = { navController.navigate("profile") },
            label = { Text("Profil") },
            icon = { Icon(Icons.Default.Person, contentDescription = null) }
        )
    }
}
