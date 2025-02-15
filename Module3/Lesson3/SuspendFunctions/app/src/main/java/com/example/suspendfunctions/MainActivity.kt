package com.example.suspendfunctions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.suspendfunctions.ui.theme.SuspendFunctionsTheme
import com.example.suspendfunctions.viewmodels.FibonacciViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel by viewModels<FibonacciViewModel>()
            val fibonacci by viewModel.fibonacci.collectAsState()
            val coroutineScope = rememberCoroutineScope { Dispatchers.Default }
            SuspendFunctionsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        var input by remember { mutableStateOf("") }
                        Text(text = "Result: $fibonacci")
                        TextField(
                            value = input,
                            onValueChange = { input = it }
                        )
                        Button(onClick = {
                            coroutineScope.launch {
                                viewModel.calculateFib(input.toIntOrNull() ?: 0)
                            }
                        }) {
                            Text("Compute Fib")
                        }
                    }
                }
            }
        }
    }
}
