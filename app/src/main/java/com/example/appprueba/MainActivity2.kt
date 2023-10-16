package com.example.appprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.appprueba.modelo.daos.DaoIngrediente
import com.example.appprueba.modelo.entidades.Alimento
import com.example.appprueba.modelo.entidades.Ingrediente

class MainActivity2 : AppCompatActivity() {

    private lateinit var cantidadIngr: EditText
    private lateinit var botonGuardar: Button
    private lateinit var botonBorrar: Button
    private lateinit var botonVerIngredientes: Button
    private lateinit var daoIngrediente: DaoIngrediente


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //*******************************Inicialización de cajas************************************
        cantidadIngr = findViewById(R.id.cantidadIngrediente)
        //*******************************Inicialización de botones**********************************
        botonGuardar = findViewById(R.id.botonGuardarIngr)
        botonBorrar = findViewById(R.id.botonBorrarIngr)
        botonVerIngredientes = findViewById(R.id.botonVerIngr)
        //*******************************Inicialización de DaoIngrediente***************************
        daoIngrediente = DaoIngrediente()

        //*******************************Eventos botón**********************************************
        botonGuardar.setOnClickListener { manejoIngredientes() }

    }
    fun manejoIngredientes() {
        //Guardamos un ingrediente en el arrayList de ingredientes
        //El alimento lo obtenemos del activity 1
        var infoActivity1 = intent.extras
        var alimentoActi1 = infoActivity1?.getSerializable("Alimentos") as Alimento
        //Primero pasamos a cadena de texto y seguidamente a double
        var ingredienteAAnadir = Ingrediente(alimentoActi1, cantidadIngr.toString().toDouble())
        daoIngrediente.anadirIngrediente(ingredienteAAnadir)
        //Borrar un ingrediente
        //Aun no implementado
        //Ver ingredientes
        daoIngrediente.verListaIngredientes()
    }
}