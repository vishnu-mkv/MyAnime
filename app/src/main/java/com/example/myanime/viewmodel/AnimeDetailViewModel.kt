package com.example.myanime.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myanime.models.responses.AnimeData
import com.example.myanime.models.responses.AnimeDetailResponse
import com.example.myanime.services.AnimeService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val animeService: AnimeService
): ViewModel() {

    var anime by mutableStateOf(AnimeData())
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf("")

    fun getAnimeDetail(id: String) {
        isLoading = true
        val call = animeService.getAnimeDetail(id)

        call.enqueue(object : Callback<AnimeDetailResponse> {

            override fun onResponse(
                call: Call<AnimeDetailResponse>,
                response: Response<AnimeDetailResponse>
            ) {
                if(response.isSuccessful) {
                    Log.d("AnimeDetailViewModel", "onResponse: ${response.body()}")
                    anime = response.body()?.data ?: AnimeData()
                    isLoading = false
                } else {
                    Log.d("AnimeDetailViewModel", "onResponse: ${response.errorBody()}")
                    errorMessage = response.errorBody().toString()
                    isLoading = false
                }
            }

            override fun onFailure(call: Call<AnimeDetailResponse>, t: Throwable) {
                Log.d("AnimeDetailViewModel", "onFailure: ${t.message}")
                errorMessage = t.message.toString()
                isLoading = false
            }
        })
    }
}