package com.example.suspendfunctions.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FibonacciViewModel: ViewModel() {
    private val _fibonacci = MutableStateFlow(0)
    val fibonacci: StateFlow<Int> = _fibonacci

    suspend fun calculateFib(n: Int) {
        withContext(Dispatchers.Default) {
            _fibonacci.value = fibonacci(n)
        }
    }

    private fun fibonacci(n: Int): Int {
        return if (n <= 1) {
            n
        } else {
            fibonacci(n - 1) + fibonacci(n - 2)
        }
    }
}