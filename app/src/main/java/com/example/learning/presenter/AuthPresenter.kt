package com.example.learning.presenter

import com.example.learning.model.SessionManager

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