package com.sf.bloomli.activities.gamifyscreens

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.sf.bloomli.R
import kotlinx.android.synthetic.main.activity_game_screen.*
import kotlinx.android.synthetic.main.toggle_toolbar.view.*

class GameScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        if(Build.VERSION.SDK_INT >= 21) {
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
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.containerFrag,SubmitQuizFragment())
//            .commit()

        setClick()
    }

    private fun setClick() {
        toggleClick.butAsSubmitQuizTwo.setOnClickListener {
           toggleClick.tvSubmitQuizText.visibility = View.VISIBLE
           toggleClick.tvTakeQuiz.visibility = View.GONE


//            supportFragmentManager.beginTransaction()
//                .replace(R.id.containerFrag,SubmitQuizFragment())
//                .commit()
        }

        toggleClick.butAsTakeQuiz.setOnClickListener {
            toggleClick.tvSubmitQuizText.visibility = View.GONE
            toggleClick.tvTakeQuiz.visibility = View.VISIBLE

//            supportFragmentManager.beginTransaction()
//                .replace(R.id.containerFrag,TakeQuizFragment())
//                .commit()

        }
    }
}