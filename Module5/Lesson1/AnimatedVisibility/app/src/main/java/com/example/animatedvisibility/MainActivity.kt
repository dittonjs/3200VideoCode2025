package com.example.animatedvisibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatedvisibility.models.Todo
import com.example.animatedvisibility.ui.components.TodoItem
import com.example.animatedvisibility.ui.theme.AnimatedVisibilityTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            AnimatedVisibilityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val todos = remember{ mutableStateListOf(
                        Todo(id = 1, title = "Buy groceries", description = "Milk, Bread, Eggs, Butter, Cheese, Vegetables, Fruits, Cereal, Pasta, Rice, Chicken, Fish, Snacks, and other essential items for the week."),
                        Todo(id = 2, title = "Call mom", description = "Check in and say hello, ask about her day, discuss any recent events, and make plans for the upcoming family gathering."),
                        Todo(id = 3, title = "Finish project report", description = "Complete the final draft of the project report, including all sections such as introduction, methodology, results, discussion, and conclusion. Ensure all references are properly cited."),
                        Todo(id = 4, title = "Workout", description = "Go for a 30-minute run in the park, followed by a 15-minute strength training session focusing on core and upper body exercises. Cool down with stretching exercises."),
                        Todo(id = 5, title = "Read a book", description = "Read at least 50 pages of the current book, taking notes on important points and reflecting on the themes and characters. Consider writing a brief summary or review."),
                        Todo(id = 6, title = "Clean the house", description = "Vacuum and dust all rooms, clean the bathrooms, mop the floors, organize the living room, and take out the trash. Ensure all surfaces are sanitized."),
                        Todo(id = 7, title = "Pay bills", description = "Pay electricity and water bills online, review the statements for any discrepancies, and ensure all payments are recorded in the budget tracker."),
                        Todo(id = 8, title = "Plan weekend trip", description = "Decide on a destination for the weekend trip, research accommodation options, book a hotel, plan the itinerary, and make a list of activities and places to visit."),
                        Todo(id = 9, title = "Cook dinner", description = "Prepare a healthy meal including a main dish, side dish, and dessert. Use fresh ingredients and try a new recipe. Set the table and enjoy a relaxing dinner."),
                        Todo(id = 10, title = "Meditate", description = "Spend 15 minutes meditating in a quiet space, focusing on deep breathing and mindfulness. Reflect on the day and set intentions for the next day.")
                    )}
                    Box(
                        modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                    ){
                        LazyColumn(modifier = Modifier.padding(8.dp)){
                            items(todos) {
                                TodoItem(it, toggleCompletion = {
                                    val index = todos.indexOf(it)
                                    todos[index] = it.copy(isDone = !it.isDone)
                                })
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
