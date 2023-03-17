package com.example.english.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.english.R
import com.example.english.db.entity.Soz
import com.example.english.presenter.DbPresenter
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private var presenter = DbPresenter(this)
    private var set = mutableListOf<Soz>()
    private lateinit var soz: Soz
    private var wrongCount = 0
    private var rightCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        presenter.setDb()
        presenter.type = intent.getStringExtra("type").toString()
        setQuestion()
    }
    private fun setQuestion(){
        loadGame()
        goneMessage()
        answer1.setOnClickListener {
            checkAnswer(answer1.text.toString())
        }
        answer2.setOnClickListener {
            checkAnswer(answer2.text.toString())
        }
        answer3.setOnClickListener {
            checkAnswer(answer3.text.toString())
        }
        answer4.setOnClickListener {
            checkAnswer(answer4.text.toString())
        }
    }

    private fun goneMessage() {
        val handler = Handler()
        handler.postDelayed(Runnable {
            messageWrong.visibility = View.GONE
            messageRight.visibility = View.GONE
        },1000)
    }

    private fun checkAnswer(str:String){
        if(presenter.type == "ui"){
            if(str == soz.english){
                rightCount++
                messageRight.visibility = View.VISIBLE
                val anim = AnimationUtils.loadAnimation(this,R.anim.show_message)
                messageRight.startAnimation(anim)
                setQuestion()
            }else{
                wrongCount++
                messageWrong.visibility = View.VISIBLE
                val anim = AnimationUtils.loadAnimation(this,R.anim.show_message)
                messageWrong.startAnimation(anim)
                setQuestion()
            }
        }else{
            if(str == soz.uzbek){
                rightCount++
                messageRight.visibility = View.VISIBLE
                val anim = AnimationUtils.loadAnimation(this,R.anim.show_message)
                messageRight.startAnimation(anim)
                setQuestion()
            }else{
                wrongCount++
                messageWrong.visibility = View.VISIBLE
                val anim = AnimationUtils.loadAnimation(this,R.anim.show_message)
                messageWrong.startAnimation(anim)
                setQuestion()
            }
        }
    }

    private fun loadGame() {
        count.text = "Right: $rightCount     Wrong: $wrongCount"
        soz = presenter.words.random()   //hello - salem
        if(presenter.type=="ui"){
            question.text = soz.uzbek
        }else{
            question.text = soz.english
        }
        randomAnswers(soz)
        setAnswer()
        setRightAnswer(soz)
    }

    private fun setRightAnswer(soz:Soz) {  //hello - salem
        when((1..4).random()){
            1->answer1.text = if(presenter.type=="ui") soz.english else soz.uzbek
            2->answer2.text = if(presenter.type=="ui") soz.english else soz.uzbek
            3->answer3.text = if(presenter.type=="ui") soz.english else soz.uzbek
            4->answer4.text = if(presenter.type=="ui") soz.english else soz.uzbek
        }
    }

    private fun setAnswer() {       //hello
        if(presenter.type == "ui"){
            answer1.text = set[0].english
            answer2.text = set[1].english
            answer3.text = set[2].english
            answer4.text = set[3].english
        }else{
            answer1.text = set[0].uzbek   // kitap
            answer2.text = set[1].uzbek   //ruchka
            answer3.text = set[2].uzbek   //shashka
            answer4.text = set[3].uzbek   // salem
        }
    }

    private fun randomAnswers(soz:Soz) {
        while (set.size<4){
            val s = presenter.words.random()
            if(s!=soz && !set.contains(s)){
                set.add(s)
            }
        }
    }


}