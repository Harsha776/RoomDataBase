package com.example.sql.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sql.db.migration.*

@Database(entities = [Notes::class],version = 9)
abstract class NotesData : RoomDatabase() {
    abstract fun noteDao():NotesDuo

    companion object{
        lateinit var INSTANCE:NotesData
        fun getInstance(context: Context):NotesData{
            synchronized(NotesData::class){
                INSTANCE= Room.databaseBuilder(context.applicationContext,NotesData::class.java,"myNotes.db")
                    .fallbackToDestructiveMigration()
                   .allowMainThreadQueries().addMigrations(MIGRATION_8_9)
                    .build()
            }
            return INSTANCE
        }
    }
}