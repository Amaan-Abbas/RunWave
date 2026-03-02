package com.example.RunWave.presenter

import com.example.RunWave.model.SessionManager

// auth
class AuthPresenter {
    fun login(username: String): Boolean {
        return if (username.isNotBlank()) {
            SessionManager.isLoggedIn = true
            SessionManager.username = username
            true
        } else {
            false
        }
    }
}