package com.example.english.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.english.R
import com.example.english.db.entity.Sound
import com.example.english.presenter.DbPresenter
import kotlinx.android.synthetic.main.activity_story.*

class StoryActivity : AppCompatActivity() {

    private var presenter = DbPresenter(this)

    private var adapter = SoundAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        presenter.setDb()
        adapter.sounds = presenter.sounds
        rv_sound.adapter = adapter
    }
    fun setOnClickSoundItem(sound: Sound){
        val intent = Intent(this,PlayStoryActivity::class.java)
        intent.putExtra("soundTitle",sound.title)
        intent.putExtra("soundText",sound.text)
        intent.putExtra("soundName",sound.soundName)
        startActivity(intent)
    }

}