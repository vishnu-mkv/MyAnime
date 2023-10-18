package com.example.myanime.models.responses

import com.google.gson.annotations.SerializedName

data class Recommendation (
    @SerializedName("mal_id"  ) var malId   : String?          = null,
    @SerializedName("entry"   ) var animes   : ArrayList<Anime> = arrayListOf(),
    @SerializedName("content" ) var content : String?          = null,
    @SerializedName("user"    ) var user    : User?            = User()
)

data class User (
    @SerializedName("url"      ) var url      : String? = null,
    @SerializedName("username" ) var username : String? = null
)

typealias RecommendationResponse = Paginated<Recommendation>