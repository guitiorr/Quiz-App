package com.budiman.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startText: TextView = findViewById(R.id.et_name)
        val btnStart: Button = findViewById(R.id.btnStart)
        btnStart.setOnClickListener{
            if(startText.text.isNotEmpty()){
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, startText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}