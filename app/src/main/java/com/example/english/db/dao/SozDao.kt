package com.example.english.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.english.db.entity.Sound
import com.example.english.db.entity.Soz

@Dao
interface SozDao {

    @Query("select * from preintermediate")
    fun getAllWords():List<Soz>

    @Query("select * from preintermediate where unit = :unitNumber")
    fun getWordByUnit(unitNumber:Int):List<Soz>

    @Query("select * from preintermediate where english like :str")
    fun searchWord(str:String):List<Soz>

    @Query("select * from sounds")
    fun getAllSounds():List<Sound>

}