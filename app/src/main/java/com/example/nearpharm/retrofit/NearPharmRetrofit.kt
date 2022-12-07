package com.example.nearpharm.retrofit

import com.example.nearpharm.api.UserApi
import com.example.nearpharm.retrofit.RetrofitInstance.Companion.interceptor
import com.gustafah.android.mockinterceptor.MockConfig
import com.gustafah.android.mockinterceptor.MockInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NearPharmRetrofit {

    val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    fun retrofit(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl("http://ec2-52-45-164-147.compute-1.amazonaws.com/api/v1/")
            addConverterFactory(
                GsonConverterFactory.create()
            )
                .client(client)
        }.build()
    }
    fun user(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

}