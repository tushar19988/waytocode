package com.example.waytocode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        intiview()
    }

    private fun intiview() {
        Handler().postDelayed({
            val intent = Intent(this, IntroductionActivity::class.java)
            startActivity(intent)
            finish()
        },SPLASH_TIME_OUT.toLong())
    }
}