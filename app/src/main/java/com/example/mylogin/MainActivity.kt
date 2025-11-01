package com.example.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mylogin.ui.theme.MyLoginTheme // Make sure this theme is defined in your project

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // The MyLoginTheme composable is generated when you create a new Jetpack Compose project.
            // It applies the app's theme to the content within it.
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // This is where you call your main screen composable.
                    UserRegisterScreen()
                }
            }
        }
    }
}