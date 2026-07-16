package com.example.runWave.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.R
import com.example.runWave.model.CountryProvider
import com.example.runWave.ui.components.CountryCodePicker
import com.example.runWave.ui.components.LogButton
import com.example.runWave.ui.components.PhoneTextField
import com.example.runWave.ui.components.SwitchLogMethod
import com.example.runWave.ui.theme.RunBackground
import com.example.runWave.ui.theme.RunYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneLogin(
    modifier: Modifier = Modifier,
    onSignUpClick: () -> Unit = {}
) {
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = RunBackground)
            .padding(WindowInsets.safeDrawing.asPaddingValues())
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.chatgpt_image_jul_4__2026__11_30_26_pm),
            contentDescription = "RunWave logo",
            modifier = modifier
                .size(size = 150.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Ready to run?",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Enter your phone number to continue your journey.",
            fontWeight = FontWeight.W300,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 72.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(56.dp))

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

        LogButton(
            text = "Send OTP",
            containerColor = RunYellow,
            contentColor = Color.Black,
            onClick = { /* Send OTP logic */ }
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

        LogButton(
            text = "Continue with Email",
            containerColor = RunBackground,
            contentColor = Color.White,
            border = ButtonDefaults.outlinedButtonBorder(),
            onClick = { /* continue with email logic when clicked */ }
        )

        Spacer(modifier = Modifier.height(36.dp))

        SwitchLogMethod(
            question = "New to RunTracker?",
            logMethod = "Create an Account",
            interactionSource = interactionSource,
            onClick = onSignUpClick
        )
    }
}





@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PhoneLoginPreview() {
    PhoneLogin()
}