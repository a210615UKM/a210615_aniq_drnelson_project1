package com.example.a210615_aniq_drnelson_project1.screens.main

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.a210615_aniq_drnelson_project1.R
import com.example.a210615_aniq_drnelson_project1.navigation.AppScreen

@Composable
fun HumanityHomeUI(
    onNavigate: (AppScreen) -> Unit,
    modifier: Modifier = Modifier,
    username: String = "User"
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        HeaderSection(username = username)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Together, we end poverty.",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        FeatureCard(
            title = "Donation Campaigns",
            description = "Your small contribution provides meals and essentials.",
            imageResId = R.drawable.donation_hero,
            ctaText = "Donate Now",
            accentColor = MaterialTheme.colorScheme.primary,
            onClick = { onNavigate(AppScreen.Donate) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        JobTitle(
            title = "Find Opportunities",
            actionText = "View All",
            onViewAllClick = { onNavigate(AppScreen.Jobs) }
        )

        JobItem("Cafe Assistant", "Kuala Lumpur", "RM8/hour")
        JobItem("Delivery Rider", "Remote", "Flexible")
        JobItem("Retail Helper", "Selangor", "RM10/hour")

        Spacer(modifier = Modifier.height(16.dp))

        FeatureCard(
            title = "Volunteer Locally",
            description = "Join 500+ volunteers this weekend.",
            imageResId = R.drawable.volunteer_hero,
            ctaText = "Join Movement",
            accentColor = MaterialTheme.colorScheme.secondaryContainer,
            isDarkText = true,
            onClick = { onNavigate(AppScreen.Volunteer) }
        )

        // 🔥 IMPORTANT: prevent bottom nav overlap
        Spacer(modifier = Modifier.height(80.dp))
    }
}


@Composable
fun HeaderSection(username: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "Humanity",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = username,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier.size(26.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureCard(
    title: String,
    description: String,
    imageResId: Int,
    ctaText: String,
    accentColor: Color,
    isDarkText: Boolean = false,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .animateContentSize(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Box {

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {

                Text(title, color = Color.White, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(4.dp))

                Text(description, color = Color.White.copy(alpha = 0.9f))

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(accentColor)
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = ctaText,
                        color = if (isDarkText) Color.Black else Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun JobItem(title: String, location: String, salary: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Work,
                    contentDescription = "Job Icon"
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Text(location, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }

            Text(salary, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun JobTitle(
    title: String,
    actionText: String,
    onViewAllClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(title, fontWeight = FontWeight.Bold)

        Text(
            text = actionText,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { onViewAllClick() }
        )
    }
}