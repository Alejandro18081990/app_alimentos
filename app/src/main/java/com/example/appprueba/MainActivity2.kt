package com.example.appprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.appprueba.modelo.daos.DaoIngrediente
import com.example.appprueba.modelo.entidades.Alimento
import com.example.appprueba.modelo.entidades.Ingrediente

class MainActivity2 : AppCompatActivity() {


    private lateinit var alimentoAct1: Alimento
    private lateinit var daoIngrediente: DaoIngrediente
    private lateinit var cantidadIngr: EditText

    //BOTONES DE INGREDIENTES
    private lateinit var botonGuardarIngr: Button
    private lateinit var botonBorrarIngr: Button
    private lateinit var botonVerIngr: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //****************MANEJO CAJA CANTIDAD******************************************************
        cantidadIngr = findViewById(R.id.cantidadIngrediente)
        var cantidad = cantidadIngr.text.toString().toDouble()
        //*******************************************VISTA BOTONES*********************************
        botonGuardarIngr = findViewById(R.id.botonGuardarIngr)
        botonBorrarIngr = findViewById(R.id.botonBorrarIngr)
        botonVerIngr = findViewById(R.id.botonVerIngr)

        //Inicialización DaoIngrediente
        daoIngrediente = DaoIngrediente()

        //**********************MANEJO DE DATOS RECIBIDOS DE ACTIVITY1******************************
        val extra = intent.extras
        if (extra != null) {
            alimentoAct1 = extra!!.getSerializable("alimento") as Alimento
            var ingrediente = Ingrediente(alimentoAct1,cantidad)
            daoIngrediente.anadirIngrediente(ingrediente)
        }
    }


}