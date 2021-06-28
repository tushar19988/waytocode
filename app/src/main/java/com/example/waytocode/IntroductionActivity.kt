package com.example.waytocode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.waytocode.adapter.CustomAdapter
import java.util.*

class IntroductionActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var txtskip: TextView
    lateinit var sliderDotspanel: LinearLayout
    var imageId =
        arrayOf(R.drawable.slideone, R.drawable.slidetwo, R.drawable.sthree)
    var imagesName = arrayOf("Any sufficiently advanced technology is equivalent to magic. ", "Just because something doesn’t do what you planned it to do doesn’t mean it’s useless.", "Technology like art is a soaring exercise of the human imagination.")
    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500 //delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000 // time in milliseconds between successive task executions.
    private var dotscount = 0
    private lateinit var dots: Array<ImageView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)


        sliderDotspanel = findViewById(R.id.SliderDots)
        viewPager = findViewById(R.id.viewpager)
        txtskip = findViewById(R.id.txtskip)


        initView()
    }

    private fun initView() {
        txtskip.setOnClickListener {
            startActivity(
                Intent(this,
                    SigninActivity::class.java)
            )
        }

        val adapter: PagerAdapter = CustomAdapter(
            this@IntroductionActivity,
            imageId,
            imagesName
        )
        viewPager.adapter = adapter
        dotscount = adapter.getCount()
        dots = arrayOfNulls(dotscount)
        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.non_active_dot
                )
            )
            val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(
            ContextCompat.getDrawable(
                getApplicationContext(),
                R.drawable.active_dot
            )
        )
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]!!
                        .setImageDrawable(
                            ContextCompat.getDrawable(
                                getApplicationContext(),
                                R.drawable.non_active_dot
                            )
                        )
                }
                dots[position]!!
                    .setImageDrawable(
                        ContextCompat.getDrawable(
                            getApplicationContext(),
                            R.drawable.active_dot
                        )
                    )
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        /*After setting the adapter use the timer */
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == 3) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }
        timer = Timer() // This will create a new Thread
        timer!!.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)

    }

}
