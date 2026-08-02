package com.example.runWave.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.ui.components.BottomNavigation
import com.example.runWave.ui.components.HeaderAndNav
import com.example.runWave.ui.components.IncompleteProfPop
import com.example.runWave.ui.components.NavigationButton
import com.example.runWave.ui.components.RunFlashCard
import com.example.runWave.ui.theme.RunBackground
import com.example.runWave.ui.theme.RunYellow

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            HeaderAndNav(
                modifier = Modifier.fillMaxWidth(),
                isBackIconVisible = false,
                isNotificationIconVisible = true
            )
        },
        bottomBar = {
            BottomNavigation()
        },
        containerColor = RunBackground,
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 28.dp)
        ) {
            item {
                Text(
                    text = "Hi, Amaan 👋",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
            }

            item {
                Text(
                    text = "Welcome! Ready for the run?",
                    color = Color.White,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                RunFlashCard(
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                NavigationButton(
                    text = "Start Run",
                    onClick = { /* todo */ },
                    icon = Icons.Outlined.PlayArrow,
                    containerColor = RunYellow,
                    contentColor = Color.Black
                )

                Spacer(modifier = Modifier.height(12.dp))
            }

            item {
                NavigationButton(
                    text = "Destination Run",
                    onClick = { /** todo **/ },
                    icon = Icons.Outlined.LocationOn,
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                    border = ButtonDefaults.outlinedButtonBorder()
                )

                Spacer(modifier = Modifier.height(20.dp))
            }

            /** This part will only be made active only when the user has not completed their profile.
            This part needs logic for when this banner will be shown, navigation for the user to go to the profile and user action of closing the banner. **/
            item {
                IncompleteProfPop()

                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                Text(
                    text = "Recent activity",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            //Add recent run summary of last 3 runs(?) or short data.
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}