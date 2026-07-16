package com.example.runWave.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.runWave.ui.theme.RunYellow

@Composable
fun SwitchLogMethod(
    modifier: Modifier = Modifier,
    question: String,
    logMethod: String,
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
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
                    onClick()
                }
        )
    }
}