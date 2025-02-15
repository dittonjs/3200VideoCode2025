package com.example.notepages.ui.screens

import android.window.BackEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notepages.viewmodels.NoteModificationScreenViewModel

@Composable
fun NoteModificationScreen(
    id: Int?,
    goBack: () -> Unit,
    noteModificationScreenViewModel: NoteModificationScreenViewModel = viewModel<NoteModificationScreenViewModel>()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.End
    ){
        var title by remember { mutableStateOf("") }
        var content by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            modifier = Modifier.fillMaxWidth().weight(1f),
            value = content,
            onValueChange = { content = it },
            label = { Text("Content") },
        )
        Button(onClick = {
            // TODO: Save Note
            goBack()
        }) {
            Text("Save")
        }
    }
}