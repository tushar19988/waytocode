package com.example.waytocodetechnologiesllp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waytocode.R

class TgDataAdapter(val context: Context,val dataModelList: ArrayList<TgData_Model>)
    :RecyclerView.Adapter<TgDataAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var technologyname:TextView=view.findViewById(R.id.technologyname)
        var image:ImageView=view.findViewById(R.id.tgimg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TgDataAdapter.MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.tgitem_dataadapter,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TgDataAdapter.MyViewHolder, position: Int) {
        val data=dataModelList[position]

        holder.technologyname.text=data.technologyname
        Glide.with(context).load(data.image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }
}