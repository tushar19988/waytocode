package com.example.waytocode.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.waytocode.R
import com.example.waytocode.RetriveData
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AboutusFragment : Fragment() {

    var ref: DatabaseReference? = null
    lateinit var userRecyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_aboutus, container, false)

        userRecyclerview = view.findViewById(R.id.userlist)

        ref = FirebaseDatabase.getInstance().getReference("Ourteam")

        /* initView(view)*/
        return view
    }
}

/*
    private fun initView(view: View) {

*/
/*
      userRecyclerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

       val firebaseAdapter=object :FirebaseRecyclerAdapter<RetriveData,ViewHolder>(
           RetriveData::class.java,
           R.layout.aboutusrecycleview,
           ViewHolder::class.java,
           ref
       ){

       }

    }
*//*


    class ViewHolder(val view: View):RecyclerView.ViewHolder(view)

}*/
