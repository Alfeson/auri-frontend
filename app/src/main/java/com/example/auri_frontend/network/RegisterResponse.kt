package com.example.auri_frontend.network

data class RegisterResponse(
    val id: Long,
    val name: String,
    val email: String,
    val createdAt: String
)