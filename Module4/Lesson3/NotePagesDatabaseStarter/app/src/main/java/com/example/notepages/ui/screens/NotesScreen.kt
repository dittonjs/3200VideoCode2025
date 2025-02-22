package com.example.notepages.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notepages.viewmodels.NotesScreenViewModel

@Composable
fun NotesScreen(
    goToNoteModification: (id: Long?) -> Unit,
    viewModel: NotesScreenViewModel = viewModel()
) {
    val notes by viewModel.notes.collectAsState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.9f)
        ){
            items(notes) {
                Row (
                    modifier = Modifier.clickable {
                        goToNoteModification(it.id)
                    }
                ){
                    Text(it.title)
                }
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { goToNoteModification(null) }
        ) {
            Text("Create New Note")
        }
    }
}