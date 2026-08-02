package com.example.runWave.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.runWave.ui.theme.RunYellow

@Composable
fun NavigationButton(
    text: String,
    containerColor: Color,
    contentColor: Color,
    border: BorderStroke? = null,
    icon: ImageVector? = null,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        border = border,
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = text
        )

        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "Next/start button icon"
            )
        }
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    NavigationButton(
        text = "Next",
        containerColor = RunYellow,
        contentColor = Color.White,
        icon = Icons.AutoMirrored.Outlined.ArrowForward,
        onClick = {}
    )
}