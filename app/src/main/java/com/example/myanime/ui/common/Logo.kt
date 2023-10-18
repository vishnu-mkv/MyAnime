package com.example.myanime.ui.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Logo(color: Color = MaterialTheme.colorScheme.onPrimary) {
    Text(text = "MY ANIME",
        style = MaterialTheme.typography.titleLarge,
        color= color)
}
