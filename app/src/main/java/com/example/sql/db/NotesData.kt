package com.example.sql.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class],version = 1)
abstract class NotesData : RoomDatabase() {
    abstract fun noteDao():NotesDuo

    companion object{
        lateinit var INSTANCE:NotesData
        fun getInstance(context: Context):NotesData{
            synchronized(NotesData::class){
                INSTANCE= Room.databaseBuilder(context.applicationContext,NotesData::class.java,"myNotes.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}