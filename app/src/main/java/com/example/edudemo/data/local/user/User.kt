package com.example.edudemo.data.local.user

import androidx.room.ColumnInfo
import java.sql.Blob

class User(
    @ColumnInfo(name = "usename")
    val usename : String,
    @ColumnInfo(name  = "campus")
    val campus :String,
    @ColumnInfo(name  = "p_summary")
    val p_summary:String,
    @ColumnInfo(name = "pp")
    val pp: Blob
)
