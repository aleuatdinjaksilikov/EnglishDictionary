package com.example.english.words

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.english.R
import com.example.english.presenter.DbPresenter
import kotlinx.android.synthetic.main.activity_words.*

class WordsActivity : AppCompatActivity() {

    private var adapter = WordAdapter(this)
    var presenter = DbPresenter(this)
    private var unitNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        presenter.type = intent.getStringExtra("type").toString()
        unitNumber = intent.getIntExtra("unit",0)
        presenter.setDb()
        if(unitNumber==0){
            adapter.words = presenter.words
        }else{
            adapter.words = presenter.getWordByUnit(unitNumber)
        }
        word_rv.adapter = adapter

        et_word.addTextChangedListener{
            adapter.words = presenter.searchWord(it.toString())
        }
    }

}