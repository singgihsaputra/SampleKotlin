package com.example.singgihsaputro.samplerxwithretrofit.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.singgihsaputro.samplerxwithretrofit.R
import com.example.singgihsaputro.samplerxwithretrofit.model.Movie

import java.util.ArrayList

/**
 * Created by singgihsaputro on 10/18/16.
 */

public class RvAdapter : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    internal var mItems: MutableList<Movie.Results>

    init {
        mItems = ArrayList<Movie.Results>()
    }

    fun addData(movie: MutableList<Movie.Results>) {
        mItems = movie
        notifyDataSetChanged()
    }

    fun clear() {
        mItems.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_view, viewGroup, false)
        val viewHolder = ViewHolder(v)
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val movie = mItems[i]
        viewHolder.login.text = movie.original_title
        viewHolder.repos.text = "rating: " + movie.vote_average
        viewHolder.blog.text = "date: " + movie.release_date
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var login: TextView
        var repos: TextView
        var blog: TextView

        init {
            login = itemView.findViewById(R.id.login) as TextView
            repos = itemView.findViewById(R.id.repos) as TextView
            blog = itemView.findViewById(R.id.blog) as TextView
        }
    }
}
