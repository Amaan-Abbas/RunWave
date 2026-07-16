package com.example.runWave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.ui.theme.RunBackground

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
            fontSize = 24.sp,

            )
    }

    HorizontalDivider(thickness = 0.2.dp)
}