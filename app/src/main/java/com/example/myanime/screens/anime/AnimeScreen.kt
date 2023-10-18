package com.example.myanime.screens.anime

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myanime.ui.anime.AnimeContainer
import com.example.myanime.ui.common.InputField
import com.example.myanime.ui.common.PageLoader
import com.example.myanime.viewmodel.AnimeSearchViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import java.util.Timer

@Composable
fun AnimeScreen(
    navController: NavController,
    vm: AnimeSearchViewModel = hiltViewModel()
) {

    val scrollState = rememberLazyGridState()
    var searchTerm by remember {
        mutableStateOf(vm.searchTerms)
    }
    val scope = rememberCoroutineScope()
    var searchJob by remember {
        mutableStateOf<Job?>(null)
    }

    val endOfListReached by remember {
        derivedStateOf {
            scrollState.isScrolledToEnd()
        }
    }

    LaunchedEffect(key1 = endOfListReached ) {
        if(endOfListReached) {
            vm.loadMore()
        }
    }

    LaunchedEffect(key1 = searchTerm) {
        // if no input in .5 seconds, search
        searchJob?.cancel()
        searchJob = scope.launch {
            delay(500)
            vm.searchAnime(searchTerm)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 16.dp, 8.dp, 0.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        InputField(label = "Search", value = searchTerm,
            onValueChange = {searchTerm = it})

        LazyVerticalGrid(columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            state = scrollState,
            ) {
            items(vm.animes.count()) {
                AnimeContainer(anime = vm.animes[it], navController)
            }
        }

        if(vm.isLoading) {
            PageLoader()
        }
    }

}
fun LazyGridState.isScrolledToEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1