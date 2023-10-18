package com.example.myanime.ui.anime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myanime.models.responses.Genres

@Composable
fun GenreContainer(
    genre: Genres,
    modifier : Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(8.dp))
            .padding(16.dp, 8.dp)
    ) {
        Text(text = genre.name ?: "", style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary)
    }
}