package com.example.appprueba


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.widget.*
import com.example.appprueba.databinding.ActivityMainBinding
import com.example.appprueba.modelo.DatosAlimentos
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

    //BOTONES DE ALIMENTOS
    private lateinit var botonCalculo: Button
    private lateinit var botonAnadir: Button
    private lateinit var botonBorrar: Button
    private lateinit var botonVerAlimentos: Button
    private lateinit var botonIrIngr: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.content_main)
        //*******************Asignamos las vistas a las propiedades de la clase**********************
        nombreAlimento = findViewById(R.id.nombreAlimento)
        tipoAlimento = findViewById(R.id.tipoAlimento)
        cantidadHidratos = findViewById(R.id.cantidadHidratos)
        cantidadLipidos = findViewById(R.id.cantidadLipidos)
        cantidadProteinas = findViewById(R.id.cantidadProteinas)
        cantidadKcal = findViewById(R.id.resultadoKcal)

        //****************************VISTA BOTONES*************************************************
        botonCalculo = findViewById(R.id.botonKiloCaloria)
        botonAnadir = findViewById(R.id.botonAnadir)
        botonBorrar = findViewById(R.id.botonBorrar)
        botonVerAlimentos = findViewById(R.id.botonVerAlimento)

        botonIrIngr = findViewById(R.id.botonIrAnadirIngr)
        //****************************INICIALIZACION DE DAOS****************************************
        daoAlimento = DaoAlimento()


        //****************************EVENTO BOTONES ALIMENTOS*************************************
        manejoCajas()
        botonCalculo.setOnClickListener { mostrarKcal() }
        botonAnadir.setOnClickListener { daoAlimento.anadirAlimento(alimento) }
        botonBorrar.setOnClickListener { daoAlimento.borrarAlimento(alimento) }
        botonVerAlimentos.setOnClickListener { daoAlimento.verAlimentos() }
        botonIrIngr.setOnClickListener { anadirIngr() }

    }

    private fun manejoCajas() {
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
    }

    private fun mostrarKcal() {
        cantidadKcal.text = alimento.calculaKcal().toString() + "kCal"
        //****************Borrado de contenido de las cajas de texto********************
        nombreAlimento.setText("")
        tipoAlimento.setText("")
        cantidadHidratos.setText("")
        cantidadLipidos.setText("")
        cantidadProteinas.setText("")
        //Toast.makeText(this, "Recuerde rellenar los campos", Toast.LENGTH_SHORT).show()
    }

    fun anadirIngr() {
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        intent.putExtra("alimento", alimento)
        startActivity(intent)
    }
}


