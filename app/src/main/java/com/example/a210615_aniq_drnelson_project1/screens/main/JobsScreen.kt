package com.example.a210615_aniq_drnelson_project1.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.components.UsernameHeader
import com.example.a210615_aniq_drnelson_project1.R
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel
import com.example.a210615_aniq_drnelson_project1.components.BottomNavigationBar
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
@Composable
fun JobsScreen(
    navController: NavController,
    viewModel: AppViewModel
) {


    var expandedIndex by remember { mutableStateOf<Int?>(null) }

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
                .padding(dimensionResource(id = R.dimen.padding_screen))
        ) {


            UsernameHeader(username = viewModel.userData.username)

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Job Opportunities",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))

            val jobList = listOf(
                JobData(
                    title = "Cafe Assistant",
                    location = "Kuala Lumpur",
                    salary = "RM8/hour",
                    imageResId = R.drawable.cafe_assistant,
                    storeName = "Humanity Cafe",
                    workingHours = "8:00 AM - 2:00 PM",
                    jobType = "Part-time",
                    requirement = "Basic customer service skills"
                ),
                JobData(
                    title = "Delivery Rider",
                    location = "Kuala Lumpur",
                    salary = "Flexible",
                    imageResId = R.drawable.delivery_rider,
                    storeName = "Community Delivery Hub",
                    workingHours = "Flexible schedule",
                    jobType = "Part-time",
                    requirement = "Own transport is preferred"
                ),
                JobData(
                    title = "Retail Helper",
                    location = "Selangor",
                    salary = "RM10/hour",
                    imageResId = R.drawable.retail_helper,
                    storeName = "Hope Retail Store",
                    workingHours = "10:00 AM - 5:00 PM",
                    jobType = "Part-time",
                    requirement = "Able to arrange products neatly"
                ),
                JobData(
                    title = "Warehouse Assistant",
                    location = "Shah Alam",
                    salary = "RM9/hour",
                    imageResId = R.drawable.warehouse_assistant,
                    storeName = "Aid Supply Warehouse",
                    workingHours = "9:00 AM - 4:00 PM",
                    jobType = "Part-time",
                    requirement = "Able to carry light items"
                )
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.spacing_small)
                )
            ) {

                jobList.forEachIndexed { index, job ->

                    ExpandableJobItem(
                        job = job,
                        isExpanded = expandedIndex == index,
                        onClick = {
                            expandedIndex =
                                if (expandedIndex == index) null else index
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(
                    dimensionResource(id = R.dimen.spacing_bottom_nav)
                )
            )
        }
    }
}

data class JobData(
    val title: String,
    val location: String,
    val salary: String,
    val imageResId: Int,
    val storeName: String,
    val workingHours: String,
    val jobType: String,
    val requirement: String
)

@Composable
fun ExpandableJobItem(
    job: JobData,
    isExpanded: Boolean,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_large)),
        elevation = CardDefaults.cardElevation(
            dimensionResource(id = R.dimen.elevation_card)
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {

        Column {

            Image(
                painter = painterResource(id = job.imageResId),
                contentDescription = job.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(
                    dimensionResource(id = R.dimen.padding_card)
                )
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Column(modifier = Modifier.weight(1f)) {

                        Text(
                            text = job.title,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Text(
                            text = job.location,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Text(
                        text = job.salary,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.scrim
                    )
                }

                if (isExpanded) {

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                    JobDetailRow(
                        label = "Store Name",
                        value = job.storeName
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    JobDetailRow(
                        label = "Location",
                        value = job.location
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    JobDetailRow(
                        label = "Working Hours",
                        value = job.workingHours
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    JobDetailRow(
                        label = "Job Type",
                        value = job.jobType
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    JobDetailRow(
                        label = "Requirement",
                        value = job.requirement
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                    Text(
                        text = "This opportunity helps people earn income while building useful working experience.",
                        color = MaterialTheme.colorScheme.scrim
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_medium))
                    ) {
                        Text("Apply Now")
                    }
                }
            }
        }
    }
}

@Composable
fun JobDetailRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "$label:",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = value,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
