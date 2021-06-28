package com.example.waytocode.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.waytocode.R
import com.example.waytocode.fragment.HomeFragment

class CustomMainAdapter(private val activity: HomeFragment,
                        private val imagesArray: Array<Int> ): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = activity.layoutInflater
        //creating  xml file for custom viewpager
        val viewItem = inflater.inflate(R.layout.item, container, false)
        //finding id
        val imageView = viewItem.findViewById<ImageView>(R.id.imageView)
        imageView.setBackgroundResource(imagesArray[position])
        container.addView(viewItem)
        return viewItem
    }

    override fun getCount(): Int {
        return imagesArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }

}
