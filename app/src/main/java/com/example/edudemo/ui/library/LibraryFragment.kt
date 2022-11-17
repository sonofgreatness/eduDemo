package com.example.edudemo.ui.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.edudemo.R
import com.example.edudemo.databinding.FragmentLibraryBinding
import com.example.edudemo.databinding.FragmentUserProfileBinding


class LibraryFragment : Fragment() {

    private lateinit var  _binding: FragmentLibraryBinding
    val  binding get() =  _binding
    lateinit  var rootView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLibraryBinding.inflate(inflater,container,false)
        rootView = binding.root

        return rootView
    }

}