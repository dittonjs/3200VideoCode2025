package com.example.stateflowwithlists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateflowwithlists.ui.theme.StateFlowWithListsTheme
import com.example.stateflowwithlists.viewmodels.NotesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: NotesViewModel by viewModels()
            val notes by viewModel.notes.collectAsState()
            val colors = listOf("Red", "Green", "Blue")
//            val notes = listOf<String>() // todo, remove this
            StateFlowWithListsTheme {
                Box(modifier = Modifier.safeDrawingPadding().padding(16.dp)) {
                    Column(modifier = Modifier.fillMaxSize()){
                        var input by remember { mutableStateOf("") }
                        TextField(
                            value = input,
                            onValueChange = {input = it},
                            label = { Text("Add a note") }
                        )
                        Button(
                            onClick = {
                                viewModel.addNote(input);
                                input = ""
                            }
                        ) {
                            Text("Add")
                        }
                        LazyColumn {
                            items(notes) { note ->
                                Row {
                                    Text(text = note)
                                    Button(onClick = {viewModel.removeNote(note)}) {
                                        Text("Delete")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
