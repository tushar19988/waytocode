package com.example.waytocode.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.waytocode.BlogDataModal
import com.example.waytocode.BlogViewHolder
import com.example.waytocode.R

class BlogAdapter(val context: Context, val datalist: ArrayList<BlogDataModal>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.BlogViewHolder {
        return BlogAdapter(LayoutInflater.from(context).inflate(R.layout.simg,parent,false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}