package com.example.runWave.ui.screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.model.CountryProvider
import com.example.runWave.ui.components.CountryCodePicker
import com.example.runWave.ui.components.HeaderAndNav
import com.example.runWave.ui.components.NavigationButton
import com.example.runWave.ui.components.PhoneTextField
import com.example.runWave.ui.components.RunWaveTextField
import com.example.runWave.ui.components.SwitchLogMethod
import com.example.runWave.ui.theme.RunBackground
import com.example.runWave.ui.theme.RunYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneSignUp(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    var input by remember { mutableStateOf("") }
    var selectedCountry by remember { mutableStateOf(CountryProvider.allCountries[0]) }
    val focusManager = LocalFocusManager.current

    val interactionSource = remember { MutableInteractionSource() }

    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            containerColor = RunBackground
        ) {
            CountryCodePicker(
                onCountrySelected = {
                    selectedCountry = it
                    showSheet = false
                }
            )
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = RunBackground,
        topBar = {
            HeaderAndNav(text = "Sign Up")
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 36.dp)
        ) {
            item {
                Text(
                    text = "Create Account",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Create an account to start tracking your runs and reaching your goals.",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W300
                )

                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                Text(
                    text = "Full Name",
                    color = Color.White,
                    fontWeight = FontWeight.W400
                )

                Spacer(modifier = Modifier.height(8.dp))

                RunWaveTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = "Enter your name",
                    leadingIcon = Icons.Outlined.Person2,
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Text(
                    text = "Phone Number",
                    color = Color.White.copy(0.8f),
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(12.dp))

                PhoneTextField(
                    value = input,
                    onValueChange = { input = it },
                    selectedCountry = selectedCountry,
                    onLeadingIconCLick = { showSheet = true },
                    placeHolder = "Enter phone number",
                    keyboardType = KeyboardType.Phone,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "* We will send a 6 digit verification code to your number. SMS charges may apply.",
                    color = Color.White.copy(0.7f)
                )

                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                NavigationButton(
                    text = "Send OTP",
                    containerColor = RunYellow,
                    contentColor = Color.Black,
                    icon = Icons.AutoMirrored.Outlined.ArrowForward,
                    onClick = { /* Send OTP logic */ }
                )

                Spacer(modifier = Modifier.height(36.dp))
            }

            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )

                    Text(
                        text = "OR",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                    )

                    HorizontalDivider(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(36.dp))
            }

            item {
                NavigationButton(
                    text = "Continue with Email",
                    containerColor = RunBackground,
                    contentColor = Color.White,
                    border = ButtonDefaults.outlinedButtonBorder(),
                    icon = Icons.AutoMirrored.Outlined.ArrowForward,
                    onClick = { /* continue with email logic when clicked */ }
                )

                Spacer(modifier = Modifier.height(36.dp))
            }

            item {
                SwitchLogMethod(
                    question = "New to RunTracker?",
                    logMethod = "Create an Account",
                    interactionSource = interactionSource,
                    onClick = onSignUpClick
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun PhoneSignUpPreview() {
    PhoneSignUp()
}
