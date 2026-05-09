package com.example.a210615_aniq_drnelson_project1.screens.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.components.BottomNavigationBar
import com.example.a210615_aniq_drnelson_project1.navigation.AppScreen
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: AppViewModel
) {

    val user = viewModel.userData

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(16.dp)
        ) {

            Text(
                text = "Profile",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {

                        Text(
                            text = user.username,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = user.email,
                            style = MaterialTheme.typography.bodySmall
                        )

                        Text(
                            text = user.phone,
                            style = MaterialTheme.typography.bodySmall
                        )

                        Text(
                            text = user.country,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Donation History")

            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    if (user.donationHistory.isEmpty()) {
                        Text("No donations yet")
                    } else {
                        user.donationHistory.forEach { donation ->

                            Column {
                                Text(
                                    text = "RM ${donation.amount}",
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = donation.dateTime,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }

                            Divider(modifier = Modifier.padding(vertical = 8.dp))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Joined Activity History")

            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    if (user.volunteerHistory.isEmpty()) {
                        Text("No activities joined yet")
                    } else {
                        user.volunteerHistory.forEach {
                            Text(it)
                            Divider(modifier = Modifier.padding(vertical = 6.dp))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 🔥 NEW BUTTON: EDIT PROFILE
            Button(
                onClick = {
                    navController.navigate(AppScreen.EditProfile.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Edit Profile")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // EXISTING LOGOUT
            Button(
                onClick = {
                    viewModel.logout()
                    navController.navigate(AppScreen.SignUp.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Logout")
            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}