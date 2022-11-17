package com.example.edudemo.ui.quizzer

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.os.VibratorManager
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.edudemo.MainActivity
import com.example.edudemo.R
import com.example.edudemo.data.local.courses.coursesViewModel
import com.example.edudemo.databinding.FragmentQuestionBinding
import com.example.edudemo.databinding.FragmentTutorialBinding

import com.example.edudemo.utils.Constants
import kotlinx.coroutines.*


class question : Fragment() {
    private lateinit var _binding: FragmentQuestionBinding
    val binding get() =  _binding
    lateinit var rootView:View
    lateinit var mViewModel : coursesViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        mViewModel = (activity as MainActivity).mCoursesWithViewModel
        // Inflate the layout for this fragment
    _binding = FragmentQuestionBinding.inflate(inflater,container,false)
        rootView = binding.root
        setUpQuestionTextView()
        binding.questionCheck.setOnClickListener({
            setUpSubmitButtonOnclick(it)
        })

        setupCancelIconOnclick()
        return rootView
    }


    /*
    * GETS TEXT FROM  THE  EDIT TEXT  ,RUNS QUERY AGAINST STRING
    * Gives User A REWARD FOR THE RIGHT ANSWER , For now should be a well colored confirmation
    * Toast
    *
    **/
    private fun setUpSubmitButtonOnclick(view1: View) {

      val answer = binding.questionAnswerIntake.text.toString()

      // RUN QUERY  HERE
        if ( answer.lowercase().trim()  == requireArguments().getString("la")?.lowercase()!!.trim())
        {
            // correct answer update DB
                val id_to_change :Int? = arguments?.getString("lid")!!.toInt() + 1
                 val lesson_id_to_change : String  = id_to_change.toString()
            mViewModel.unLockALesson(lesson_id_to_change)
           // Toast(this).showCustomToast ("Hello! This is a custom Toast!", this)
       val job  : Job = MainScope().launch {
           ShowMyToast(view1)
           delay(Constants.TRANSITION_TIME_FOR_NAVIGATION)
            moveToRecyclerView()
       }

        }
        else
        {
        // wrong answer update UI
            vibratePhone()
            setErrorMessage()



        }

    }

    private fun ShowMyToast(view1: View) {
        val layout = layoutInflater.inflate(
            R.layout.custom_toast, null
        )
        //make a toast
        val toast: Toast = Toast(view1.context)
        toast.apply {
            view = layout
            setGravity(Gravity.CENTER, 0, 0)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }


    private fun moveToRecyclerView() {

        val navHostFragment = (requireActivity()).supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_content_main
        ) as NavHostFragment
        val   navController = navHostFragment.navController

        val bundle  = bundleOf(
            "refresher" to true)
        navController.navigate(R.id.action_question_to_quizzerFragment,bundle)

    }

    private fun setUpQuestionTextView() {
        binding.questionLessonQuestion.text = arguments?.getString("lq")
    }
    private fun setupCancelIconOnclick() {
        binding.questionCanceller.setOnClickListener({
            it.findNavController().navigate(R.id.action_question_to_quizzerFragment)
        })
    }


    private fun vibratePhone() {
        val mVibratePattern = LongArray(6){0;400;500;600;200;100 }


        val vib = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                activity?.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            activity?.getSystemService(VIBRATOR_SERVICE) as Vibrator
        }



        if(vib.hasVibrator())
            vib.vibrate(mVibratePattern,-1)
    }


    private fun setErrorMessage() {
        binding.questionAnswerIntake.error = "Incorrect,Try Again"
        binding.questionAnswerIntakeLayout.boxStrokeColor = resources.getColor(R.color.orange_red)
    }

}