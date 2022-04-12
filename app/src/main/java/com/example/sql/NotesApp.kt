package com.example.sql

import android.app.Application
import com.example.sql.db.NotesData

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    fun getInstance():NotesData{
        return NotesData.getInstance(this)
    }

}