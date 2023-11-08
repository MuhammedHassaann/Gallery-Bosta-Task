package com.muhammedhassaan.gallerytask.presentation.components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.muhammedhassaan.gallerytask.presentation.ui.theme.ThemeColors

@Composable
fun DividerComponent(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.ThemeColors.darkGray,
    thickness: Dp = 1.dp
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness
    )
}