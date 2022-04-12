package com.example.sql.workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.sql.NotesApp

class MyWorker(context: Context,workerParameters: WorkerParameters) : Worker(context,workerParameters) {
    override fun doWork(): Result {
        Log.d("TAG", "doWork: MyWorker")
        val notesApp= applicationContext as NotesApp
        val notesDap=notesApp.getInstance().noteDao()
        notesDap.deleteNotesStatus(true)
        val listOfNotes=notesDap.getData()
        Log.d("TAG", "getdata: "+listOfNotes)
        return Result.success()
    }
}