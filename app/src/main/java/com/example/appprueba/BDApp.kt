package com.example.appprueba

import com.example.appprueba.modelo.entidades.Alimento

class BDApp {
    private var listaAlimentos: MutableList<Alimento> = mutableListOf()

    fun getListaAlimentos(): MutableList<Alimento> {
        return listaAlimentos
    }

    fun addAlimento(alimento: Alimento) {
        listaAlimentos.add(alimento)
    }
}