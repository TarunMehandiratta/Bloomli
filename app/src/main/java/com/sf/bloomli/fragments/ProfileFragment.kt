package com.sf.bloomli.fragments


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sf.bloomli.R
import com.sf.bloomli.activities.*
import com.sf.bloomli.adapters.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        profile_frag_fun_icon.setOnClickListener {
                showFunFactPopup()
        }
        my_library_lay.setOnClickListener {
            startActivity(Intent(activity,LibraryFragment::class.java))
        }

        //set onclick listener
//        doneTimeBut.setOnClickListener {
//            (activity as HomeActivity)?.onBackPressed()
//        }

        //set on click listener
        profile_frag_3dots_icon.setOnClickListener {
            //show dialog box
//            showDialog(context as Activity?)
            //show popup menu
            showPopup(profile_frag_3dots_icon)

        }

        //set on click listener
        my_notes_lay.setOnClickListener {
            val intent = Intent(activity,MyNotesScreen::class.java)
            startActivity(intent)
        }

        ///set categories adapter
        profile_frag_my_notes_recycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        profile_frag_my_notes_recycler.adapter = ProfileFragMyNotesAdapter(activity)

        ///set categories adapter
        profile_frag_my_quiz_recycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        profile_frag_my_quiz_recycler.adapter = MyQuizAdapter(activity)

        ///set categories adapter
        profile_frag_my_library_recycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        profile_frag_my_library_recycler.adapter = ProfileMyLibraryAdapter(activity)
    }

    private fun showFunFactPopup() {
        val dialogData = Dialog(requireContext())
        dialogData.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogData.setCancelable(false)
        dialogData.setContentView(R.layout.fun_fact_custom_dialog)
        dialogData.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogData.window?.setGravity(Gravity.CENTER)
        dialogData.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val done = dialogData.findViewById(R.id.doneTimeBut) as TextView
        done.setOnClickListener {
            dialogData.dismiss()
        }
        dialogData.show()

    }

    //show popup menu fun
    @SuppressLint("ResourceType")
    private fun showPopup(vieww: View) {

        val popupWindow = PopupWindow(vieww)
        val inflater =
            requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View = inflater.inflate(R.layout.profile_popup_three_dots_layout, null)

        val item: TextView = view.findViewById(R.id.edit_profile_text) as TextView
        val item2: TextView = view.findViewById(R.id.message_text) as TextView
        val item3: TextView = view.findViewById(R.id.feedback_text) as TextView
        val item4: TextView = view.findViewById(R.id.contact_text) as TextView
        val item5: TextView = view.findViewById(R.id.Logout_text) as TextView

        item.setOnClickListener {
            //use intent
                    val intent = Intent(activity,EditProfileScreen::class.java)
                    startActivity(intent)
        }

        item2.setOnClickListener {
            //use intent
                    val intent = Intent(activity,MessagesScreen::class.java)
                    startActivity(intent)
        }

        item3.setOnClickListener {
            //use intent
                    val intent = Intent(activity,FeedbackActivity::class.java)
                    startActivity(intent)
        }

        item4.setOnClickListener {
                    //use intent
                    val intent = Intent(activity,ContactUsActivity::class.java)
                    startActivity(intent)
        }

        item5.setOnClickListener {
            Toast.makeText(activity, "Logout Successfully", Toast.LENGTH_SHORT).show()
        }

        popupWindow.isFocusable = true
        popupWindow.width = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.contentView = view

         popupWindow.showAsDropDown(vieww)
    }
}