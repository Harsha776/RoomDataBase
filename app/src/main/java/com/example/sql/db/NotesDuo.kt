package com.example.sql.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE


@Dao
interface NotesDuo {

    @Query("Select * from notesdata")
    fun getData():List<Notes>

    @Insert(onConflict = REPLACE)
    fun insert(notes: Notes)

    @Update
    fun update(notes: Notes)

    @Delete
    fun delete(notes: Notes)

    @Query("Delete from notesdata where isTaskCompleted=:status")
    fun deleteNotesStatus(status:Boolean)
}