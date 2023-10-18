package com.example.myanime.screens

import androidx.compose.runtime.Composable

 class Screens {
     companion object {
         val SPLASH_SCREEN= "splash_screen"
         val LOGIN_SCREEN = "login_screen"
         val SIGNUP_SCREEN = "signup_screen"
         val HOME_SCREEN =  "home_screen"
         val ANIME_SCREEN = "anime"
         val ANIME_DETAIL_SCREEN  = "anime/{id}"
         val GENRE_DETAIL_SCREEN = "genre/{id}"

         fun replaceId(route: String, id: Int): String {
             return route.replace("{id}", id.toString())
         }

         fun getAnimeDetailRoute(id: Int): String {
             return replaceId(ANIME_DETAIL_SCREEN, id)
         }

            fun getGenreDetailRoute(id: Int): String {
                return replaceId(GENRE_DETAIL_SCREEN, id)
            }
     }
}