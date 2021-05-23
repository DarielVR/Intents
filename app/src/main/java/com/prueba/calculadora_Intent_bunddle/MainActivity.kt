package com.prueba.calculadora_Intent_bunddle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton(btnSuma, "Suma")
        boton(btnResta, "Resta")
        boton(btnMulti, "Multi")
        boton(btnDiv, "Divi")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                val bundle = data?.extras
                if (bundle != null){
                    val resultado = bundle.getString("resultado1")
                    Resultado.text = resultado
                }
            }
        }
    }

    private fun boton (button: Button, modo: String) {
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("valor", modo)

            startActivityForResult(intent, 1)
        }
    }

}