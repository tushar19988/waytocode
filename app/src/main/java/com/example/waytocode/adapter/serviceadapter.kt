package com.example.waytocode.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waytocode.Modal.serviceModal
import com.example.waytocode.OnClickListener
import com.example.waytocode.R
import com.example.waytocode.ViewHolder.ServiceViewHolder


    class serviceadapter(val context: Context, val datalist: ArrayList<serviceModal>,private val onClickListener:OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ServiceViewHolder {
            return ServiceViewHolder(LayoutInflater.from(context).inflate(R.layout.servicedataadapter,parent,false))

        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            holder.itemView.setOnClickListener {
                onClickListener.onClickListner(position)
            }

            Glide
                .with(context)
                .load(datalist[position].image)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.itemView.findViewById(R.id.serviceimg))

        }

        override fun getItemCount(): Int=datalist.size

    }








