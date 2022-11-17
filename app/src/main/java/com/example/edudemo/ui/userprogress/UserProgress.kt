package com.example.edudemo.ui.userprogress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.edudemo.MainActivity
import com.example.edudemo.R
import com.example.edudemo.data.local.courses.coursesViewModel
import com.example.edudemo.databinding.FragmentUserProfileBinding
import com.example.edudemo.databinding.FragmentUserProgressBinding


class UserProgress : Fragment() {


    private lateinit var  _binding: FragmentUserProgressBinding
    val  binding get() =  _binding
    lateinit var  mCoursesWithViewModel: coursesViewModel
    lateinit  var rootView : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserProgressBinding.inflate(inflater,container,false)
        rootView = binding.root
        mCoursesWithViewModel = (activity as MainActivity).mCoursesWithViewModel
        mCoursesWithViewModel.getProgressInPercentage()
        mCoursesWithViewModel.progressPercentage.observe(viewLifecycleOwner, Observer {
            binding.UserProgressText.text = it.toString().plus("%")
            if(it <= 100){
                binding.rewardImageView.setOnClickListener {
                    rewardImageViewOnclick()
                }
            }else{
                binding.rewardImageView.setImageResource(R.drawable.douglassfrederic)
            }

        })



        return rootView
    }

    private fun rewardImageViewOnclick() {
        Toast.makeText(requireContext(), "finish all tasks to get reward", Toast.LENGTH_SHORT).show()
    }


}