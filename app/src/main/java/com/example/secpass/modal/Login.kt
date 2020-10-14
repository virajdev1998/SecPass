package com.example.secpass.modal

data class Login(
    val email: String,
    val profile_id: Int,
    val profile_image: String,
    val token: String,
    val userid: Int
)