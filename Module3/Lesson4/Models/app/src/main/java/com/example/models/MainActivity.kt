package com.example.models

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.models.models.Note
import com.example.models.ui.theme.ModelsTheme
import com.example.models.viewmodels.HomePageViewModel

var noteId = 0

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: HomePageViewModel by viewModels()
            val notes by viewModel.notes.collectAsState()
            ModelsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ){
                        var noteContent by remember{ mutableStateOf("") }
                        TextField(
                            value = noteContent,
                            onValueChange = { noteContent = it },
                            label = { Text("Enter your note content") },
                        )
                        Button(onClick={
                            viewModel.addNote(
                                Note(
                                    id = noteId++,
                                    content = noteContent
                                )
                            )
                            noteContent = ""
                        }) {
                            Text("Add note")
                        }
                        LazyColumn {
                            items(notes) { note ->
                                Text(note.content)
                            }
                        }
                    }
                }
            }
        }
    }
}
