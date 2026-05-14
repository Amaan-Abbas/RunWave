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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.R
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RunBackground)
            .padding(WindowInsets.safeDrawing.asPaddingValues())
    ) {

        HeaderAndNav(text = "Login")

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
                            // TODO: Implement navController here
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

            LogButton("Login", RunYellow, Color.Black, null, onClick = onLoginClick)

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

            LogButton(
                "Continue with Phone",
                RunBackground,
                Color.White,
                ButtonDefaults.outlinedButtonBorder(),
                onClick = { /* Implement Phone Login */ }
            )

            Spacer(modifier = Modifier.height(36.dp))

            SwitchLogMethod(
                question = "New User?",
                logMethod = "Sign up",
                interactionSource = interactionSource
            )

            Spacer(modifier = Modifier.height(40.dp))

            TermsAndServicesText()

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun RunWaveTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    isPassword: Boolean = false,
    singleLine: Boolean = true,
    errorText: String? = null
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            Text(text = placeholder, color = Color.Gray)
        },
        singleLine = singleLine,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = leadingIcon?.let {
            { Icon(imageVector = it, contentDescription = null) }
        },
        trailingIcon = if (isPassword) {
            {
                val image =
                    if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

                IconButton(onClick = {
                    passwordVisible = !passwordVisible
                }) {
                    Icon(
                        imageVector = image,
                        contentDescription = "Toggle Password"
                    )
                }
            }
        } else null,

        visualTransformation = if (isPassword && !passwordVisible)
            PasswordVisualTransformation(mask = '\u2022')
        else
            VisualTransformation.None,

        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,

        colors = loginTextFieldColors(),
        isError = errorText != null,
        supportingText = errorText?.let {
            {
                Text(text = it, color = Color.Red)
            }
        }

    )
}

@Composable
fun HeaderAndNav(
    modifier: Modifier = Modifier,
    text: String = ""
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
                tint = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .background(color = RunBackground)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 24.sp
        )
    }

    HorizontalDivider(thickness = 0.2.dp)
}

@Composable
fun loginTextFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = Color.White,
    unfocusedTextColor = Color.White,
    focusedBorderColor = Color.White,
    unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f),
    cursorColor = Color.White,
    focusedLeadingIconColor = Color.White,
    unfocusedLeadingIconColor = Color.White.copy(alpha = 0.7f),
    focusedTrailingIconColor = Color.White,
    unfocusedTrailingIconColor = Color.White.copy(alpha = 0.7f)
)

@Composable
fun TermsAndServicesText() {
    val fullText = stringResource(R.string.Terms_and_Services)
    val tosPart = "Terms of Service"
    val ppPart = "Privacy Policy"

    val annotatedString = buildAnnotatedString {
        val tosIndex = fullText.indexOf(tosPart)
        val ppIndex = fullText.indexOf(ppPart)

        if (tosIndex != -1 && ppIndex != -1) {
            append(fullText.substring(0, tosIndex))
            withLink(LinkAnnotation.Clickable("tos") { /* Open TOS */ }) {
                withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = RunYellow)) {
                    append(tosPart)
                }
            }
            append(fullText.substring(tosIndex + tosPart.length, ppIndex))
            withLink(LinkAnnotation.Clickable("pp") { /* Open Privacy Policy */ }) {
                withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = RunYellow)) {
                    append(ppPart)
                }
            }
            append(fullText.substring(ppIndex + ppPart.length))
        } else {
            append(fullText)
        }
    }

    Text(
        text = annotatedString,
        color = Color.Gray,
        textAlign = TextAlign.Center,
        fontSize = 13.sp,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SwitchLogMethod(
    modifier: Modifier = Modifier,
    question: String,
    logMethod: String,
    interactionSource: MutableInteractionSource
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = question,
            fontWeight = FontWeight.W300,
            color = Color.White
        )

        Spacer(modifier = Modifier.width(7.dp))

        Text(
            text = logMethod,
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
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginPagePreview() {
    LoginPage()
}