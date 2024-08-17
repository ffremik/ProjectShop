package com.example.projectmoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.projectmoon.ui.theme.ProjectMoonTheme
import com.example.projectmoon.view.navigation.view.ScreenNavigationHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectMoonTheme {
                ScreenNavigationHost()
            }
        }
    }
}

