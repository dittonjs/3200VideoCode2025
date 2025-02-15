package com.example.simplenoteswithoutbackend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplenoteswithoutbackend.ui.components.Note
import com.example.simplenoteswithoutbackend.ui.theme.SimpleNotesWithoutBackendTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleNotesWithoutBackendTheme {
                Box(
                    modifier = Modifier
                        .safeDrawingPadding()
                        .padding(16.dp, 32.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ){
                        var noteContent by remember { mutableStateOf("") }
                        val notes = remember { mutableStateListOf<String>()}
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = noteContent,
                            onValueChange = { noteContent = it }
                        )
                        Button(onClick = {
                            notes.add(noteContent)
                            noteContent = ""
                        }) {
                            Text("Save")
                        }
                        LazyColumn {
                            items(notes) {
                                Note(it, deleteNote = { notes.remove(it) })
                            }
                        }
                    }
                }
            }
        }
    }
}
