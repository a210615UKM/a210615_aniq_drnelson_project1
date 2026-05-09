package com.example.a210615_aniq_drnelson_project1.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a210615_aniq_drnelson_project1.R
import com.example.a210615_aniq_drnelson_project1.navigation.AppScreen
import com.example.a210615_aniq_drnelson_project1.viewmodel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: AppViewModel
) {

    var usernameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var phoneInput by remember { mutableStateOf("") }
    var countryInput by remember { mutableStateOf("") }
    var agreeTerms by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = "Humanity",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = "Create Your Account",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                CustomTextField(
                    value = usernameInput,
                    onValueChange = { usernameInput = it },
                    label = "Username",
                    icon = Icons.Default.Person
                )

                Spacer(modifier = Modifier.height(12.dp))

                CustomTextField(
                    value = passwordInput,
                    onValueChange = { passwordInput = it },
                    label = "Password",
                    icon = Icons.Default.Lock,
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                CustomTextField(
                    value = emailInput,
                    onValueChange = { emailInput = it },
                    label = "Email",
                    keyboardType = KeyboardType.Email,
                    icon = Icons.Default.Email
                )

                Spacer(modifier = Modifier.height(12.dp))

                CustomTextField(
                    value = phoneInput,
                    onValueChange = { phoneInput = it },
                    label = "Phone Number",
                    keyboardType = KeyboardType.Phone,
                    icon = Icons.Default.Phone
                )

                Spacer(modifier = Modifier.height(12.dp))

                CustomTextField(
                    value = countryInput,
                    onValueChange = { countryInput = it },
                    label = "Country",
                    icon = Icons.Default.Public
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Checkbox(
                        checked = agreeTerms,
                        onCheckedChange = { agreeTerms = it }
                    )
                    Text("I agree with the Terms and Conditions")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (agreeTerms) {
                    viewModel.signUp(
                        usernameInput,
                        passwordInput,
                        usernameInput,
                        emailInput,
                        phoneInput,
                        countryInput,

                    )
                    navController.navigate(AppScreen.Login.name)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Sign Up", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // LOGIN BUTTON (NEW)
        TextButton(
            onClick = {
                navController.navigate(AppScreen.Login.name)
            }
        ) {
            Text("Already have an account? Login")
        }
    }
}