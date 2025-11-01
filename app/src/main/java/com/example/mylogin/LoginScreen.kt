package com.example.mylogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserRegisterScreen() {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }

    var isOtpSent by remember { mutableStateOf(false) }
    var generatedOtp by remember { mutableStateOf("") }
    var isRegistered by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.a),
            contentDescription = "Registration image"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Create Your Account",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (!isRegistered) {
            // 🔹 Step 1: Basic Registration Fields
            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Mobile Number") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("City") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = education,
                onValueChange = { education = it },
                label = { Text("Education Qualification") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 Step 2: OTP Sending & Verification
            if (!isOtpSent) {
                Button(
                    onClick = {
                        if (phone.isNotEmpty()) {
                            // Simulate sending OTP
                            generatedOtp = (1000..9999).random().toString()
                            isOtpSent = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Send OTP")
                }
            } else {
                OutlinedTextField(
                    value = otp,
                    onValueChange = { otp = it },
                    label = { Text("Enter OTP") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        if (otp == generatedOtp) {
                            isRegistered = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Verify & Register")
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Didn’t get OTP? Resend",
                    modifier = Modifier.clickable {
                        generatedOtp = (1000..9999).random().toString()
                    }
                )
            }
        } else {
            // 🔹 Step 3: Success Message
            Text(
                text = "🎉 Registration Successful!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Welcome, $fullName!")
        }
    }
}