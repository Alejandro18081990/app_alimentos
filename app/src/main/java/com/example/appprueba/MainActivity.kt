package com.example.appprueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.appprueba.databinding.ActivityMainBinding
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
    private lateinit var botonCalculo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Asignamos las vistas a las propiedades de la clase
        nombreAlimento = findViewById(R.id.nombreAlimento)
        tipoAlimento = findViewById(R.id.tipoAlimento)
        cantidadHidratos = findViewById(R.id.cantidadHidratos)
        cantidadLipidos = findViewById(R.id.cantidadLipidos)
        cantidadProteinas = findViewById(R.id.cantidadProteinas)
        cantidadKcal = findViewById(R.id.resultadoKcal)
        botonCalculo = findViewById(R.id.botonKiloCaloria)
        botonCalculo.setOnClickListener { mostrarKcal() }

        setSupportActionBar(binding.toolbar)

    }

    private fun mostrarKcal() {
        //Convertimos a los tipos de datos que correspondan y guardamos en variables
        val cajaNombre = nombreAlimento.text.toString()
        val cajaTipo = tipoAlimento.text.toString()
        val cajaHidratos = cantidadHidratos.text.toString().toDouble()
        val cajaLipidos = cantidadLipidos.text.toString().toDouble()
        val cajaProteinas = cantidadProteinas.text.toString().toDouble()


        //Instancia de la clase alimento para acceder a los métodos
        val alimento = Alimento(cajaNombre, cajaTipo, cajaHidratos, cajaLipidos, cajaProteinas)

        cantidadKcal.text = alimento.calculaKcal().toString() + "kCal"
        Toast.makeText(this,"Recuerde rellenar los campos",Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}