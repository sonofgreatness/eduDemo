package com.example.edudemo.data.local.courses

import androidx.room.Embedded
import androidx.room.Relation

class CourseWithLessons {

    /*** EXCLUSIVE CLASS TO MANAGE ONE TO MANY IN ROOM  ***/
        @Embedded
        var course:Course
        @Relation(
            parentColumn = "course_id",
            entityColumn = "lesson_id"
        )
         var lessons : List<Lesson>

        constructor(course: Course , lessons: List<Lesson> ) {
            this.course = course
            this.lessons = lessons
        }

}
