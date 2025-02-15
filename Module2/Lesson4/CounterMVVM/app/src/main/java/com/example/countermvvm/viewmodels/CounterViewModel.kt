package com.example.countermvvm.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel: ViewModel() {
    private var _counter = MutableStateFlow(0)
    val counter: StateFlow<Int>
        get() = _counter

    fun increment() {
        _counter.value++
    }

    fun decrement() {
        _counter.value--
    }

    fun reset() {
        _counter.value = 0
    }
}