package com.example.nearpharm.api

import com.example.nearpharm.model.UserModel
import com.gustafah.android.mockinterceptor.Mock
import retrofit2.http.*

interface UserApi {
    @GET("account/{idUsuario}")
    @Mock("assets/pharmacy_users.json")
    suspend fun getUserPharmacy(@Path("idUsuario") idUser: Long) : List<UserModel>

    @GET("account/{idUsuario}")
    @Mock("assets/pharmacy.json")
    suspend fun getPharmacy(@Path("idUsuario") idUser: Long) : UserModel
}
