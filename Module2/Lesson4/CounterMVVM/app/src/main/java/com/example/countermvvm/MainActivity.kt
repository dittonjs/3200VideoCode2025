package com.example.countermvvm

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.countermvvm.ui.theme.CounterMVVMTheme
import com.example.countermvvm.viewmodels.CounterViewModel

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "data")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel by viewModels<CounterViewModel>()
            val count by viewModel.counter.collectAsState()

            CounterMVVMTheme {
                Box(
                    modifier = Modifier
                        .safeDrawingPadding()
                        .padding(16.dp, 32.dp)
                ) {
                    Column {
                        Text("$count", fontSize = 128.sp)
                        Button(onClick = { viewModel.increment() }) {
                            Text("Increment")
                        }
                        Button(onClick = { viewModel.decrement() }) {
                            Text("Decrement")
                        }
                    }
                }
            }
        }
    }
}
