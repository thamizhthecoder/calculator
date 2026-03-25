package com.basic.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentNumber = ""
    private var previousNumber = ""
    private var operation = ""
    private var newOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide,
            R.id.btnEquals, R.id.btnClear, R.id.btnDecimal
        )

        buttons.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                when (id) {
                    R.id.btnClear -> clear()
                    R.id.btnEquals -> calculate()
                    R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide -> setOperation(id)
                    else -> appendNumber(it)
                }
            }
        }
    }

    private fun appendNumber(view: android.view.View) {
        val btn = view as Button
        if (newOperation) {
            currentNumber = ""
            newOperation = false
        }
        currentNumber += btn.text
        display.text = currentNumber
    }

    private fun setOperation(btnId: Int) {
        if (previousNumber.isEmpty()) {
            previousNumber = currentNumber
        } else if (currentNumber.isNotEmpty()) {
            calculate()
        }
        operation = when (btnId) {
            R.id.btnPlus -> "+"
            R.id.btnMinus -> "-"
            R.id.btnMultiply -> "*"
            R.id.btnDivide -> "/"
            else -> ""
        }
        newOperation = true
    }

    private fun calculate() {
        if (previousNumber.isEmpty() || currentNumber.isEmpty()) return

        val result = when (operation) {
            "+" -> previousNumber.toDouble() + currentNumber.toDouble()
            "-" -> previousNumber.toDouble() - currentNumber.toDouble()
            "*" -> previousNumber.toDouble() * currentNumber.toDouble()
            "/" -> {
                val divisor = currentNumber.toDouble()
                if (divisor == 0.0) {
                    display.text = "Error"
                    clear()
                    return
                }
                previousNumber.toDouble() / divisor
            }
            else -> return
        }

        currentNumber = result.toString()
        display.text = currentNumber
        previousNumber = ""
        operation = ""
        newOperation = true
    }

    private fun clear() {
        currentNumber = ""
        previousNumber = ""
        operation = ""
        newOperation = true
        display.text = "0"
    }
}
