package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var valor1: Double = 0.0
    var valor2:Double=0.0
    var reset: Int=0

    lateinit var resulCal: TextView
    var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resulCal = findViewById(R.id.resultCal)
        val igual: Button=findViewById(R.id.igual)
            igual.setOnClickListener {
                valor2= resulCal.text.toString().toDouble()
                var answer:Double=0.0
                when(operacion){
                    1-> answer=valor1+valor2
                    2-> answer=valor1-valor2
                    3-> answer=valor1*valor2
                    4-> answer=valor1/valor2
                }
                resulCal.setText(answer.toString())
                reset=1
            }

    }

    fun pres_digitos(view: View){
         if(reset==1){
            resulCal.setText("") //profe, esto es para limpiar la pantalla cuando termine una operación y quiera seguir realizando operaciones
            reset=0
        }
            var numero = resulCal.text.toString()
            when (view.id) {
                R.id.cero -> resulCal.setText(numero + "0")
                R.id.uno -> resulCal.setText(numero + "1")
                R.id.dos -> resulCal.setText(numero + "2")
                R.id.tres -> resulCal.setText(numero + "3")
                R.id.cuatro -> resulCal.setText(numero + "4")
                R.id.cinco -> resulCal.setText(numero + "5")
                R.id.seis -> resulCal.setText(numero + "6")
                R.id.siete -> resulCal.setText(numero + "7")
                R.id.ocho -> resulCal.setText(numero + "8")
                R.id.nueve -> resulCal.setText(numero + "9")
                R.id.punto -> resulCal.setText(numero + ".")
            }

    }
    fun operaciones(view: View){

        valor1 = resulCal.text.toString().toDouble()
        var num_text: String = resulCal.text.toString()

        when(view.id){
            R.id.suma-> {
                resulCal.setText(num_text+" + ")
                operacion=1
            }

            R.id.resta->{
                resulCal.setText(num_text+" - ")
                operacion=2
            }
            R.id.multiplicacion -> {
                resulCal.setText(num_text+" * ")
                operacion=3
            }
            R.id.division ->{
                resulCal.setText(num_text+" / ")
                operacion=4
            }
        }
        resulCal.setText("") //profe, es para limpiar la pantalla y poder solamente tomar el número cuando vaya a realizar la operación con el primero
    }




}