package za.ac.iie.assignment2st10488228

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quizactivity : AppCompatActivity() {
    //Array of flash card questions
    private val questions = arrayOf(
        "Winnie Mandela was a South African anti-apartheid activist and politician",
        "She was the most prominent voice of dissent in the struggle against Apartheid after the leaders of the African National Congress (ANC) were jailed or forced to flee the country",
        "Population Registration Act, 1950 This Act demanded that people be registered according to their age group",
        "The ANC was formed in Bloemfontein in 1923, soon after the Union of South Africa",
        "Bantustans were established for the permanent removal of the Black population in White South Africa"
    )
    //Array with the correct answers
    private val answers = booleanArrayOf(true, true, false, false, true)

    //Index to track which question the user is on
    private var questionsIndex = 0

    //Variable to check users score
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizactivity)

        loadQuestion()

        findViewById<Button>(R.id.btnTrue).setOnClickListener { checkAnswer(true) }
        findViewById<Button>(R.id.btnFalse).setOnClickListener { checkAnswer(false) }
        findViewById<Button>(R.id.btnNext).setOnClickListener { nextQuestion() }
    }

    private fun loadQuestion() {
        findViewById<TextView>(R.id.txtQuestions).text = questions[questionsIndex]
    }

    //Function to check if users answer is incorrect or not
    private fun checkAnswer(userAnswer: Boolean) {
        val feedback = if (userAnswer == answers[questionsIndex]) {
            score++
            "Correct!"
        } else {
            "Incorrect!"
        }
        findViewById<TextView>(R.id.txtFeedback).text = feedback
    }

    //Function to load  current question on screen
    private fun nextQuestion() {
        questionsIndex++
        if (questionsIndex < questions.size) {
            loadQuestion()
            findViewById<TextView>(R.id.txtFeedback).text = ""
        } else {
            //When the quiz is finished, go to the score activity and pass the score
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("questions", questions)
            intent.putExtra("answer", answers)
            startActivity(intent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    }
