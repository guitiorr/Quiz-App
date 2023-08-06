package com.budiman.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.NonCancellable.start
import org.w3c.dom.Text

class End : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.end)

        var userName: TextView =  findViewById(R.id.name)
        var score: TextView = findViewById(R.id.score)
        val btnFinish: Button = findViewById(R.id.FINISH)

        val intentUser = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        userName.text = intentUser
        score.text = "Your score is ${correctAnswer} out of ${totalQuestions} lol"

        btnFinish.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}