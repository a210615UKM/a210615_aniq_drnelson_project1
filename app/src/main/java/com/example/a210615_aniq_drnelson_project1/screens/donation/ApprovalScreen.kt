package com.example.a210615_aniq_drnelson_project1.screens.donation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.navigation.AppScreen
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel

@Composable
fun ApprovalScreen(
    navController: NavController,
    viewModel: AppViewModel
) {

    val user = viewModel.userData

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(16.dp)
    ) {

        Text(
            text = "Approve Transaction",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text("Organization")
                Text("Yayasan EZ Kasih")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Amount")
                Text("RM ${user.donationAmount}")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                viewModel.addDonation(user.donationAmount)

                navController.navigate(AppScreen.Complete.name)
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Approve")
        }
    }
}