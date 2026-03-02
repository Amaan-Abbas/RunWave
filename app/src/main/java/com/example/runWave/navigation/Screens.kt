package com.example.runWave.navigation

// This file defines the routes to the screens.
sealed class Screens(val route: String) {
    object Intro : Screens("intro")
    object Login : Screens("login")
    object Home : Screens("home")
    object History : Screens("history")
}