package com.example.fistprojectcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.example.fistprojectcompose.presentation.ui.theme.FistProjectComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FistProjectComposeTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}
