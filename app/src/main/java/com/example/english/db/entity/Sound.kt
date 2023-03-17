package com.example.english.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sounds")
data class Sound (
    @PrimaryKey
    var id:Int,
    @ColumnInfo(name = "soundname")val soundName:String,
    @ColumnInfo(name = "text")val text:String,
    @ColumnInfo(name = "title")val title:String?

)