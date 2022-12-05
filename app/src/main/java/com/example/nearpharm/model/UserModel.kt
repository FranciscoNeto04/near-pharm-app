package com.example.nearpharm.model

class UserModel (
    val id: Long,
    val logo: String?,
    val cpf: String?,
    val cnpj: String?,
    val name: String,
    val address: String,
    val phone: String,
    val products: List<ProductModel>?
)
