package com.example.notepages.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notepages.viewmodels.NotesScreenViewModel

@Composable
fun NotesScreen(
    goToNoteModification: (id: Int?) -> Unit,
    notesScreenViewModel: NotesScreenViewModel = viewModel<NotesScreenViewModel>()
) {
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
            // TODO: Display Items
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { goToNoteModification(null) }
        ) {
            Text("Create New Note")
        }
    }
}