package com.example.runWave.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.ui.components.HeaderAndNav
import com.example.runWave.ui.components.NavigationButton
import com.example.runWave.ui.components.RunWaveTextField
import com.example.runWave.ui.components.SwitchLogMethod
import com.example.runWave.ui.components.TermsAndServicesText
import com.example.runWave.ui.theme.RunBackground
import com.example.runWave.ui.theme.RunYellow

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    val passwordFocusRequester = remember { FocusRequester() }
    val scrollState = rememberScrollState()
    val focusManager = LocalFocusManager.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = RunBackground,
        topBar = {
            HeaderAndNav(text = "Login")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(start = 24.dp, end = 24.dp, top = 36.dp)
        ) {
            Text(
                text = "Welcome Back",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Ready to best your personal best? Sign in to continue your journey.",
                color = Color.White,
                fontWeight = FontWeight.W300,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "Email",
                color = Color.White,
                fontWeight = FontWeight.W400
            )

            Spacer(modifier = Modifier.height(10.dp))

            RunWaveTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "name@example.com",
                leadingIcon = Icons.Outlined.Email,
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(36.dp))

            Row {
                Text(
                    text = "Password",
                    fontWeight = FontWeight.W400,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Forgot Password?",
                    fontWeight = FontWeight.W300,
                    color = Color.Red,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(1f)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            // Implement navContorller here.
                            onForgotPasswordClick()
                        }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            RunWaveTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = "Enter Password",
                leadingIcon = Icons.Outlined.Lock,
                isPassword = true,
                imeAction = ImeAction.Done
            )

            Spacer(modifier = Modifier.height(24.dp))

            NavigationButton(
                "Login",
                RunYellow,
                Color.Black,
                null,
                onClick = onLoginClick,
                icon = Icons.AutoMirrored.Outlined.ArrowForward
            )

            Spacer(modifier = Modifier.height(36.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )

                Text(
                    text = "or",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                )

                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            NavigationButton(
                "Continue with Phone",
                RunBackground,
                Color.White,
                ButtonDefaults.outlinedButtonBorder(),
                icon = Icons.AutoMirrored.Outlined.ArrowForward,
                onClick = { /* Implement Phone Login */ }
            )

            Spacer(modifier = Modifier.height(36.dp))

            SwitchLogMethod(
                question = "New User?",
                logMethod = "Sign up",
                interactionSource = interactionSource,
                onClick = onSignUpClick
            )

            Spacer(modifier = Modifier.height(40.dp))

            TermsAndServicesText()

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginPagePreview() {
    LoginPage()
}
