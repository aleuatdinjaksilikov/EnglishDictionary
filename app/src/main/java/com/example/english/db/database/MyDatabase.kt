package com.example.english.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.english.db.dao.SozDao
import com.example.english.db.entity.Sound
import com.example.english.db.entity.Soz

@Database(entities = [Soz::class,Sound::class],version = 1)
abstract class MyDatabase:RoomDatabase() {

    abstract fun getDao():SozDao

}