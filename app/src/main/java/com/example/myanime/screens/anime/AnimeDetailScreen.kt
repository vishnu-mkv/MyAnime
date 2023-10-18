package com.example.myanime.screens.anime

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myanime.screens.Screens
import com.example.myanime.ui.anime.GenreContainer
import com.example.myanime.ui.common.ImageFromURL
import com.example.myanime.ui.common.Loader
import com.example.myanime.viewmodel.AnimeDetailViewModel

@Composable
fun AnimeDetailScreen(
    id: String,
    navController: NavController,
    animeVm: AnimeDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = id) {
        animeVm.getAnimeDetail(id)
    }

    val anime = animeVm.anime
    val scrollState = rememberScrollState()
    val MAX_SYNOPSIS_LENGTH = 180
    val loading = animeVm.isLoading

    val synopsis = (anime.synopsis ?: "").let {
        if (it.length > MAX_SYNOPSIS_LENGTH) {
            it.substring(0, MAX_SYNOPSIS_LENGTH) + "..."
        } else {
            it
        }
    }

    if (loading) Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Loader()
    }
    else
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            ImageFromURL(
                url = anime.images?.jpg?.largeImageUrl ?: "", modifier = Modifier
                    .height(350.dp)
            )

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = anime.title ?: "", style = MaterialTheme.typography.titleLarge)
                Text(text = synopsis, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(0.dp))
                Text(
                    text = "Genres",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.ExtraBold
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(anime.genres) { genre ->
                        GenreContainer(genre = genre)
                    }
                }
            }
        }

}