package com.example.myanime.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myanime.models.responses.Anime
import com.example.myanime.models.responses.RecommendationResponse
import com.example.myanime.services.AnimeService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val animeService: AnimeService
):ViewModel() {

    var isLoading by mutableStateOf(false)
    var animes by mutableStateOf<List<Anime>>(listOf())
    var hasNextPage by mutableStateOf(true)
    var errorMessage by mutableStateOf("")

    init {
        getRecommendations()
    }

    fun getRecommendations() {
        isLoading = true

        val call  = animeService.getRecommendations(1)

        call.enqueue(
            object : Callback<RecommendationResponse> {
                override fun onResponse(
                    call: Call<RecommendationResponse>,
                    response: Response<RecommendationResponse>
                ) {
                    if(response.isSuccessful) {
                        val data = response.body()
                        if(data != null) {
                            hasNextPage = data.pagination?.hasNextPage ?: false
                            val newAnimes = data.data.flatMap { it.animes }
                            animes = animes + newAnimes
                        }
                    } else {
                        errorMessage = response.message()
                    }
                    isLoading = false
                }

                override fun onFailure(call: Call<RecommendationResponse>, t: Throwable) {
                    Log.d("HomeViewModel", "onFailure: ${t.message}")
                    errorMessage = t.message ?: t.message.toString()
                    isLoading = false
                }
            }
        )
    }
}