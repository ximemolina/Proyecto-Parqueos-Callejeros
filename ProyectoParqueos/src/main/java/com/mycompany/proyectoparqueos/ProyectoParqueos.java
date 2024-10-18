package com.mycompany.proyectoparqueos;
/**
 *
 * @author ximena molina - juan pablo cambronero
 */
import java.io.File;//librería para utilizar archivos

public class ProyectoParqueos { 
    
    public static void main(String[] args) {   
        //inicializan archivos
        File archivoCliente = new File("Cliente.txt");
        File archivoAdministrador = new File("Administrador.txt");
        File archivoInspector = new File("Inspector.txt");
        File archivoParqueo = new File("Parqueo.txt");
        File archivoHistorialMulta = new File("HistorialMulta.txt");
        File archivoHistorialParqueo = new File("HistorialParqueo");
        //se  crean archivos de las clases si no han sido creados                
        try{
            if(!archivoCliente.exists())
                archivoCliente.createNewFile();
        }
        catch(Exception e){
            e.getMessage();
        }
        try{
            if(!archivoAdministrador.exists())
                archivoAdministrador.createNewFile();
        }
        catch(Exception e){
            e.getMessage();
        }
        try{
            if(!archivoInspector.exists())
                archivoInspector.createNewFile();
        }
        catch(Exception e){
            e.getMessage();
        }
        try{
            if(!archivoParqueo.exists())
                archivoParqueo.createNewFile();
        }
        catch(Exception e){
            e.getMessage();
        }
        try{
            if(!archivoHistorialMulta.exists())
                archivoHistorialMulta.createNewFile();
        }
        catch(Exception e){
            e.getMessage();
        }
        try{
            if(!archivoHistorialParqueo.exists())
                archivoHistorialParqueo.createNewFile();
        }
        catch(Exception e){
            e.getMessage();
        }        

        //crear ventana de menu inicial
        Parqueo parqueo = new Parqueo("000000", 0, 0, "00:00", "00:01", 0);
        MenuInicial menuInicial = new MenuInicial(parqueo);
        menuInicial.setVisible(true); //permite que menu inicial sea visible        
        /*
        if (parqueo == null) {
                System.out.println("El objeto parqueo es null");
        } else {
                ArrayList<EspacioDeParqueo> espaciosDisponibles = parqueo.getEspaciosDisponibles();
                System.out.println("todo bien");
        }
        // Agregar espacios de parqueo
        for (int i = 1; i <= 5; i++) {
            EspacioDeParqueo espacio = new EspacioDeParqueo(i); // Espacios del 1 al 5
            parqueo.agregarEspacioParqueo(espacio); // Agregar cada espacio al parqueo
        }

        // Mostrar todos los espacios del parqueo
        System.out.println("Espacios en el parqueo:");
        for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
            System.out.println(espacio);
        }*/
    }
    

    
    
}
