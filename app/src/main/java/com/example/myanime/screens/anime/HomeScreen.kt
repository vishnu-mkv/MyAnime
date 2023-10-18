package com.example.myanime.screens.anime

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import com.example.myanime.screens.Screens
import com.example.myanime.ui.anime.AnimeContainer
import com.example.myanime.ui.common.Loader
import com.example.myanime.ui.common.PageLoader
import com.example.myanime.viewmodel.HomeViewModel
import com.example.myanime.viewmodel.UserViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    userVm: UserViewModel = hiltViewModel(),
    animeVm : HomeViewModel = hiltViewModel()
) {


    Column(
        modifier = Modifier.padding(8.dp, 16.dp),
    ) {

            Text(
                text = "Recommendations for you !",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.ExtraBold,
            )

            Spacer(modifier = Modifier.height(16.dp))

            if(animeVm.isLoading) {
                PageLoader()
            }


        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.height(500.dp),
        ) {

            items(animeVm.animes.size) { index ->
                AnimeContainer(anime = animeVm.animes[index], navController)
            }


        }
    }

}
