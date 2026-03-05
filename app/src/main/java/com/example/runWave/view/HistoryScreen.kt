package com.example.runWave.view

import androidx.annotation.RestrictTo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.runWave.data.local.database.RunDatabase
import com.example.runWave.data.local.datastore.DataStoreManager
import com.example.runWave.data.local.entity.RunEntity
import com.example.runWave.data.repository.RunRepository
import com.example.runWave.data.repository.RunRepositoryImpl
import com.example.runWave.model.SessionManager
import com.example.runWave.navigation.Screens
import com.example.runWave.presenter.RunPresenter
import kotlinx.coroutines.launch

@Composable
fun HistoryScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var runs by remember { mutableStateOf<List<RunEntity>>(emptyList()) }


    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val db = RunDatabase.getDatabase(context)
    val runRepository = RunRepositoryImpl(db.runDao())
    val runPresenter = RunPresenter(runRepository)

    LaunchedEffect(Unit) {
        runs = runPresenter.getRun()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues())
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "This is history screen!",
                fontSize = 30.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                SessionManager.isLoggedIn = false
                SessionManager.username = ""

                scope.launch {
                    DataStoreManager.setLoggedIn(context, false)
                    DataStoreManager.saveUsername(context, "")
                }

                navController.navigate(Screens.Intro.route) {
                    popUpTo(0) { inclusive = true }
                }
            }
        ) {
            Text(
                text = "Intro"
            )
        }

        Button(
            onClick = {
                scope.launch {
                    val run = RunEntity(
                        distanceKm = 12.0,
                        durationSeconds = 3600,
                        dateTimeStart = System.currentTimeMillis(),
                        avgPace = 10.0
                    )
                    runPresenter.addRun(run)
                }
            }
        ) {
            Text("Insert test run")
        }
    }
}