package com.example.nearpharm.api

import com.example.nearpharm.model.UserModel
import retrofit2.http.*

interface UserApi {
    @POST("/account/register")
    suspend fun singUpUser(@Body user: UserModel): Unit
    @PUT("account/{idUsuario}")
    suspend fun updateUserInfo(@Path("idUsuario") idUser: Int, @Body user: UserModel): Unit
    @GET("account/{idUsuario}")
    suspend fun getUser(@Path("idUsuario") idUser: Int) : UserModel
}
