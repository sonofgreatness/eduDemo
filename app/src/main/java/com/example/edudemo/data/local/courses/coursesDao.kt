package com.example.edudemo.data.local.courses

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.*

@Dao
interface coursesDao {


    /*SELECTS Lessons that are unlocked
    * @return  -> list of lessons
    * */
    @Query("SELECT * FROM Lessons WHERE isLocked = 0")
    fun getAllunlocked() :List<Lesson>




    /*Selects all lessons from  Lessons table
* */
    @Query("SELECT * FROM Lessons  ORDER BY  lesson_id")
    fun getLessons(): List<Lesson>


    /*Adds a course row  to the Lesson Table
    * @param course -> Course type variable to be added to database
    * */
    @Insert(onConflict = REPLACE)
    fun insertCourse(course: Course)

    /*Adds a lesson row  to the Lesson Table
    * @param lesson -> Lesson type variable to be added to database
    * */
    @Insert(onConflict = IGNORE)
    fun insertLessons(lessons: Lesson)

        /*  Selects all courses from Courses Table
        *
        * */
    @Query("SELECT * FROM Courses")
    fun getAllCourses(): LiveData<List<Course>>


        /*
            Selects all lessons from  Lessons table
        */
    @Query("SELECT * FROM Courses")
    fun getListofCourses(): Course

    /*Changes the field "isLocked" to true for a specific row  in the Lesson table
    * @param lesson_id -> primary key field in Lesson table ,
    *      parameter will be used to identify the specific row to be altered
    * */
    @Query ("UPDATE Lessons SET isLocked = 0 WHERE lesson_id  LIKE :lesson_id" )
    fun unLockALesson(lesson_id : String)


}
