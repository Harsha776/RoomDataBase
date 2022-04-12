package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.work.Constraints
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.sql.db.Notes
import com.example.sql.workManager.MyWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

      lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.save)
        getdata()
        button.setOnClickListener {
            updateData()

        }
        setUpWorkManager()
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

    fun updateData(){
        val notesApp= applicationContext as NotesApp
        val notesDap=notesApp.getInstance().noteDao()
        val notes=Notes(id = 26,name= "Harsha",isTaskCompleted = true)
        notesDap.update(notes)
        val listOfNotes=notesDap.getData()
        Log.d("TAG", "updated: "+listOfNotes)
    }

    fun setUpWorkManager(){
        val constraints = Constraints.Builder().build()
        val request= PeriodicWorkRequest.Builder(MyWorker::class.java,15,TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance().enqueue(request)
    }
}