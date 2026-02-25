package com.kener.ecuacioncuadratica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputA = findViewById<TextInputLayout>(R.id.input_a)
        val inputB = findViewById<TextInputLayout>(R.id.input_b)
        val inputC = findViewById<TextInputLayout>(R.id.input_c)
        val calculateButton = findViewById<Button>(R.id.calculate_button)
        val resultX1 = findViewById<TextView>(R.id.result_x1_value)
        val resultX2 = findViewById<TextView>(R.id.result_x2_value)

        calculateButton.setOnClickListener {
            inputA.error = null
            inputB.error = null
            inputC.error = null

            val aText = inputA.editText?.text.toString()
            val bText = inputB.editText?.text.toString()
            val cText = inputC.editText?.text.toString()

            if (aText.isNotEmpty() && bText.isNotEmpty() && cText.isNotEmpty()) {
                val a = aText.toDouble()
                val b = bText.toDouble()
                val c = cText.toDouble()

                if (a == 0.0) {
                    inputA.error = "'a' no puede ser 0"
                    return@setOnClickListener
                }

                val discriminant = b * b - 4 * a * c

                if (discriminant >= 0) {
                    val x1Value = (-b + sqrt(discriminant)) / (2 * a)
                    val x2Value = (-b - sqrt(discriminant)) / (2 * a)
                    resultX1.text = String.format("%.2f", x1Value)
                    resultX2.text = String.format("%.2f", x2Value)
                } else {
                    resultX1.text = "No hay solución real"
                    resultX2.text = ""
                }
            } else {
                if (aText.isEmpty()) inputA.error = "Introduce un valor"
                if (bText.isEmpty()) inputB.error = "Introduce un valor"
                if (cText.isEmpty()) inputC.error = "Introduce un valor"
            }
        }
    }
}
