package com.sf.bloomli.activities


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sf.bloomli.R
import com.sf.bloomli.fragments.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = window
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//                        or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
            )
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
//            window.navigationBarColor = Color.TRANSPARENT
        }

        init()
    }

    @SuppressLint("ResourceType")
    private fun init() {

        val homeFragment = HomeFragment()
        val discoverFragment = DiscoverFragment()
        val libraryFragment = LibraryFragment()
        val quizFragment = QuizFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)


        //set bottom nav
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> makeCurrentFragment(homeFragment)
                R.id.navigation_discover -> makeCurrentFragment(discoverFragment)
//                R.id.navigation_library -> makeCurrentFragment(libraryFragment)
                R.id.navigation_quiz -> makeCurrentFragment(quizFragment)
                R.id.navigation_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.homeFragment_frame_layout, fragment)
            commit()
        }

    //on back press fun
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}