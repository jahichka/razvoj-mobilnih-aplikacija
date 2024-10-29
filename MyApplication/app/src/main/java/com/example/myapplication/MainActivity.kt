package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var instructions: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        instructions = findViewById(R.id.instructions)

        generateRandomNumbers()

        button1.setOnClickListener { checkAnswer(button1.text.toString().toInt(), button2.text.toString().toInt()) }
        button2.setOnClickListener { checkAnswer(button2.text.toString().toInt(), button1.text.toString().toInt()) }
    }

    private fun generateRandomNumbers() {
        var num1 = Random.nextInt(1, 10)
        var num2 = Random.nextInt(1, 10)
        if (num1 == num2) num2 += 1

        button1.text = num1.toString()
        button2.text = num2.toString()
    }

    private fun checkAnswer(selectedNumber: Int, otherNumber: Int) {
        if (selectedNumber > otherNumber) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
        generateRandomNumbers()
    }
}
