package com.example.nearpharm.api

import com.example.nearpharm.model.UserModel
import com.example.nearpharm.model.UsersResponse
import com.gustafah.android.mockinterceptor.Mock
import retrofit2.http.*

interface UserApi {
    @GET("user")
    suspend fun getPharmacies() : UsersResponse

    @GET("pharmacies/{idUsuario}")
    suspend fun getPharmacy(@Path("idUsuario") idUser: Long) : UserModel

    @POST("authentication/register")
    suspend fun singUpUser(@Body user: UserModel): Unit
}
