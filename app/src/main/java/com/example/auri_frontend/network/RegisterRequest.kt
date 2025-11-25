package com.example.auri_frontend.network

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)