package com.example.runWave.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.runWave.model.DataStoreManager
import com.example.runWave.model.SessionManager
import com.example.runWave.view.HistoryScreen
import com.example.runWave.view.HomeScreen
import com.example.runWave.view.IntroScreen
import com.example.runWave.view.LoginScreen
import kotlinx.coroutines.flow.first

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var isReady by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val storedValue = DataStoreManager.isLoggedIn(context).first()
        val storedName = DataStoreManager.getUsername(context).first()

        SessionManager.isLoggedIn = storedValue
        SessionManager.username = storedName

        isReady = true
    }

    if (isReady) {
        NavHost(
            navController = navController,
            startDestination = if (!SessionManager.isLoggedIn) {
                Screens.Intro.route
            } else {
                Screens.Home.route
            },
            modifier = Modifier
        ) {
            composable(Screens.Intro.route) {
                IntroScreen(navController)
            }

            composable(Screens.Login.route) {
                LoginScreen(navController = navController)
            }

            composable(
                Screens.Home.route,
            ) {
                if (!SessionManager.isLoggedIn) {
                    LaunchedEffect(Unit) {
                        navController.navigate(Screens.Intro.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                } else {
                    HomeScreen(
                        navController = navController
                    )
                }
            }

            composable(Screens.History.route) {
                if (!SessionManager.isLoggedIn) {
                    LaunchedEffect(Unit) {
                        navController.navigate(Screens.Intro.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                } else {
                    HistoryScreen(navController = navController)
                }
            }
        }
    }
}