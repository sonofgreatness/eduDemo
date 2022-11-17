package com.example.edudemo.data.local.courses

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database
    (entities = [Course::class,Lesson::class], version = 1, exportSchema = false)
abstract class MainDataBase: RoomDatabase() {
    abstract  fun getDao():coursesDao
//Initialize database
    companion object{
    @Volatile // other threads can immediately see when a thread changes this instance
    private var INSTANCE:MainDataBase? = null
    @OptIn(InternalCoroutinesApi::class)
    fun getDatabase (context: Context) : MainDataBase
    {
        val tempInstance = INSTANCE
        if (tempInstance != null)
        {
            return tempInstance
        }
        synchronized(this)
        { val instance = Room.databaseBuilder(
            context.applicationContext,
        MainDataBase::class.java,
        "user_database")
            .createFromAsset("database/mydb9.db")
            .build()
            INSTANCE  = instance
            return instance
        }
    }
    }
}