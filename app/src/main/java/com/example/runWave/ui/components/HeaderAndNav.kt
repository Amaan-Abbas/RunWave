package com.example.runWave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.R
import com.example.runWave.ui.theme.RunBackground

@Composable
fun HeaderAndNav(
    modifier: Modifier = Modifier,
    text: String = "",
    isBackIconVisible: Boolean = true,
    isNotificationIconVisible: Boolean = false
) {
    Row(
        modifier = modifier.padding(bottom = 2.dp).statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (isBackIconVisible) {
            IconButton(
                onClick = {
                    /** todo **/
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
        } else {
            Image(
                contentDescription = "RunWave Logo",
                painter = painterResource(id = R.drawable.chatgpt_image_jul_4__2026__11_30_26_pm),
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
//                    .border(
//                        width = 0.2.dp,
//                        color = Color.White.copy(alpha = 0.5f)
//                    )
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 24.sp
        )

        if (isNotificationIconVisible) {
            IconButton(
                onClick = {
                    /** todo **/
                },
                enabled = false
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notification button",
                    tint = Color.White
                )
            }
        }
    }

    HorizontalDivider(thickness = 0.2.dp)
}

@Preview
@Composable
private fun HeaderAnNavPreview() {
    HeaderAndNav(
        isBackIconVisible = false,
        isNotificationIconVisible = true,
        modifier = Modifier.fillMaxWidth()
    )
}