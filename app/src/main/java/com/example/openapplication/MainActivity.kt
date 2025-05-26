package com.example.openapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.openapplication.ui.theme.OpenapplicationTheme
import com.example.openapplication.viewmodel.OpenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: OpenViewModel by viewModels()
        setContent {
            OpenapplicationTheme {
                AppNavHost(viewModel)
            }
        }
    }
}
