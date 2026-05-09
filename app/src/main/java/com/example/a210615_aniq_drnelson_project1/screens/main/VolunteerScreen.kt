package com.example.a210615_aniq_drnelson_project1.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.R
import com.example.a210615_aniq_drnelson_project1.components.UsernameHeader
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel
import com.example.a210615_aniq_drnelson_project1.components.BottomNavigationBar
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Groups

@Composable
fun VolunteerScreen(
    navController: NavController,
    viewModel: AppViewModel
) {

    var isExpanded by remember { mutableStateOf(false) }

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
                text = "Volunteer with Us",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            // HERO CARD
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                Box {

                    Image(
                        painter = painterResource(id = R.drawable.volunteer_hero),
                        contentDescription = "Volunteer",
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
                        text = "Be the Change. Help Others.",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
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
                elevation = CardDefaults.cardElevation(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize()
            ) {

                Column {

                    Image(
                        painter = painterResource(id = R.drawable.activiti),
                        contentDescription = "Volunteer Activity",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(modifier = Modifier.padding(16.dp)) {

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Column(modifier = Modifier.weight(1f)) {

                                Text(
                                    text = "Give Food to the Homeless",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = "Join our volunteer activity to distribute meals and basic needs to people who need support.",
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Icon(
                                imageVector = if (isExpanded)
                                    Icons.Default.KeyboardArrowUp
                                else
                                    Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        VolunteerInfoRow(
                            icon = Icons.Default.LocationOn,
                            label = "Location",
                            value = "Kuala Lumpur City Centre"
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        VolunteerInfoRow(
                            icon = Icons.Default.DateRange,
                            label = "Date",
                            value = "18 May 2026"
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        VolunteerInfoRow(
                            icon = Icons.Default.Schedule,
                            label = "Time",
                            value = "9:00 AM - 12:00 PM"
                        )

                        if (isExpanded) {

                            Spacer(modifier = Modifier.height(14.dp))

                            VolunteerInfoRow(
                                icon = Icons.Default.Groups,
                                label = "Volunteers Needed",
                                value = "20 people"
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "Volunteers will help pack food, distribute meals, and assist the community team during the activity.",
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = { },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(52.dp),
                                shape = RoundedCornerShape(14.dp)
                            ) {
                                Text(
                                    text = "Join Movement",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun VolunteerInfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {

            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = value,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}