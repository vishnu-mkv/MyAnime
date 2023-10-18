package com.example.myanime.services

import com.example.myanime.models.responses.AnimeDetailResponse
import com.example.myanime.models.responses.AnimeListResponse
import com.example.myanime.models.responses.Paginated
import com.example.myanime.models.responses.RecommendationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {

    @GET("recommendations/anime")
    fun getRecommendations(@Query("page") page :Int) : Call<RecommendationResponse>

    @GET("anime/{id}")
    fun getAnimeDetail(@Path("id") malId :String) : Call<AnimeDetailResponse>

    @GET("anime")
    fun getAnimeSearch(@Query("q") query :String, @Query("page") page:Int=1,
                       @Query("limit") limit:Int=10) : Call<AnimeListResponse>
}