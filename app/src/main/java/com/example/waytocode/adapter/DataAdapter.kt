package com.example.waytocode.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waytocode.DataModal
import com.example.waytocode.R
import com.example.waytocode.SViewHolder

/*
class DataAdapter(val context: Context?, val datalist:ArrayList<DataModal>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SViewHolder {
        return SViewHolder(LayoutInflater.from(context).inflate(R.layout.item_adapter,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        if (context != null) {
            Glide
                .with(context)
                .load(datalist[position].img)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder?.itemView?.findViewById(R.id.imgtech))
        }

    }

    override fun getItemCount(): Int=datalist.size

}*/
