package com.example.runWave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.House
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.runWave.navigation.Screens
import com.example.runWave.ui.theme.CardBackground
import com.example.runWave.ui.theme.RunYellow

//This page needs to look at the functioning of the bottom navigation bar. Agent has done some work which
//I believe is either static or not okay or not so good. Do look at it when working on the logic.

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    currentRoute: String? = Screens.Home.route,
    onHomeClick: () -> Unit = {},
    onHistoryClick: () -> Unit = {},
    onAchievementsClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Subtle top border for visual separation
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray.copy(alpha = 0.15f),
            thickness = 1.dp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(color = CardBackground)
                .navigationBarsPadding(), // Slightly lighter surface than main background
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Home Slot
            NavigationItem(
                modifier = Modifier.weight(1f),
                icon = Icons.Rounded.House,
                contentDescription = "Home",
                isActive = currentRoute == Screens.Home.route,
                onClick = onHomeClick
            )

            VerticalDivider(
                modifier = Modifier.height(24.dp),
                color = Color.Gray.copy(alpha = 0.3f),
                thickness = 1.dp
            )

            // History Slot
            NavigationItem(
                modifier = Modifier.weight(1f),
                icon = Icons.Outlined.Description,
                contentDescription = "History",
                isActive = currentRoute == Screens.History.route,
                onClick = onHistoryClick
            )

            VerticalDivider(
                modifier = Modifier.height(24.dp),
                color = Color.Gray.copy(alpha = 0.3f),
                thickness = 1.dp
            )

            // Achievements Slot
            NavigationItem(
                modifier = Modifier.weight(1f),
                icon = Icons.Outlined.EmojiEvents,
                contentDescription = "Achievements",
                isActive = false, // Not implemented yet
                onClick = onAchievementsClick
            )

            VerticalDivider(
                modifier = Modifier.height(24.dp),
                color = Color.Gray.copy(alpha = 0.3f),
                thickness = 1.dp
            )

            // Settings Slot
            NavigationItem(
                modifier = Modifier.weight(1f),
                icon = Icons.Outlined.Settings,
                contentDescription = "Settings",
                isActive = false, // Not implemented yet
                onClick = onSettingsClick
            )
        }
    }
}

@Composable
private fun NavigationItem(
    modifier: Modifier = Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    contentDescription: String,
    isActive: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = if (isActive) RunYellow else Color.Gray.copy(alpha = 0.6f)
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    BottomNavigation()
}