package com.example.myanime.models.responses

data class ErrorResponse(
    val ok: Boolean,
    val message: String,
    val code: String,
    val error: Map<String, String>?
)