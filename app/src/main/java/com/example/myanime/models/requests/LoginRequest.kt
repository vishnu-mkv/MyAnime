package com.example.myanime.models.requests

data class LoginRequest(
    val email: String,
    val password: String,
    val deviceID: String
)