package com.example.myanime.services

import com.example.myanime.models.requests.LoginRequest
import com.example.myanime.models.requests.SignupRequest
import com.example.myanime.models.responses.LoginData
import com.example.myanime.models.responses.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<Response<LoginData>>

    @POST("auth/register")
    fun signup(@Body signupRequest: SignupRequest): Call<Response<LoginData>>
}