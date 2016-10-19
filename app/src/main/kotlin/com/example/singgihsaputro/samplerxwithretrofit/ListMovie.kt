package com.example.singgihsaputro.samplerxwithretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button


import com.example.singgihsaputro.samplerxwithretrofit.adapter.RvAdapter
import com.example.singgihsaputro.samplerxwithretrofit.model.Movie
import com.example.singgihsaputro.samplerxwithretrofit.service.MovieService
import com.example.singgihsaputro.samplerxwithretrofit.service.ServiceFactory

import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ListMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Set up Android CardView/RecycleView
         */
        val mRecyclerView = findViewById(R.id.recycler_view) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        val mCardAdapter = RvAdapter()
        mRecyclerView.adapter = mCardAdapter

        /**
         * START: button set up
         */
        val bClear = findViewById(R.id.button_clear) as Button
        val bFetch = findViewById(R.id.button_fetch) as Button
        bClear.setOnClickListener { mCardAdapter.clear() }

        bFetch.setOnClickListener {
            val service = ServiceFactory.createRetrofitService<MovieService>(MovieService::class.java, MovieService.SERVICE_ENDPOINT)
            service.getMoviesPopular(BuildConfig.POPULAR_MOVIES_API_KEY).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Subscriber<Movie>() {
                override fun onCompleted() {
                    // do nothing
                }

                override fun onError(e: Throwable) {
                    Log.e("MoviesDemo", e.message)
                }

                override fun onNext(results: Movie) {
                    val rs = results.results
                    mCardAdapter.addData(rs as MutableList<Movie.Results>)
                }
            })
        }
        /**
         * END: button set up
         */
    }

}
