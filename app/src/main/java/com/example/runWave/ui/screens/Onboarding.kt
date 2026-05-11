package com.example.runWave.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bolt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.R
import com.example.runWave.ui.theme.RunBackground
import com.example.runWave.ui.theme.RunYellow

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier
//    navController: NavController
) {

    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(RunBackground)
            .padding(WindowInsets.safeDrawing.asPaddingValues())
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .shadow(
                    elevation = 30.dp,
                    shape = RoundedCornerShape(20.dp),
                    ambientColor = RunYellow,
                    spotColor = RunYellow
                )
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(30.dp))

        Icon(
            imageVector = Icons.Outlined.Bolt,
            contentDescription = "App Icon",
            modifier = Modifier
                .size(55.dp)
                .background(color = RunYellow, shape = CircleShape)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(R.string.track_your_runs),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(R.string.stay_consistent),
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            color = RunYellow
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(R.string.OnBoarding_tagLine),
            color = Color.White,
            fontWeight = FontWeight.W300,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.height(50.dp))

        LogButton("Sign up", RunYellow, Color.Black, null)

        Spacer(modifier = Modifier.height(10.dp))

        LogButton("Login", RunBackground, Color.White, ButtonDefaults.outlinedButtonBorder())

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.Terms_and_Services),
            fontWeight = FontWeight.W300,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.9f)
        )
    }
}

@Composable
fun LogButton(text: String, containerColor: Color, contentColor: Color, border: BorderStroke?) {
    Button(
        onClick = {
            // TODO:
        },
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        border = border
    ) {
        Text(
            text = text
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun OnboardingPreview() {
//    val navController = rememberNavController()
    OnboardingPage(
        modifier = Modifier
//        navController = navController
    )
}