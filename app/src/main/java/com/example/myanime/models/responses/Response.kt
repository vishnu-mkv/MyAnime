package com.example.myanime.models.responses

data class Response<T>(
    val success: Boolean,
    val code: Array<String>,
    val message: Array<String>,
    val data: T
)
