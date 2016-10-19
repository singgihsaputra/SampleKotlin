package com.example.singgihsaputro.samplerxwithretrofit.service

import com.example.singgihsaputro.samplerxwithretrofit.model.Movie

import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

/**
 * Created by singgihsaputro on 10/18/16.
 */

interface MovieService {

    @GET("/3/movie/popular")
    fun getMoviesPopular(@Query("api_key") apiKey: String): Observable<Movie>

    companion object {
        val SERVICE_ENDPOINT = "http://api.themoviedb.org"
    }

}
