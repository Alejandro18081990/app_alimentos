package com.example.appprueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.appprueba.databinding.ActivityMainBinding
import com.example.appprueba.modelo.daos.DaoAlimento
import com.example.appprueba.modelo.entidades.Alimento

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var nombreAlimento: EditText
    private lateinit var tipoAlimento: EditText
    private lateinit var cantidadHidratos: EditText
    private lateinit var cantidadLipidos: EditText
    private lateinit var cantidadProteinas: EditText
    private lateinit var cantidadKcal: TextView
    private lateinit var alimento: Alimento
    private lateinit var daoAlimento: DaoAlimento

    //BOTONES
    private lateinit var botonCalculo: Button
    private lateinit var botonAnadir: Button
    private lateinit var botonBorrar: Button
    private lateinit var botonVerAlimentos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //*******************Asignamos las vistas a las propiedades de la clase**********************
        nombreAlimento = findViewById(R.id.nombreAlimento)
        tipoAlimento = findViewById(R.id.tipoAlimento)
        cantidadHidratos = findViewById(R.id.cantidadHidratos)
        cantidadLipidos = findViewById(R.id.cantidadLipidos)
        cantidadProteinas = findViewById(R.id.cantidadProteinas)
        cantidadKcal = findViewById(R.id.resultadoKcal)
        //****************************VISTA BOTONES****************************
        botonCalculo = findViewById(R.id.botonKiloCaloria)
        botonAnadir = findViewById(R.id.botonAnadir)
        botonBorrar = findViewById(R.id.botonBorrar)
        botonVerAlimentos = findViewById(R.id.botonVerAlimento)
        //****************************INICIALIZACION DE DAOS****************************
        daoAlimento = DaoAlimento()
        //****************************EVENTO BOTONES*****************************
        botonCalculo.setOnClickListener { mostrarKcal() }
        botonAnadir.setOnClickListener { daoAlimento.anadirAlimento(alimento) }
        botonBorrar.setOnClickListener { daoAlimento.borrarAlimento(alimento) }
        botonVerAlimentos.setOnClickListener { daoAlimento.verAlimentos() }
        setSupportActionBar(binding.toolbar)

    }

    private fun mostrarKcal() {
        //Convertimos a los tipos de datos que correspondan y guardamos en variables
        //************************************************************************************
        val cajaNombre = nombreAlimento.text.toString()
        val cajaTipo = tipoAlimento.text.toString()
        val cajaHidratos = cantidadHidratos.text.toString()
        val cajaLipidos = cantidadLipidos.text.toString()
        val cajaProteinas = cantidadProteinas.text.toString()


        //Instancia de la clase alimento para acceder a los métodos
        //********************************************************
        alimento = Alimento(
            cajaNombre,
            cajaTipo,
            cajaHidratos.toDouble(),
            cajaLipidos.toDouble(),
            cajaProteinas.toDouble()
        )

        cantidadKcal.text = alimento.calculaKcal().toString() + "kCal"
        Toast.makeText(this, "Recuerde rellenar los campos", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}