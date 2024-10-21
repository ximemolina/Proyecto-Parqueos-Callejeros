package com.mycompany.proyectoparqueos;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 *
 * @author ximena molina - juan pablo cambronero
 */
public class HistorialMultas {
    //atributos
    private ArrayList<Multa> listaMultas;
    private ArrayList<String> listaInspectores;
    //constructor

    /**
     *
     */
    public HistorialMultas(){
        setListaMultas();
        setListaInspectores();
    }
    //getter

    /**
     *
     * @return
     */
    public ArrayList<Multa> getListaMultas() {
        return listaMultas;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getListaInspectores() {
        return listaInspectores;
    }
    
    //setter

    /**
     *
     */
    public void setListaMultas() {
        listaMultas = new ArrayList<>();
    }

    /**
     *
     */
    public void setListaInspectores(){
        listaInspectores = new ArrayList<>();
    }
    //agregar multa a historial de multas

    /**
     *
     * @param multa
     * @param inspector
     */
    public void agregarMulta(Multa multa, String inspector){
        listaMultas.add(multa);
        listaInspectores.add(inspector);
    }
    //retorna toString

    /**
     *
     * @return
     */
    public String toString(){
        String info="";
        for(Multa multa : listaMultas){
            info = multa.toString()+info;
        }
        return info;
    }
    //actualizar archivo de HistorialMultas

    /**
     *
     */
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
