package com.example.simplesideeffects

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginScreenViewModel: ViewModel() {
    var password by mutableStateOf("")
    var isPasswordValid by mutableStateOf(false)

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun clearPassword() {
        password = ""
    }
}