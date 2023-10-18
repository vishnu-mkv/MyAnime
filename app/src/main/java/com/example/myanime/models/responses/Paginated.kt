package com.example.myanime.models.responses

import com.google.gson.annotations.SerializedName

data class Paginated<T>(
    @SerializedName("data") var data: ArrayList<T> = arrayListOf(),
    @SerializedName("pagination") var pagination: Pagination? = Pagination()
)

data class Pagination(
    @SerializedName("last_visible_page") var lastVisiblePage: Int? = null,
    @SerializedName("has_next_page") var hasNextPage: Boolean? = null
)