package com.example.waytocode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    lateinit var iView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        iView=findViewById(R.id.iView)
    initView()
    }

    private fun initView() {


        val Image = intent.getStringExtra("IMAGE_URL")

        Glide
            .with(this)
            .load(Image)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(iView)
    }
}