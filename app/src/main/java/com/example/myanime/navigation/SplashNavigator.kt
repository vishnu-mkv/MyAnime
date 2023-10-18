package com.example.myanime.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myanime.scaffold.AppScaffold
import com.example.myanime.scaffold.AuthScaffold
import com.example.myanime.screens.Screens
import com.example.myanime.screens.SplashScreen
import com.example.myanime.screens.anime.AnimeDetailScreen
import com.example.myanime.screens.anime.AnimeScreen
import com.example.myanime.screens.anime.HomeScreen
import com.example.myanime.screens.auth.LoginScreen
import com.example.myanime.screens.auth.SignupScreen
import com.example.myanime.viewmodel.AnimeSearchViewModel
import com.example.myanime.viewmodel.HomeViewModel
import com.example.myanime.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun SplashNavigator(
    vm: UserViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    LaunchedEffect(vm.user) {

        // call navigate function on main thread
        launch(Dispatchers.Main) {
            delay(1000)
            if(vm.isLoggedIn()) {
                navController.navigate(Screens.HOME_SCREEN)
//                navController.navigate( Screens.getAnimeDetailRoute(18679))
            } else {
                navController.navigate(Screens.LOGIN_SCREEN)
            }
        }
    }

    NavHost(navController = navController,
        startDestination = Screens.SPLASH_SCREEN
        ) {

        composable(route = Screens.SPLASH_SCREEN) {
            SplashScreen(navController)
        }

        composable(route = Screens.HOME_SCREEN) {backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Screens.HOME_SCREEN)
            }
            val homeVm = hiltViewModel<HomeViewModel>(parentEntry)
            AppScaffold(navController = navController) {
                HomeScreen(navController, animeVm = homeVm)
            }
        }

        composable(route = Screens.ANIME_SCREEN) {backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Screens.HOME_SCREEN)
            }
            val animeVm = hiltViewModel<AnimeSearchViewModel>(parentEntry)
            AppScaffold(navController = navController) {
                AnimeScreen(navController, animeVm)
            }
        }

        composable(route = Screens.LOGIN_SCREEN) {
            AuthScaffold {
                LoginScreen(navController)
            }
        }

        composable(route = Screens.SIGNUP_SCREEN) {
            AuthScaffold {
                SignupScreen(navController)
            }
        }

        composable(route = Screens.ANIME_DETAIL_SCREEN) {backStackEntry ->
            AppScaffold(navController = navController) {
                AnimeDetailScreen(
                    id = backStackEntry.arguments?.getString("id") ?: "",
                    navController = navController
                )
            }
        }
    }
}



