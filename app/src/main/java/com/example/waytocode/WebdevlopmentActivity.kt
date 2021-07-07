package com.example.waytocode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class WebdevlopmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webdevlopment)

        initView()
    }

    private fun initView() {
        val Image = intent.getStringExtra("IMAGE_URL")



        val servicetitle = intent.getStringExtra("SERVICE_TITLE")
        findViewById<TextView>(R.id.titlelanguage).text=servicetitle.toString()

        val ImageView = intent.getStringExtra("IMAGE_VIEW")


       val servicepara = intent.getStringExtra("SERVICE_PARA")
        findViewById<TextView>(R.id.txtperagraph).text=servicepara.toString()

        val servicep = intent.getStringExtra("SERVICE_PER")
        findViewById<TextView>(R.id.txtpragraphview).text=servicep.toString()




        Glide
            .with(this)
            .load(Image)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(findViewById(R.id.iView))


        Glide
            .with(this)
            .load(ImageView)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(findViewById(R.id.iviewver))
    }
}
