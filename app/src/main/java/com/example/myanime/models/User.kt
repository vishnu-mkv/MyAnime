package com.example.myanime.models

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val _id: String,
    val active: Boolean,
    val createdAt: String,
    val updatedAt: String
)