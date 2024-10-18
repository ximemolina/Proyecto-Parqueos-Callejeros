package com.mycompany.proyectoparqueos;

import java.util.*;

public class HistorialMultas {
    //atributos
    private ArrayList<Multa> listaMultas;
    //constructor
    public HistorialMultas(){
        setListaMultas();
    }
    //getter
    public ArrayList<Multa> getListaMultas() {
        return listaMultas;
    }
    //setter
    public void setListaMultas() {
        listaMultas = new ArrayList<>();
    }
    //agregar multa a historial de multas
    public void agregarMulta(Multa multa){
        listaMultas.add(multa);
    }
    /*
    La parte de multas del reporte de cliente se haría viendo las placas de los autos del cliente y comparándolas
    con las que tienen las multas.    
    
    La multa ya contiene fecha en que se hace la multa para poder ordenalas de forma descendente en los reportes.
    
    La multa también ya contiene costos entonces sería hacer un if cuya condición sea el intervalo de tiempo y sumar atributos
    de costos.
    */
}
