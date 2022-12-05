package com.example.nearpharm.model

class LoginModel (
    val loginToken: String,
    val password: String
)
class LoginResponse (
    val user: UserModel,
    val isUser:Boolean = user.cnpj.isNullOrEmpty()
)