package com.example.english.learn_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.english.R
import com.example.english.words.WordsActivity
import kotlinx.android.synthetic.main.activity_learn.*

class LearnActivity : AppCompatActivity() {

    private var adapter = LearnAdapter(this)
    var type = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        type = intent.getStringExtra("type").toString()
        learn_rv.adapter = adapter
        setUnits()
    }
    fun itemOnClickListener(position:Int){
        val intent = Intent(this,WordsActivity::class.java)
        intent.putExtra("type",type)
        intent.putExtra("unit",position+1)
        startActivity(intent)
    }
    private fun setUnits(){
        val list = mutableListOf<String>()
        for (i in 1..12){
            list.add("Unit $i")
        }
        adapter.list = list
    }
}