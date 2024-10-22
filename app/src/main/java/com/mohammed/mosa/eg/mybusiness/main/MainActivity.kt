package com.mohammed.mosa.eg.mybusiness.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mohammed.mosa.eg.mybusiness.test.LicenseForm
import com.mohammed.mosa.eg.mybusiness.ui.theme.MyBusinessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBusinessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LicenseForm(onSubmit = {}, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

