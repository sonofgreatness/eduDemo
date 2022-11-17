package com.example.edudemo.ui.quizzer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edudemo.MainActivity
import com.example.edudemo.data.local.courses.CourseWithLessons
import com.example.edudemo.data.local.courses.coursesViewModel
import com.example.edudemo.databinding.FragmentQuizzerBinding
import com.example.edudemo.ui.quizzer.rvhandler.quizzer_adapter

class QuizzerFragment : Fragment() {


     lateinit var mViewModel : coursesViewModel
    private lateinit var  _binding: FragmentQuizzerBinding
    private val binding get() = _binding
   lateinit var  adapter : quizzer_adapter
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewModel = (activity as MainActivity).mCoursesWithViewModel
        _binding = FragmentQuizzerBinding.inflate(inflater,container,false)
        rootView = binding.root
        adapter = quizzer_adapter()
        setUpRecyclerView()
        refreshViews()
         return (rootView)
    }

    private fun refreshViews() {
        binding.quizzerRV.invalidate()
    }

    private fun setUpRecyclerView() {
       //mViewModel.fillmyListDBdata()
        binding.quizzerRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        /*mViewModel.listofCourseWithLessons.observe(viewLifecycleOwner, Observer {
            adapter.differ.submitList(it)
        })*/
            mViewModel.fillListWithDBData()
            mViewModel.listOfLessons.observe(viewLifecycleOwner, Observer {list ->
            adapter.differ.submitList(list)
                Log.d("findme", "${list.size}")
        })

        binding.quizzerRV.adapter = adapter
    }
}