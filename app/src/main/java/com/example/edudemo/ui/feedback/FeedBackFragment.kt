package com.example.edudemo.ui.feedback

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.edudemo.R
import com.example.edudemo.databinding.FragmentFeedBackBinding
import com.example.edudemo.databinding.FragmentInviteBinding

class FeedBackFragment : Fragment() {

    private lateinit var  _binding: FragmentFeedBackBinding
    val  binding get() =  _binding
    lateinit  var rootView : View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

    _binding = FragmentFeedBackBinding.inflate(inflater,container,false)
        rootView = binding.root
        return rootView
    }


}