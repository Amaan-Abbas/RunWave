package com.example.runWave.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.runWave.data.local.datastore.DataStoreManager
import com.example.runWave.navigation.Screens
import com.example.runWave.presenter.AuthPresenter
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val presenter = AuthPresenter()
    var input by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            OutlinedTextField(
                value = input,
                onValueChange = { text ->
                    input = text
                    // Also a good idea to clear the error when the user starts typing
                    if (errorMessage != null) {
                        errorMessage = null
                    }
                },
                placeholder = {
                    Text(
                        text = "Enter you name...",
                        color = Color.Gray
                    )
                },
                modifier = Modifier.padding(10.dp)
            )

            errorMessage?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    // Add start padding to align with the text field's internal padding
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    val isValid = presenter.login(input)
                    if (isValid) {

                        scope.launch {
                            DataStoreManager.setLoggedIn(context, true)
                            DataStoreManager.saveUsername(context, input)
                        }

                        navController.navigate(Screens.Home.route)
                    } else {
                        errorMessage = "Enter a valid input!"
                    }
                }
            ) {
                Text(
                    text = "Home"
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    navController.navigate(Screens.Intro.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            ) {
                Text("Intro")
            }
        }
    }
}