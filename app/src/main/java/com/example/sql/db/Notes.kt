package com.example.sql.db


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesdata")
data class Notes (
    @PrimaryKey(autoGenerate = true) var id:Int?=null,
    @ColumnInfo(name="name")
    var name:String?="",
    @ColumnInfo(name="place")
    var place:String?="",
    @ColumnInfo(name="age")
    var age:String?="",
    @ColumnInfo(name="dataVal")
    var dataVal:String?="",
    @ColumnInfo(name="city")
    var city:String?="",
    @ColumnInfo(name="state")
    var state:Int=0,
    @ColumnInfo(name="isTaskCompleted")
    var isTaskCompleted:Boolean=false
)