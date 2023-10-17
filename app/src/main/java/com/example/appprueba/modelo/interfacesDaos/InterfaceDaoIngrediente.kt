package com.example.appprueba.modelo.interfacesDaos

import com.example.appprueba.modelo.entidades.Alimento
import com.example.appprueba.modelo.entidades.Ingrediente

interface InterfaceDaoIngrediente {
    fun anadirIngrediente(alimento : Alimento, ingr: Ingrediente)
    fun borrarIngrediente(ingr: Ingrediente)
    fun modificarIngrediente(oldIngr: Ingrediente, newIngr: Ingrediente)
    fun verListaIngredientes()
}