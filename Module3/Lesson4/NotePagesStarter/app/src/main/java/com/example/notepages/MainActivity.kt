package com.example.notepages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.notepages.ui.screens.NoteModificationScreen
import com.example.notepages.ui.screens.NotesScreen
import com.example.notepages.ui.theme.NotePagesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NotePagesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Note Pages") },
                        )
                    },
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.Notes,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Destinations.Notes> {
                            NotesScreen(
                                goToNoteModification = { id -> navController.navigate(Destinations.NoteModification(id)) },
                            )
                        }
                        composable<Destinations.NoteModification> {
                            NoteModificationScreen(
                                id = it.toRoute<Destinations.NoteModification>().noteId,
                                goBack = { navController.popBackStack() },
                            )
                        }
                    }
                }
            }
        }
    }
}
