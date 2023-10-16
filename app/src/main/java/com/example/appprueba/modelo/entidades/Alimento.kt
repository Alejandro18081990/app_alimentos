package com.example.appprueba.modelo.entidades

import java.io.Serializable

class Alimento(
    val nombre: String,
    val tipo: String,
    var grHc: Double,
    var grPro: Double,
    var grLip: Double
) : Serializable {
    var listaIngredientes: MutableList<Ingrediente?> = mutableListOf(null)

    init {
        calculaKcal()
    }

    fun calculaCantidades(ingr: Ingrediente) {
        this.grHc += ingr.alimento.grHc * ingr.cantidad / 100
        this.grLip += ingr.alimento.grLip * ingr.cantidad / 100
        this.grPro += ingr.alimento.grPro * ingr.cantidad / 100
    }

    fun calculaKcal(): Double {
        var kCal: Double = 0.0
        kCal = (grHc * 4) + (grLip * 9) + (grPro * 4)
        return kCal
    }

    fun addIngrediente(ingre: Ingrediente) {
        if (ingre in listaIngredientes)
            println("Este ingrediente ya fue añadido ... Revise")
        else
            listaIngredientes.add(ingre)
    }
}