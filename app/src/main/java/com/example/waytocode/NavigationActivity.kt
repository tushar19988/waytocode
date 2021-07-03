package com.example.waytocode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.waytocode.databinding.ActivityNavigationBinding
import com.example.waytocode.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener{

    lateinit var appBarConfiguration: AppBarConfiguration
   lateinit var binding: ActivityNavigationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val nav_view: BottomNavigationView= findViewById(R.id.navb_view)


        val toggle =
            ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        drawerLayout.addDrawerListener(toggle)



        navView.setNavigationItemSelectedListener(this)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val fragment= HomeFragment()
        replaceFragment(fragment)

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_navigation,fragment).commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home ->{
                val fragment= HomeFragment()
                replaceFragment(fragment)

            }
            R.id.nav_Traning ->{
                val fragment=TrainingFragment()
                replaceFragment(fragment)

            }
            R.id.nav_Career ->{
                val fragment=CareerFragment()
                replaceFragment(fragment)

            }
            R.id.nav_Aboutus ->{
                val fragment= AboutusFragment()
                replaceFragment(fragment)

            }
            R.id.nav_CEO->{
                val fragment=CEOFounderFragment()
                replaceFragment(fragment)

            }
            R.id.nav_Blog ->{
                val fragment=BlogFragment()
                replaceFragment(fragment)

            }
            R.id.nav_WayToCodeGallery ->{
                val fragment= WayToCodeGalleryFragment()
                replaceFragment(fragment)

            }
            R.id.nav_Contactus ->{
                val fragment=ContactusFragment()
                replaceFragment(fragment)

            }
            R.id.nav_Feedback ->{
                val fragment= FeedbackFragment()
                replaceFragment(fragment)

            }
            R.id.nav_Logout ->{
                val fragment= LogoutFragment()
                replaceFragment(fragment)


            }

        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }



    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when(item.itemId){
            R.id.bottom_home ->{
                val fragment= HomeFragment()
                replaceFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }
            R.id.bottom_Services ->{
                val fragment= ServicesFragment()
                replaceFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }
            R.id.bottom_Portfolio ->{
                val fragment= PortfolioFragment()
                replaceFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }
            R.id.bottom_Technologies ->{
                val fragment= TechnologiesFragment()
                replaceFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }

        }
        false
    }
}



