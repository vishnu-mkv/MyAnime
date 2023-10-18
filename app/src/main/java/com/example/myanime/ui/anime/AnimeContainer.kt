package com.example.myanime.ui.anime

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.myanime.models.responses.Anime
import com.example.myanime.screens.Screens
import com.example.myanime.ui.common.ImageFromURL

@Composable
fun AnimeContainer(anime: Anime, navController: NavController) {

    val maxLength = 20
    val maxTitleLength = Math.min(anime.title?.length ?: 0, maxLength)
    var title = anime.title?.substring(0, maxTitleLength) ?: ""

    if (title.length == maxLength) {
        title += "..."
    }

    Column(
        Modifier
            .width(180.dp)
            .clickable(
                onClick = {
                    navController.navigate(Screens.getAnimeDetailRoute(anime.malId ?: 0))
                }
            )) {
       ImageFromURL(url = anime.images?.jpg?.imageUrl ?: "", modifier = Modifier
           .height(200.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, style = MaterialTheme.typography.bodyMedium)
    }
}