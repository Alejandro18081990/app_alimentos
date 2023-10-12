package com.example.appprueba

import com.example.appprueba.modelo.entidades.Alimento
import com.example.appprueba.modelo.entidades.Ingrediente

class BDApp {
    //COMPANION OBJECT: hace estático su contenido
    companion object {
        var listaAlimentos: MutableList<Alimento> = mutableListOf()
        var listaIngredientes: MutableList<Ingrediente> = mutableListOf()
    }
}