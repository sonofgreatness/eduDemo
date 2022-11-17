package com.example.edudemo.data.local.courses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Courses")
data class Course @JvmOverloads constructor (
        @ColumnInfo(name = "name") var course_name: String = "",
        @ColumnInfo(name = "description") var course_description: String = "",
        @ColumnInfo(name = "completed") var isCompleted: Boolean = false,
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "course_id") var course_id: Long = 0
        ,)
{
        val isActive get() =!isCompleted
}