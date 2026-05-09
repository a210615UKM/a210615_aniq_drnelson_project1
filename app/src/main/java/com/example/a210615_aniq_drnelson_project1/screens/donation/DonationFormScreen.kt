package com.example.a210615_aniq_drnelson_project1.screens.donation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.navigation.AppScreen
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel

@Composable
fun DonationFormScreen(
    navController: NavController,
    viewModel: AppViewModel
) {

    var fullName by remember { mutableStateOf("") }
    var selectedBank by remember { mutableStateOf("Maybank") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(16.dp)
    ) {

        IconButton(
            onClick = {
                if (!navController.popBackStack()) {
                    navController.navigate(AppScreen.Donate.name)
                }
            }
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Text(
            text = "Donation Form",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                OutlinedTextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    label = { Text("Full Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Select Bank")

                Spacer(modifier = Modifier.height(8.dp))

                listOf("Maybank", "RHB", "Bank Rakyat").forEach { bank ->

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedBank == bank,
                            onClick = { selectedBank = bank }
                        )
                        Text(bank)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                viewModel.updateFullName(fullName)
                navController.navigate(AppScreen.Summary.name)
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Confirm")
        }
    }
}