package com.example.edudemo.ui.quizzer.rvhandler

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.edudemo.R
import com.example.edudemo.data.local.courses.CourseWithLessons
import com.example.edudemo.data.local.courses.Lesson
import com.example.edudemo.databinding.QuizzerRvItemBinding

class quizzer_adapter: RecyclerView.Adapter<quizzer_adapter.QuizzViewHolder>() {
     inner class QuizzViewHolder (val binding:QuizzerRvItemBinding) :RecyclerView.ViewHolder(binding.root)
    // AsyncListDiffer is a tool that compares two list and updates items that are different in lists
    //create a callback to that tool below
    private val  differCallback = object : DiffUtil.ItemCallback<Lesson>() {
        override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
            return oldItem.lesson_id == newItem.lesson_id
        }
        override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizzViewHolder {
        // inflate the right layout
        val binding = QuizzerRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return (QuizzViewHolder(binding))
    }

    override fun onBindViewHolder(holder: QuizzViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

    holder. apply {
            binding.lesson1.quizzerRvItemLessonStartIcon.setImageResource(R.drawable.bookmarker)
           binding.lesson1.quizzerRvItemLessonTitle.text = currentItem.lesson_name
     if (currentItem.isLocked)
     {
         binding.lesson1.quizzerRvItemLessonEndIcon.setImageResource(R.drawable.lock)

     }
       else {
         binding.lesson1.quizzerRvItemLessonEndIcon.setImageResource(R.drawable.ic_baseline_check_24)
         binding.lesson1.button.visibility = View.VISIBLE
     }
     binding.lesson1.button.setOnClickListener {

         navigateToTutorialFragment(it,bundleCreator(currentItem))
     }
    }
    }


    private fun navigateToTutorialFragment(it: View?, bundle :Bundle) {
        it!!.findNavController().navigate(R.id.action_quizzerFragment_to_tutorial, bundle)
    }

    private fun bundleCreator(lesson: Lesson) : Bundle{
        val lesson_name : String = lesson.lesson_name
        val lesson_data :String = lesson.lesson_data
        val lesson_q: String = lesson.lesson_question
        val lesson_answer :String = lesson.lesson_answer
        val lesson_lock: Boolean = lesson.isLocked
        val lesson_id : String = lesson.lesson_id.toString()
        val lesson_fk : Long = lesson.long_fk


        val bundle  = bundleOf(
            "lchecker" to false,
            "lname" to lesson_name,
                                         "ldata" to  lesson_data,
                                         "lq"  to lesson_q,
                                         "la" to lesson_answer,
                                         "ll" to lesson_lock,
                                         "lid" to lesson_id,
            "lfk" to lesson_fk)


        return bundle
    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}