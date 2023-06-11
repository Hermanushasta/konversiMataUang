package org.d3if0043.konversimatauang.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0043.konversimatauang.model.Bendera
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://gist.github.com/Hermanushasta/032471527d0fe79a48e8d1570ceb223f/raw/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("static-api.json")
    suspend fun getBendera(): List<Bendera>
}

object BenderaApi {
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    fun getBenderaUrl(name: String): String {
        return "$BASE_URL$name.png"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }