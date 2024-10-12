package com.mycompany.proyectoparqueos;
/**
 *
 * @author ximena molina - juan pablo cambronero
 */
import java.io.File;//librería para utilizar archivos

public class ProyectoParqueos {

    public static void main(String[] args) {
        //crear ventana de menu inicial
        MenuInicial menuInicial = new MenuInicial();
        menuInicial.setVisible(true); //permite que menu inicial sea visible
        
        File archivoCliente = new File("Cliente.txt");
        File archivoAdministrador = new File("Administrador.txt");
        File archivoInspector = new File("Inspector.txt");
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
    }
    
}
