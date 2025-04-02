package za.ac.iie.assignment1st10488228

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val edtTime = findViewById<EditText>(R.id.edtTime)
            val txtResults = findViewById<TextView>(R.id.txtResults)
            val suggestButton = findViewById<Button>(R.id.btnSuggest)
            val resetButton = findViewById<Button>(R.id.btnReset)

            suggestButton.setOnClickListener {
                val timeOfDay = edtTime.text.toString().trim().lowercase()

                val suggestion = if (timeOfDay == "morning"){
                    "Breakfast suggestion: Pancakes or Omelette"
                } else if (timeOfDay == "mid morning"){
                    "Snack suggestion: Smoothie or Granola bar"
                } else if (timeOfDay == "afternoon"){
                    "Lunch suggestion: Sandwich or Salad"
                } else if (timeOfDay == "mid afternoon") {
                    "Snack suggestion: Fruit or Yogurt"
                } else if (timeOfDay == "dinner") {
                    "Dinner suggestion: Pasta or Grilled Chicken"
                } else {
                    "Please enter a valid time of day (using lowercase letters only)"
                }

                txtResults.text =suggestion

                resetButton.setOnClickListener()
                {
                    edtTime.text.clear()
                    txtResults.text = ""
                }
            }

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}