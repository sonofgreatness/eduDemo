package com.example.edudemo

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import java.io.Serializable
class taskInfo {


    @Entity(tableName = "taskInfo")
    data class TaskInfo(
        @PrimaryKey(autoGenerate = false)
        var id: Int,
        var description: String,
        var date: Date,
        var priority: Int,
        var status: Boolean,
        var category: String
    ) : Serializable

}