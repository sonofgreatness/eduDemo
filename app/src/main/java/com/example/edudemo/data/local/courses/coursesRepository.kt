package com.example.edudemo.data.local.courses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.ArrayList

class coursesRepository(private val coursesDao: coursesDao) {

fun UpdateALesson(lesson_id: String) = coursesDao.unLockALesson(lesson_id)
    fun getAllCourses():LiveData<List<Course>> = coursesDao.getAllCourses()
    fun fillListWithDBData() : List<Lesson> {
            val ListofLessons:List<Lesson> = coursesDao.getLessons()
          return ListofLessons
    }

    fun getLessons() : List<Lesson>
    {
      return   coursesDao.getLessons()
    }
    fun getAllUnlocked () :List<Lesson>
    {

        return coursesDao.getAllunlocked()
    }
}