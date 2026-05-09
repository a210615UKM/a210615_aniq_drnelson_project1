package com.example.a210615_aniq_drnelson_project1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel

// SCREENS
import com.example.a210615_aniq_drnelson_project1.screens.auth.SignUpScreen
import com.example.a210615_aniq_drnelson_project1.screens.auth.LoginScreen
import com.example.a210615_aniq_drnelson_project1.screens.main.WelcomeScreen
import com.example.a210615_aniq_drnelson_project1.screens.main.MainScreen
import com.example.a210615_aniq_drnelson_project1.screens.main.DonateScreen
import com.example.a210615_aniq_drnelson_project1.screens.main.ProfileScreen

import com.example.a210615_aniq_drnelson_project1.screens.donation.DonationFormScreen
import com.example.a210615_aniq_drnelson_project1.screens.donation.SummaryScreen
import com.example.a210615_aniq_drnelson_project1.screens.donation.BankLoginScreen
import com.example.a210615_aniq_drnelson_project1.screens.donation.ApprovalScreen
import com.example.a210615_aniq_drnelson_project1.screens.donation.CompleteScreen
import com.example.a210615_aniq_drnelson_project1.screens.donation.ThankYouScreen
import com.example.a210615_aniq_drnelson_project1.screens.editprofile.EditProfileScreen
import com.example.a210615_aniq_drnelson_project1.screens.main.JobsScreen
import com.example.a210615_aniq_drnelson_project1.screens.main.VolunteerScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    val viewModel: AppViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppScreen.SignUp.name
    ) {

        composable(AppScreen.SignUp.name) {
            SignUpScreen(navController, viewModel)
        }

        composable(AppScreen.Login.name) {
            LoginScreen(navController, viewModel)
        }

        composable(AppScreen.Welcome.name) {
            WelcomeScreen(navController, viewModel)
        }

        composable(AppScreen.Main.name) {
            MainScreen(navController, viewModel)
        }

        composable(AppScreen.Donate.name) {
            DonateScreen(navController, viewModel)
        }

        composable(AppScreen.Profile.name) {
            ProfileScreen(navController, viewModel)
        }

        composable(AppScreen.DonationForm.name) {
            DonationFormScreen(navController, viewModel)
        }

        composable(AppScreen.Summary.name) {
            SummaryScreen(navController, viewModel)
        }

        composable(AppScreen.BankLogin.name) {
            BankLoginScreen(navController)
        }

        composable(AppScreen.Approval.name) {
            ApprovalScreen(navController, viewModel)
        }

        composable(AppScreen.Complete.name) {
            CompleteScreen(navController, viewModel)
        }

        composable(AppScreen.ThankYou.name) {
            ThankYouScreen(navController, viewModel)
        }

        composable(AppScreen.EditProfile.name) {
            EditProfileScreen(navController, viewModel)
        }

        composable(AppScreen.Jobs.name) {
            JobsScreen(navController,viewModel)
        }

        composable(AppScreen.Volunteer.name) {
            VolunteerScreen(navController,viewModel)
        }
    }
}