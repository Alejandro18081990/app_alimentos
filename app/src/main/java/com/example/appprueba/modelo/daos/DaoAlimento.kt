package com.example.appprueba.modelo.daos

import android.util.Log
import com.example.appprueba.BDApp
import com.example.appprueba.modelo.entidades.Alimento

class DaoAlimento {

    fun anadirAlimento(alimento: Alimento) {
        if (alimento == null)
            println("Alimento nulo")
        else
            BDApp.listaAlimentos.add(alimento)
    }

    fun verAlimentos() {
        for (alimento in BDApp.listaAlimentos) {
            println(alimento)
        }
    }

    fun borrarAlimento(alimento: Alimento) {
        if (alimento !in BDApp.listaAlimentos)
            Log.d("Este alimento no existe", alimento.toString())
        else
            BDApp.listaAlimentos.remove(alimento)
    }
}