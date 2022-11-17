package com.example.edudemo.data.local.courses

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "Lessons")
data class Lesson (
    @ColumnInfo(name = "name") var lesson_name:String = " ",
    @ColumnInfo(name = "data") var  lesson_data: String = " ",
    @ColumnInfo(name = "question") var lesson_question:String = " ",
    @ColumnInfo(name = "answer") var lesson_answer: String = " ",
    @ColumnInfo(name = "isLocked") var isLocked :Boolean = true,
    @PrimaryKey @ColumnInfo(name = "lesson_id") var lesson_id: Int = 0,
    @ColumnInfo(name = "long_fk") var long_fk: Long,
):Serializable
