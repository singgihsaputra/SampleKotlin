package com.example.singgihsaputro.samplerxwithretrofit.service

import com.jakewharton.retrofit.Ok3Client

import okhttp3.OkHttpClient
import retrofit.RestAdapter
import retrofit.client.OkClient

/**
 * Created by singgihsaputro on 10/18/16.
 */

object ServiceFactory {
    fun <T> createRetrofitService(clazz: Class<T>, endPoint: String): T {

        val restAdapter = RestAdapter.Builder().setEndpoint(endPoint).build()
        val service = restAdapter.create(clazz)

        return service
    }
}
