
package com.example.controledenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calclular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calclular.setOnClickListener{
            val nota1 = findViewById<EditText>(R.id.nota1).text.toString().toInt()
            val nota2 = findViewById<EditText>(R.id.nota2).text.toString().toInt()
            val faltas = findViewById<TextView>(R.id.faltas)
            val resultado = findViewById<TextView>(R.id.resultado)
            val media = (nota1 + nota2) /2

            if (media >= 5){
                resultado.text = "Aprovado"
                resultado.setTextColor(Color.GREEN)
            }else{
                resultado.text = "Reprovado"
                resultado.setTextColor(Color.RED)
            }
        }

        sair.setOnClickListener{
            finish()
        }
    }
}