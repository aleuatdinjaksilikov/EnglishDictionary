package com.example.english

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.english.game.GameActivity
import com.example.english.learn_activity.LearnActivity
import com.example.english.story.StoryActivity
import com.example.english.words.WordsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_learnIU.setOnClickListener {
            val intent=Intent(this,LearnActivity::class.java)
            intent.putExtra("type","iu")
            startActivity(intent)
        }
        btn_gameIU.setOnClickListener {
            val intent=Intent(this,GameActivity::class.java)
            intent.putExtra("type","iu")
            startActivity(intent)
        }
        btn_learnUI.setOnClickListener {
            val intent=Intent(this,LearnActivity::class.java)
            intent.putExtra("type","ui")
            startActivity(intent)
        }
        btn_gameUI.setOnClickListener {
            val intent=Intent(this,GameActivity::class.java)
            intent.putExtra("type","ui")
            startActivity(intent)
        }
        btn_learnD.setOnClickListener {
            val intent=Intent(this,WordsActivity::class.java)
            intent.putExtra("type","iu")
            startActivity(intent)
        }
        btn_learn_sh_s.setOnClickListener {
            val intent=Intent(this,StoryActivity::class.java)
            intent.putExtra("type","iu")
            startActivity(intent)
        }
    }
}