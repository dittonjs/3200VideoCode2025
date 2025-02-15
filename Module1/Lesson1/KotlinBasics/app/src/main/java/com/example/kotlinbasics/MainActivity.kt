package com.example.kotlinbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinbasics.ui.theme.KotlinBasicsTheme
import java.util.Locale
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = buildRandomList()
        val result = findWhere(list) {
            it > 100 && it < 150
        }

        list.forEach {
            println(it)
        }

        println(result)

        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Joseph",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun findWhere(list: List<Double>, predicate: (Double) -> Boolean): Double? {
    for (item in list) {
        if (predicate(item)) {
            return item
        }
    }
    return null
}


fun buildRandomList(): List<Double> {
    val list = mutableListOf<Double>()
    val random = Random(System.currentTimeMillis())
    for (i in 1..10000) {
        list.add(random.nextDouble() * 100000)
    }
    return list
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}