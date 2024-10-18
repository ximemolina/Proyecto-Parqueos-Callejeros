package com.mycompany.proyectoparqueos;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class HistorialMultas {
    //atributos
    private ArrayList<Multa> listaMultas;
    private ArrayList<Inspector> listaInspectores;
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
    public void agregarMulta(Multa multa, Inspector inspector){
        listaMultas.add(multa);
        listaInspectores.add(inspector);
    }
    //retorna toString
    public String toString(){
        String info="";
        int contador = 0;
        int cont;
        for(Multa multa : listaMultas){
            info = info + multa.toString();
            cont = 0;
            for(Inspector persona : listaInspectores){
                if(cont == contador)
                    info = info + persona.getIdentificacionUsuario()+"\n";
                cont++;
            }
            contador ++;
        }
        return info;
    }
    //actualizar archivo de HistorialMultas
    public void guardarHistorial(){
       File archivoHistorialMulta = new File("HistorialMulta.txt");
       try{
            FileWriter escribir = new FileWriter(archivoHistorialMulta, true); //permite escribir en diferentes ocasiones en archivos
            escribir.write(toString()); //escribe informarion de usuario
            escribir.close(); //cierra escritor
       } catch(Exception e){
           System.out.print(e.getMessage());
       }
    }
    /*
    La parte de multas del reporte de cliente se haría viendo las placas de los autos del cliente y comparándolas
    con las que tienen las multas.    
    
    La multa ya contiene fecha en que se hace la multa para poder ordenalas de forma descendente en los reportes.
    
    La multa también ya contiene costos entonces sería hacer un if cuya condición sea el intervalo de tiempo y sumar atributos
    de costos.
    */
}
