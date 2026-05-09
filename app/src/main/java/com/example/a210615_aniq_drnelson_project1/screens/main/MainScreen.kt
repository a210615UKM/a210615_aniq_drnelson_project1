package com.example.a210615_aniq_drnelson_project1.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.components.BottomNavigationBar
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: AppViewModel
) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->

        HumanityHomeUI(
            onNavigate = { screen ->
                navController.navigate(screen.name)
            },
            modifier = Modifier.padding(padding), // IMPORTANT FIX
            username = viewModel.userData.username
        )
    }
}