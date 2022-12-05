package com.example.nearpharm.retrofit

import com.example.nearpharm.model.LoginModel
import com.example.nearpharm.model.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type:application/json")
    @POST("/account/login")
    fun signin(@Body info: LoginModel): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("/account/register")
    fun registerUser(
        @Body info: LoginResponse
    ): retrofit2.Call<ResponseBody>
}

class RetrofitInstance {
    companion object {
        val BASE_URL: String = "http://18.210.174.15"

        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}