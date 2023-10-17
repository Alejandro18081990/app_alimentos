package com.example.appprueba

import com.example.appprueba.modelo.entidades.Alimento
import com.example.appprueba.modelo.entidades.Ingrediente
import java.io.Serializable

class BDApp  {
    //COMPANION OBJECT: hace estático su contenido
    companion object {
        var listaAlimentos: MutableList<Alimento> = mutableListOf()
    }
}