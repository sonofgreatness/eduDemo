package com.example.edudemo.ui.quizzer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.edudemo.R
import com.example.edudemo.databinding.FragmentTutorialBinding


class tutorial : Fragment() {
    private lateinit var _binding: FragmentTutorialBinding
    val binding get() = _binding
    lateinit var rootView: View
    lateinit var Mybundle: Bundle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTutorialBinding.inflate(inflater, container, false)
        rootView = binding.root
        setLessonHeaderText()
        setLessonData()
        setUpButtonOnClick()
        Mybundle = getLessonObjects()
        return rootView
    }

    private fun setLessonHeaderText() {
        binding.tutorialTitleLessonName.text = arguments?.getString("lname")
    }

    private fun setLessonData() {
        binding.tutorialLessonData.text = arguments?.getString("ldata")
    }

    private fun getLessonObjects(): Bundle {

            return prePareBundleforOneLesson()

    }

    /*STRUGGLED WITH SAFEARG  should have used it this would have been
    * smaller */
    private fun prePareBundleforOneLesson(): Bundle {
        val lesson_name: String? = arguments?.getString("lname")
        val lesson_data: String? = arguments?.getString("ldata")
        val lesson_q: String? = arguments?.getString("lq")
        val lesson_answer: String? = arguments?.getString("la")
        val lesson_lock: Boolean? = arguments?.getBoolean("ll")
        val lesson_id: String? = arguments?.getString("lid")
        val lesson_fk: Long? = arguments?.getLong("lfk")
        val bundle = bundleOf(
            "lchecker" to false,
            "lname" to lesson_name,
            "ldata" to lesson_data,
            "lq" to lesson_q,
            "la" to lesson_answer,
            "ll" to lesson_lock,
            "lid" to lesson_id,
            "lfk" to lesson_fk
        )
        return bundle
    }


    private fun setUpButtonOnClick() {
        binding.tutorialButton.setOnClickListener({
            it.findNavController().navigate(R.id.action_tutorial_to_question, Mybundle)
        })
    }


}