package com.example.a06

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a06.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os elementos da interface
        val billAmountInput = findViewById<EditText>(R.id.billAmountInput)
        val tipPercentageInput = findViewById<EditText>(R.id.tipPercentageInput)
        val calculateTipButton = findViewById<Button>(R.id.calculateTipButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateTipButton.setOnClickListener {
            // Obter valores inseridos pelo usuário
            val billAmountText = billAmountInput.text.toString()
            val tipPercentageText = tipPercentageInput.text.toString()

            if (billAmountText.isNotEmpty() && tipPercentageText.isNotEmpty()) {
                // Converter textos para números
                val billAmount = billAmountText.toDoubleOrNull()
                val tipPercentage = tipPercentageText.toDoubleOrNull()

                if (billAmount != null && tipPercentage != null && billAmount > 0 && tipPercentage >= 0) {
                    // Calcular valor da gorjeta e total
                    val tip = billAmount * (tipPercentage / 100)
                    val total = billAmount + tip
                    // Exibir resultado
                    resultText.text = "Gorjeta: %.2f\nTotal: %.2f".format(tip, total)
                } else {
                    resultText.text = "Por favor, insira valores válidos."
                }
            } else {
                resultText.text = "Por favor, preencha todos os campos."
            }
        }
    }
}
