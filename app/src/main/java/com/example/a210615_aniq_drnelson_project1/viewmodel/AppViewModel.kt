package com.example.a210615_aniq_drnelson_project1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.a210615_aniq_drnelson_project1.data.UserData
import com.example.a210615_aniq_drnelson_project1.data.Donation

class AppViewModel : ViewModel() {

    var userData by mutableStateOf(UserData())
        private set

    // SIGN UP
    fun signUp(
        username: String,
        password: String,
        fullName: String,
        email: String,
        phone: String,
        country: String
    ) {
        userData = userData.copy(
            username = username,
            password = password,
            fullName = fullName,
            email = email,
            phone = phone,
            country = country
        )
    }

    // LOGIN
    fun login(username: String, password: String): Boolean {
        return userData.username == username && userData.password == password
    }

    fun updateProfile(
        username: String,
        password: String,
        email: String,
        phone: String,
        country: String
    ) {
        userData = userData.copy(
            username = username,
            password = password,
            email = email,
            phone = phone,
            country = country
        )
    }

    // ADD DONATION
    fun addDonation(amount: String) {

        val currentTime = java.text.SimpleDateFormat(
            "dd MMM yyyy, hh:mm a",
            java.util.Locale.getDefault()
        ).format(java.util.Date())

        val newDonation = Donation(amount, currentTime)

        userData = userData.copy(
            donationHistory = (userData.donationHistory + newDonation).toMutableList()
        )
    }

    fun setDonationAmount(amount: String) {
        userData = userData.copy(donationAmount = amount)
    }

    fun clearDonationAmount() {
        userData = userData.copy(donationAmount = "")
    }

    fun setLastMessage(message: String) {
        userData = userData.copy(lastMessage = message)
    }

    // LOGOUT
    fun logout() {
        userData = UserData()
    }

    fun updateFullName(fullName: String) {
        userData = userData.copy(fullName = fullName)
    }
}