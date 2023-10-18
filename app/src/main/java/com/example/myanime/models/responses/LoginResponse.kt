package com.example.myanime.models.responses

import com.example.myanime.models.User

data class LoginData(
    val user: User,
    val token: String
)

typealias LoginResponse = Response<LoginData>
