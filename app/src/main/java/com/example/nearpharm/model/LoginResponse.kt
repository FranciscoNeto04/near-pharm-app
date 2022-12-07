package com.example.nearpharm.model

class LoginResponse (
    val id: Long,
    val cpf: String,
    val name: String,
    val address: String,
    val phone: String,
    val password: String,
    val isPharm: Boolean
)