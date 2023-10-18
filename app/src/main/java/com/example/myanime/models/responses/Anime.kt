package com.example.myanime.models.responses

import com.google.gson.annotations.SerializedName


data class Anime (
    @SerializedName("mal_id" ) var malId  : Int?    = null,
    @SerializedName("url"    ) var url    : String? = null,
    @SerializedName("images" ) var images : Images? = Images(),
    @SerializedName("title"  ) var title  : String? = null
)

data class Images (
    @SerializedName("jpg"  ) var jpg  : Jpg?  = Jpg(),
    @SerializedName("webp" ) var webp : Webp? = Webp()
)

data class Webp (
    @SerializedName("image_url"       ) var imageUrl      : String? = null,
    @SerializedName("small_image_url" ) var smallImageUrl : String? = null,
    @SerializedName("large_image_url" ) var largeImageUrl : String? = null
)

data class Jpg (
    @SerializedName("image_url"       ) var imageUrl      : String? = null,
    @SerializedName("small_image_url" ) var smallImageUrl : String? = null,
    @SerializedName("large_image_url" ) var largeImageUrl : String? = null
)