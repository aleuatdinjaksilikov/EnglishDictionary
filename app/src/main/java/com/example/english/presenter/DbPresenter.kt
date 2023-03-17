package com.example.english.presenter

import android.app.Activity
import androidx.room.Room
import com.example.english.db.dao.SozDao
import com.example.english.db.database.MyDatabase
import com.example.english.db.entity.Sound
import com.example.english.db.entity.Soz

class DbPresenter(private val activity: Activity) {


    private lateinit var db:MyDatabase
    var words = mutableListOf<Soz>()
    var sounds = mutableListOf<Sound>()
    private lateinit var dao: SozDao
    var type = ""

    fun getWordByUnit(unitNumber:Int):MutableList<Soz>{
        return dao.getWordByUnit(unitNumber).toMutableList()
    }
    fun searchWord(it:String):MutableList<Soz>{
        return dao.searchWord("$it%").toMutableList()
    }

    fun setDb() {
        db = Room.databaseBuilder(
            activity,
            MyDatabase::class.java,
            "base2"
        )
            .createFromAsset("base2.db")
            .allowMainThreadQueries()
            .build()
        dao = db.getDao()
        words = dao.getAllWords().toMutableList()
        sounds = dao.getAllSounds().toMutableList()
    }

}