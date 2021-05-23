package com.prueba.calculadora_Intent_bunddle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

private lateinit var Modo: String
private var value1: Int = 0
private var value2: Int = 0

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = intent.extras

        if (bundle != null) {
            Modo = bundle.getString("valor").toString()
        }

        btnRegresar.setOnClickListener {
            val intent = Intent()
            value1 = StrToInt(ValA.text.toString())
            value2 = StrToInt(ValB.text.toString())
            intent.putExtra("resultado1", modoOperacion(Modo))
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    private fun StrToInt(string: String): Int {
        try {
            val value = string.toInt()
            return value
        } catch (e: Exception){
            return 0
        }
    }

    private fun modoOperacion(modo:String?): String {
        when (modo) {
            "Suma" -> return (value1 + value2).toString()
            "Resta" -> return (value1 - value2).toString()
            "Multi" -> return (value1 * value2).toString()
            "Divi" -> return safeDiv()
        }
        return ""
    }

    private fun safeDiv (): String {
        try {
            return (value1 / value2).toString()
        } catch (e: Exception) {
            return "MATH ERROR!"
        }
    }

}