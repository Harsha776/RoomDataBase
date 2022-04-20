package com.example.sql.db.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE notesdata ADD COLUMN place String")
    }
}

    val MIGRATION_4_5 = object : Migration(4,5){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE notesdata ADD COLUMN age String")
        }

}

val MIGRATION_5_6 = object : Migration(5,6){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE notesdata ADD COLUMN bio INTEGER")
    }

}

val MIGRATION_6_7 = object : Migration(6,7){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE notesdata ADD COLUMN dataVal TEXT")
    }

}

val MIGRATION_7_8 = object : Migration(7,8){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE notesdata ADD COLUMN city TEXT")
    }
}

val MIGRATION_8_9 = object : Migration(8,9){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE notesdata ADD COLUMN state INTEGER NOT NULL DEFAULT 0 ")
    }
}