package com.example.english.story

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import com.example.english.R
import kotlinx.android.synthetic.main.activity_play_story.*

class PlayStoryActivity : AppCompatActivity() {

    private lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_story)
        var soundName = intent.getStringExtra("soundName")
        var soundTitle = intent.getStringExtra("soundTitle")
        var soundText = intent.getStringExtra("soundText")
        story_text.text = soundText
        tv_story_title.text = soundTitle


        val mediaPlayer = MediaPlayer.create(this,resources.getIdentifier(soundName,"raw",packageName))
        sb_story.max = mediaPlayer.duration

        btn_start.setOnClickListener {
            mediaPlayer.start()
        }
        btn_pouse.setOnClickListener {
            mediaPlayer.pause()
        }
        sb_story.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mediaPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        runnable = Runnable {
            sb_story.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)

    }
}