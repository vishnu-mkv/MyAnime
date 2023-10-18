package com.example.myanime.models.requests

data class SignupRequest (
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val deviceID: String
)