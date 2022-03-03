package com.sf.bloomli.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.activities.MyQuizScreen
import com.sf.bloomli.activities.gamifyscreens.GameScreenActivity
import com.sf.bloomli.activities.gamifyscreens.GamifyWelcomeScreen
import com.sf.bloomli.adapters.MyQuizzesAdapter
import com.sf.bloomli.adapters.QuizFragAdapter
import kotlinx.android.synthetic.main.activity_my_quiz_screen.*
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    @SuppressLint("WrongConstant")
    private fun init(){


        //set on click listener
        quiz_frag_avatar.setOnClickListener{
            val  intent = Intent(activity,MyQuizScreen::class.java)
            startActivity(intent)
        }
        quiz_frag_avatar2.setOnClickListener {
          //  val  intent = Intent(activity,GameScreenActivity::class.java)
            val  intent = Intent(activity,GamifyWelcomeScreen::class.java)
            startActivity(intent)
        }


    }
}