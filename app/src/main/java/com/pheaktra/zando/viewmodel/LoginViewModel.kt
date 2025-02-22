package com.pheaktra.zando.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var isLoggedIn = mutableStateOf(false)
    var username = mutableStateOf<String?>(null)

    fun logIn(username: String) {
        this.username.value = username
        isLoggedIn.value = true
    }

    fun logOut() {
        this.username.value = null
        isLoggedIn.value = false
    }
}

