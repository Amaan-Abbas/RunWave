package com.example.runWave.presenter

import com.example.runWave.model.SessionManager

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