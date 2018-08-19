package br.com.alvaro.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Builder {

    private val BASE_URL = "https://api.github.com/"

    fun build() : Retrofit {
        return Retrofit.Builder()
                .baseUrl(this.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}