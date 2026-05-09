package com.example.a210615_aniq_drnelson_project1.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.R
import com.example.a210615_aniq_drnelson_project1.components.UsernameHeader
import com.example.a210615_aniq_drnelson_project1.components.BottomNavigationBar
import com.example.a210615_aniq_drnelson_project1.navigation.AppScreen
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel

@Composable
fun DonateScreen(
    navController: NavController,
    viewModel: AppViewModel
) {

    var isExpanded by remember { mutableStateOf(false) }
    var selectedAmount by remember { mutableStateOf("RM50") }
    var customAmount by remember { mutableStateOf("") }

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

            UsernameHeader(username = viewModel.userData.username)

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Donate to Humanity",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Box {

                    Image(
                        painter = painterResource(id = R.drawable.donation_hero),
                        contentDescription = "Donate",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.6f)
                                    )
                                )
                            )
                    )

                    Text(
                        text = "Support the victims of the Sandakan fire",
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                onClick = { isExpanded = !isExpanded },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                modifier = Modifier.animateContentSize()
            ) {

                Column(modifier = Modifier.padding(16.dp)) {


                    Text(
                        text = "Support the victims of the Sandakan fire - Yayasan Ez Kasih",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Your donation helps families rebuild their lives.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Card(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.donation),
                            contentDescription = "Donation",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Text(
                            text = "Choose your donation",
                            modifier = Modifier.weight(1f)
                        )

                        Icon(
                            imageVector = if (isExpanded)
                                Icons.Default.KeyboardArrowUp
                            else
                                Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }

                    if (isExpanded) {

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {

                            listOf("RM10", "RM50", "RM100", "RM200").forEach { amount ->

                                Card(
                                    onClick = {
                                        selectedAmount = amount
                                        customAmount = ""
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor =
                                            if (selectedAmount == amount)
                                                MaterialTheme.colorScheme.primary
                                            else
                                                MaterialTheme.colorScheme.surface
                                    ),
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(4.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.padding(vertical = 12.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = amount,
                                            color =
                                                if (selectedAmount == amount)
                                                    MaterialTheme.colorScheme.onPrimary
                                                else
                                                    MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = customAmount,
                            onValueChange = {
                                customAmount = it
                                selectedAmount = ""
                            },
                            label = { Text("Custom Amount (RM)") },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        val finalAmount =
                            if (customAmount.isNotEmpty()) customAmount
                            else selectedAmount.replace("RM", "")

                        Button(
                            onClick = {
                                if (finalAmount.isNotEmpty()) {

                                    viewModel.setDonationAmount(finalAmount)

                                    navController.navigate(AppScreen.DonationForm.name)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text("Donate RM $finalAmount")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(80.dp)) // avoid nav overlap
        }
    }
}