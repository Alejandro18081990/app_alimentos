package com.example.appprueba.modelo.daos

import android.util.Log
import android.widget.Toast
import com.example.appprueba.BDApp
import com.example.appprueba.MainActivity
import com.example.appprueba.databinding.ActivityMain2Binding
import com.example.appprueba.modelo.entidades.Alimento
import com.example.appprueba.modelo.entidades.Ingrediente
import com.example.appprueba.modelo.interfacesDaos.InterfaceDaoIngrediente

class DaoIngrediente : InterfaceDaoIngrediente {

    //MODIFICAR MÉTODOS PARA USAR LA LISTA DE ALIMENTO
    override fun anadirIngrediente(alimento: Alimento, ingr: Ingrediente) {
        if (ingr == null)
            Log.d("IngredienteIncorrecto", "Ingrediente incorrecto")
        else
            alimento.listaIngredientes.add(ingr)
    }

    override fun borrarIngrediente(ingr: Ingrediente) {
        if (ingr !in BDApp.listaIngredientes)
            println("El ingrediente a borrar no ha sido encontrado")
        else if (ingr == null)
            println("Ingrediente incorrecto")
        else
            BDApp.listaIngredientes.remove(ingr)
    }

    override fun modificarIngrediente(oldIngr: Ingrediente, newIngr: Ingrediente) {
        if (oldIngr == null || newIngr == null)
            println("Ingredientes introducidos incorrectos")
        else if (oldIngr !in BDApp.listaIngredientes)
            println("El ingrediente a modificar no está")
        else {
            var indiceIngredienteModificar = BDApp.listaIngredientes.indexOf(oldIngr)
            BDApp.listaIngredientes.set(indiceIngredienteModificar, newIngr)
        }
    }

    override fun verListaIngredientes() {
        println(BDApp.listaIngredientes.toString())
    }
}