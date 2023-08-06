package com.budiman.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mSubmitPass: Int = 0
    private var mSelectable: Int = 1
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName : String? = null
    private var mCorrectAnswers: Int = 0

    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null
    private var questionAH: TextView? = null
    private var img: ImageView? = null

    private var optionOne:TextView? = null
    private var optionTwo:TextView? = null
    private var optionThree:TextView? = null
    private var optionFour:TextView? = null

    private var btnSubmit: Button? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progressText)
        questionAH = findViewById(R.id.question)
        img = findViewById(R.id.imageQuestion)

        optionOne = findViewById(R.id.optionOne)
        optionTwo = findViewById(R.id.optionTwo)
        optionThree = findViewById(R.id.optionThree)
        optionFour = findViewById(R.id.optionFour)

        btnSubmit = findViewById(R.id.btnSubmit)


        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        mQuestionsList = Constants.getQuestions()

        setQuestion()
//        defaultOptionsView()
    }

    private fun setQuestion() {
        mSubmitPass = 0
        mSelectable = 1
        defaultOptionsView()
        Log.i("Question size is", "${mQuestionsList?.size}")
        for (i in mQuestionsList!!) {
            Log.e("Questions", i.question)
        }
        //        var currentPosition = 1

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        img?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        progressText?.text = "$mCurrentPosition/${progressBar?.max}"
        questionAH?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }
        else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        optionOne?.let{
            options.add(0, it)
        }
        optionTwo?.let{
            options.add(1, it)
        }
        optionThree?.let{
            options.add(2, it)
        }
        optionFour?.let{
            options.add(3, it)
        }

        for(option in options){
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                if(mSelectable == 1){
                    optionOne?.let{
                        selectedOptionView(it, 1)
                        mSubmitPass = 1
                    }
                }
            }

            R.id.optionTwo -> {
                if(mSelectable == 1){
                    optionTwo?.let{
                        mSubmitPass = 1
                        selectedOptionView(it, 2)
                    }
                }
            }

            R.id.optionThree -> {
                if(mSelectable == 1){
                    optionThree?.let{
                        mSubmitPass = 1
                        selectedOptionView(it, 3)
                    }
                }
            }

            R.id.optionFour -> {
                if(mSelectable == 1){
                    optionFour?.let{
                        mSubmitPass = 1
                        selectedOptionView(it, 4)
                    }
                }
            }

            R.id.btnSubmit -> {
                if(mSubmitPass == 1){
                    mSelectable = 0
                    if(mSelectedOptionPosition == 0){
                        mCurrentPosition++

                        when{
                            mCurrentPosition <= mQuestionsList!!.size ->{
                                setQuestion()
                            }
                            else ->{
                                val intent = Intent(this, End::class.java)
                                intent.putExtra(Constants.USER_NAME, mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }else{
                        val question = mQuestionsList?.get(mCurrentPosition-1)
                        if(question!!.correctAnswer != mSelectedOptionPosition){
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        }
                        else{
                            mCorrectAnswers++
                        }
                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                        if(mCurrentPosition == mQuestionsList!!.size){
                            btnSubmit?.text = "FINISH"
                        }
                        else{
                            btnSubmit?.text = "Go to Next Question"
                        }
                        mSelectedOptionPosition = 0
                }


                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                optionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                optionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }


        }
    }

}