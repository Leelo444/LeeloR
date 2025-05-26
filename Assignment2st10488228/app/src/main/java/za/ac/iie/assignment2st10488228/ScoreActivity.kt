package za.ac.iie.assignment2st10488228

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        //Get score and feedback from intent
        val score = intent.getIntExtra("score", 0)
        val feedback = if (score >= 3) "Great job!" else "Keep practising!"

        //Set the score and feedback text
        findViewById<TextView>(R.id.txtScore).text = "You scored $score/5"
        findViewById<TextView>(R.id.txtFeedback2).text = feedback

        //Restart the quiz
        findViewById<Button>(R.id.btnRestart).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("questions", intent.getStringArrayExtra("questions"))
            intent.putExtra("answers", intent.getStringArrayExtra("answers"))
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