package com.example.myanime.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun ImageFromURL(url:String, modifier: Modifier=Modifier)
{
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        loading = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface))
        },
        error = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.error))
        },
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
    )
}