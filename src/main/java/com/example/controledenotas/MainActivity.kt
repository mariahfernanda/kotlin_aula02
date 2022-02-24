
package com.example.controledenotas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
private lateinit var nomeEditText: EditText
private lateinit var nota1EditText: EditText
private lateinit var nota2EditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calclular = findViewById<Button>(R.id.calcular) as Button
        val sair = findViewById<Button>(R.id.sair)
        val resultado = findViewById<TextView>(R.id.resultado)

        calclular.setOnClickListener {
            nomeEditText = findViewById(R.id.nome)
            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)


            val nota1 = nota1EditText.text.toString().toInt()
            val nota2 = nota2EditText.text.toString().toInt()

            val media = calcularMedia(nota1, nota2)

            val intent = Intent(this, RelatorioActivity::class.java)

            intent.putExtra("nome", nomeEditText.text.toString())
            intent.putExtra("nota1", "${nota1}")
            intent.putExtra("nota2", "${nota2}")
            intent.putExtra("media ", "${media}")
            intent.putExtra("situacao" , situacaoAluno(media))

            startActivity(intent)

            resultado.text= situacaoAluno(media)
        }


    sair.setOnClickListener{
        finish()
    }
}
    private fun validarCampos(): Boolean {
        var noError = true
        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("Digite seu nome!")
            noError = false
        }
        if (nota1EditText.text.isBlank()) {
            nota1EditText.setError("Digite sua nota 1!")
            noError = false
        }
        if (nota2EditText.text.isBlank()) {
            nota2EditText.setError("Digite sua nota 1!")
            noError = false
        }

        return noError

    }
}