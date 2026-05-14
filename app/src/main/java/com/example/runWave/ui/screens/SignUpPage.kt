package com.example.runWave.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.ui.theme.RunBackground
import com.example.runWave.ui.theme.RunYellow

@Composable
fun SignUpPage(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RunBackground)
            .padding(WindowInsets.safeDrawing.asPaddingValues())
    ) {
        HeaderAndNav(text = "Sign Up")

        LazyColumn(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 36.dp)
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
                    text = "Join our energetic community and start you journey today.",
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
                    keyboardType = KeyboardType.Text
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Email",
                    color = Color.White,
                    fontWeight = FontWeight.W400
                )

                Spacer(modifier = Modifier.height(8.dp))

                RunWaveTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "name@example.com",
                    leadingIcon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Password",
                    color = Color.White,
                    fontWeight = FontWeight.W400
                )

                Spacer(modifier = Modifier.height(8.dp))

                RunWaveTextField(
                    value = password,
                    onValueChange = { password = it },
                    leadingIcon = Icons.Outlined.Lock,
                    placeholder = "Enter Password",
                    isPassword = true,
                    keyboardType = KeyboardType.Password
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Confirm Password",
                    color = Color.White,
                    fontWeight = FontWeight.W400
                )

                Spacer(modifier = modifier.height(8.dp))

                RunWaveTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = "Re-enter Password",
                    isPassword = true,
                    leadingIcon = Icons.Outlined.Lock,
                    keyboardType = KeyboardType.Password
                )

                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                LogButton(
                    text = "Sign Up",
                    containerColor = RunYellow,
                    contentColor = Color.Black,
                    onClick = onSignUpClick
                )

                Spacer(modifier = Modifier.height(40.dp))

                SwitchLogMethod(
                    question = "Already have an account?",
                    logMethod = "Login",
                    interactionSource = interactionSource
                )

                Spacer(modifier = Modifier.height(48.dp))
            }

            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 0.2.dp
                    )

                    Text(
                        text = "Or continue with",
                        color = Color.White.copy(0.8f),
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )

                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 0.2.dp
                    )
                }
                Spacer(modifier = Modifier.height(48.dp))
            }

            item {
                LogButton(
                    text = "Continue with Google",
                    containerColor = RunBackground,
                    contentColor = Color.White,
                    border = ButtonDefaults.outlinedButtonBorder(),
                    onClick = {
                        // TODO:
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                LogButton(
                    text = "Continue with Phone",
                    containerColor = RunBackground,
                    contentColor = Color.White,
                    border = ButtonDefaults.outlinedButtonBorder(),
                    onClick = {
                        // TODO:
                    }
                )

                Spacer(modifier = Modifier.height(48.dp))

                TermsAndServicesText()

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun SignUpPagePreview() {
    SignUpPage()
}