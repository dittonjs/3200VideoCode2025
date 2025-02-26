package com.example.todosdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
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
import com.example.todosdatabase.models.Todo
import com.example.todosdatabase.ui.theme.TodoItem
import com.example.todosdatabase.ui.theme.TodosDatabaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val todos = remember{ mutableStateListOf<Todo>()}
            var content by remember{ mutableStateOf("") }
            TodosDatabaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Text(text = "Todos")
                        Row (
                            modifier = Modifier.fillMaxWidth()
                        ){
                            TextField(
                                value = content,
                                onValueChange = {content = it},
                                label = { Text("Todo Item") },
                                modifier = Modifier.weight(1f)
                            )
                            Button(
                                onClick = {
                                    todos += Todo(
                                        content = content,
                                        isCompleted = false
                                    )
                                    content = ""
                                },
                            ) {
                                Text("Add")
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyColumn {
                            items(todos) {
                                TodoItem(
                                    todo = it,
                                    onCheckChanged = { isChecked ->
                                        val index = todos.indexOf(it)
                                        todos[index] = it.copy(isCompleted = isChecked)
                                    }
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
