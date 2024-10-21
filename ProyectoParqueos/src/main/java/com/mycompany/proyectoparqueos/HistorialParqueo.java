package com.mycompany.proyectoparqueos;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class HistorialParqueo {
    //atributos
    private ArrayList<EspacioDeParqueo> listaParqueo;
    //constructor
    public HistorialParqueo(){
        setListaParqueo();       
    }
    //retornar string con informacion
    public String toString(){
        String info = "";
        for(EspacioDeParqueo espacio : listaParqueo){
            info = espacio.toString()+"\n";
        }
        return info;
    }
    //guarda información en archivo
    public void guardarHistorialParqueo(){
       try{
            File nombreArchivo = new File("HistorialParqueo.txt");
            String contenido = toString();
            FileWriter escribir = new FileWriter(nombreArchivo,true); //permite escribir en diferentes ocasiones en archivos
            escribir.write(toString()); //escribe informarion de usuario
            escribir.close(); //cierra escritor
       } catch(Exception e){
           System.out.print(e.getMessage());
       }
   } 
    //agregar actualización de espacios de parqueo
    public void agregarHistorialParqueo(EspacioDeParqueo espacio){
        listaParqueo.add(espacio);
    }
    //getter
    public ArrayList<EspacioDeParqueo> getListaParqueo() {
        return listaParqueo;
    }
    //setter
    public void setListaParqueo() {
        listaParqueo = new ArrayList<>();
    }

    
}