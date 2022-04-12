package com.example.sql.db


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesdata")
data class Notes (
    @PrimaryKey(autoGenerate = true) var id:Int?=null,
    @ColumnInfo(name="name")
    var name:String?="",
    @ColumnInfo(name="isTaskCompleted")
    var isTaskCompleted:Boolean=false
)