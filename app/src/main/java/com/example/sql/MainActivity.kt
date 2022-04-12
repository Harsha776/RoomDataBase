package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.sql.db.Notes

class MainActivity : AppCompatActivity() {

      lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.save)
        getdata()
        button.setOnClickListener {
            addNotesToDb()

        }
    }
    fun addNotesToDb(){
        val notesApp= applicationContext as NotesApp
        val notesDap=notesApp.getInstance().noteDao()
        val notes=Notes(name= "siddegowda")
        notesDap.insert(notes)
    }

    fun getdata(){
        val notesApp= applicationContext as NotesApp
        val notesDap=notesApp.getInstance().noteDao()
        val listOfNotes=notesDap.getData()
        Log.d("TAG", "getdata: "+listOfNotes)
    }
}