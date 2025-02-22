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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.todosdatabase.models.Todo
import com.example.todosdatabase.ui.theme.TodoItem
import com.example.todosdatabase.ui.theme.TodosDatabaseTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "todos-database"
        ).build()

        setContent {
            val todos = remember{ mutableStateListOf<Todo>()}
            var content by remember{ mutableStateOf("") }
            val scope = rememberCoroutineScope()

            LaunchedEffect(Unit) {
                launch(Dispatchers.IO){
                    todos += db.todosDao.getAllTodos()
                }
            }

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
                                    scope.launch(Dispatchers.IO){
                                        val todo = Todo(
                                            content = content,
                                            isCompleted = false
                                        )
                                        todo.id = db.todosDao.insertTodo(todo)
                                        todos += todo
                                        content = ""
                                    }
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
                                        scope.launch(Dispatchers.IO){
                                            val index = todos.indexOf(it)
                                            val todo = it.copy(isCompleted = isChecked)
                                            db.todosDao.updateTodo(todo)
                                            todos[index] = todo
                                        }
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
