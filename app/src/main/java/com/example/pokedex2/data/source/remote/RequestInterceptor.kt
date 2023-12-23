package com.example.pokedex2.data.source.remote

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url
            .newBuilder()
            .build()

        val request = originalRequest.newBuilder()
            .addHeader("Content-Type", "application/json")
            .url(newUrl)
            .build()

        return chain.proceed(request)
    }
}