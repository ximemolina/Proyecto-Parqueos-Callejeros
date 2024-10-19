package com.mycompany.proyectoparqueos;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class HistorialMultas {
    //atributos
    private ArrayList<Multa> listaMultas;
    private ArrayList<String> listaInspectores;
    //constructor
    public HistorialMultas(){
        setListaMultas();
        setListaInspectores();
    }
    //getter
    public ArrayList<Multa> getListaMultas() {
        return listaMultas;
    }
    //setter
    public void setListaMultas() {
        listaMultas = new ArrayList<>();
    }
    public void setListaInspectores(){
        listaInspectores = new ArrayList<>();
    }
    //agregar multa a historial de multas
    public void agregarMulta(Multa multa, String inspector){
        listaMultas.add(multa);
        listaInspectores.add(inspector);
    }
    //retorna toString
    public String toString(){
        String info="";
        int contador = 0;
        int cont;
        for(Multa multa : listaMultas){
            info = multa.toString();
            cont = 0;
            for(String idInspector : listaInspectores){
                if(cont == contador)
                    info = info +","+ idInspector+"\n";
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
}
