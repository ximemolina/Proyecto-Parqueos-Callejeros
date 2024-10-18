package com.mycompany.proyectoparqueos;

import java.util.*;
public class HistorialParqueo {
    //atributos
    private ArrayList<EspacioDeParqueo> listaParqueo;
    //constructor
    public HistorialParqueo(){
        setListaParqueo();
        
    }
    /*
    Esta clase sería para la parte de historial de parqueo en un intervalo de tiempo
    Lista de Espacios de estado actual se hace con EspaciosParqueo
    En los tiempos se debe poder agarrar meses, dias y horas
    Lo unico que faltaría es costo pero la clase EspacioDeParqueo tiene una función de calcular costo
    */
    //agregar actualización de espacios de parqueo
    public void agregarHistorialParqueo(EspacioDeParqueo espacio){
        listaParqueo.add(espacio);
    }
    //getter
    public ArrayList<EspacioDeParqueo> getListaparqueo() {
        return listaParqueo;
    }
    //setter
    public void setListaParqueo() {
        listaParqueo = new ArrayList<>();
    }

    
}