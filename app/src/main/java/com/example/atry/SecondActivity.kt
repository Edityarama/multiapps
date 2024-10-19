package com.example.atry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editTextNumber1: EditText = findViewById(R.id.editTextNumber1)
        val editTextNumber2: EditText = findViewById(R.id.editTextNumber2)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            calculate(editTextNumber1, editTextNumber2, textViewResult, Operation.ADD)
        }

        findViewById<Button>(R.id.buttonSubtract).setOnClickListener {
            calculate(editTextNumber1, editTextNumber2, textViewResult, Operation.SUBTRACT)
        }

        findViewById<Button>(R.id.buttonMultiply).setOnClickListener {
            calculate(editTextNumber1, editTextNumber2, textViewResult, Operation.MULTIPLY)
        }

        findViewById<Button>(R.id.buttonDivide).setOnClickListener {
            calculate(editTextNumber1, editTextNumber2, textViewResult, Operation.DIVIDE)
        }

        findViewById<Button>(R.id.buttonGoBack).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }

    private fun calculate(num1EditText: EditText, num2EditText: EditText, resultTextView: TextView, operation: Operation) {
        val num1 = num1EditText.text.toString().toDoubleOrNull() ?: return
        val num2 = num2EditText.text.toString().toDoubleOrNull() ?: return
        val result = when (operation) {
            Operation.ADD -> num1 + num2
            Operation.SUBTRACT -> num1 - num2
            Operation.MULTIPLY -> num1 * num2
            Operation.DIVIDE -> if (num2 != 0.0) num1 / num2 else Double.NaN
        }
        resultTextView.text = "Result: ${if (result.isNaN()) "Error" else result}"
    }

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
