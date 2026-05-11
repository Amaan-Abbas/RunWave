package com.example.runWave.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.R
import com.example.runWave.ui.theme.RunBackground
import com.example.runWave.ui.theme.RunYellow

@Composable
fun LoginPage(
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RunBackground)
            .padding(WindowInsets.safeDrawing.asPaddingValues())
    ) {

        Row(
            modifier = Modifier.padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {

                }) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Go back button",
                    modifier = Modifier
                        .padding(8.dp)
                        .background(color = RunBackground)
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp
            )
        }

        HorizontalDivider(thickness = 0.2.dp)

        Column(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 36.dp)
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

            EmailInputBox()

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
                            // TODO: Implement navController here
                        }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            PasswordInputBox()

            Spacer(modifier = Modifier.height(24.dp))

            LogButton("Login", RunYellow, Color.Black, null)

            Spacer(modifier = Modifier.height(36.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(modifier = Modifier.weight(1f))

                Text(
                    text = "or",
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                )

                HorizontalDivider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(36.dp))

            LogButton(
                "Continue with Phone",
                RunBackground,
                Color.White,
                ButtonDefaults.outlinedButtonBorder()
            )

            Spacer(modifier = Modifier.height(36.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "New User?",
                    fontWeight = FontWeight.W300,
                    color = Color.White
                )

                Spacer(modifier = Modifier.width(7.dp))

                Text(
                    text = "Sign up",
                    fontWeight = FontWeight.W500,
                    color = RunYellow,
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            // TODO: Implement navController
                        }
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = stringResource(id = R.string.Terms_and_Services),
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun EmailInputBox(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = "name@example.com", color = Color.Gray
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.7f)
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f),
            cursorColor = Color.White
        )
    )
}

@Composable
fun PasswordInputBox(modifier: Modifier = Modifier) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Key,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.9f)
            )
        },
        placeholder = {
            Text(
                text = "Enter Password", color = Color.Gray
            )
        },
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        visualTransformation = if (passwordVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation(mask = '\u2022'),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else
                Icons.Filled.VisibilityOff

            val description = if (passwordVisible)
                "Hide Password"
            else
                "Show Password"

            IconButton(
                onClick = {
                    passwordVisible = !passwordVisible
                }
            ) {
                Icon(
                    imageVector = image,
                    contentDescription = description
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun LoginPagePreview() {
    LoginPage()
}