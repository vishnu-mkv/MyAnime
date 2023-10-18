package com.example.myanime.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myanime.models.responses.Anime
import com.example.myanime.models.responses.AnimeListResponse
import com.example.myanime.services.AnimeService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AnimeSearchViewModel @Inject constructor(
    val animeService: AnimeService
) : ViewModel() {

    var animes by mutableStateOf<List<Anime>>(listOf())

    var isLoading by mutableStateOf(false)
    var searchTerms by mutableStateOf("")
    var page by mutableStateOf(1)
    var errorMessage by mutableStateOf("")
    var hasNextPage by mutableStateOf(true)

    init {
        getAnimes()
    }

    fun getAnimes() {
        isLoading = true
        errorMessage = ""
        val call = animeService.getAnimeSearch(searchTerms, page)

        call.enqueue(
            object : Callback<AnimeListResponse> {
                override fun onResponse(
                    call: Call<AnimeListResponse>,
                    response: Response<AnimeListResponse>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            val newAnimes = data.data
                            animes = animes + newAnimes
                        }
                    } else {
                        errorMessage = response.message()
                    }
                    isLoading = false
                }

                override fun onFailure(call: Call<AnimeListResponse>, t: Throwable) {
                    Log.d("HomeViewModel", "onFailure: ${t.message}")
                    errorMessage = t.message ?: t.message.toString()
                    isLoading = false
                }
            }
        )
    }


    fun loadMore() {
        if (isLoading || !hasNextPage) return
        page++
        getAnimes()
    }

    fun searchAnime(searchTerms: String) {
        this.searchTerms = searchTerms
        page = 1
        animes = listOf()
        getAnimes()
    }
}