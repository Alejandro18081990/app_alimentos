package com.example.appprueba.modelo.interfacesDaos

import com.example.appprueba.modelo.entidades.Alimento

interface InterfaceDaoAlimento {
    //AÑADIR ALIMENTOS A MUTABLELIST DE BDApp
    fun anadirAlimento(alimento: Alimento)
    //VER ALIMENTOS A MUTABLELIST DE BDApp
    fun verAlimentos()
    //BORRAR ALIMENTOS A MUTABLELIST DE BDApp
    fun borrarAlimento(alimento: Alimento)

}