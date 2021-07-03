package com.example.waytocodetechnologiesllp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.waytocode.R

class TgViewHolder( view: View):RecyclerView.ViewHolder(view) {
    var technologyname: TextView =view.findViewById(R.id.technologyname)
}