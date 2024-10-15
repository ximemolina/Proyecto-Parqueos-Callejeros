package com.mycompany.proyectoparqueos;
/**
 *
 * @author ximena molina - juan pablo cambronero
 */
import java.io.File;//librería para utilizar archivos
import java.util.ArrayList;
import java.time.*;

public class ProyectoParqueos {

    public static void main(String[] args) {
        //crear ventana de menu inicial
        Parqueo parqueo = new Parqueo("T00123", 30, 10, 6, 22, 50);
        Administrador admin = new Administrador("Juan", "Pérez", "12345678", "juan@example.com", "Dirección Ficticia", LocalDate.now(), "1234", "ID12345");
        MenuInicial menuInicial = new MenuInicial(parqueo);
        menuInicial.setVisible(true); //permite que menu inicial sea visible
        
        File archivoCliente = new File("Cliente.txt");
        File archivoAdministrador = new File("Administrador.txt");
        File archivoInspector = new File("Inspector.txt");
        //se  crean archivos de las clases si no han sido creados
        
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
        }

        // Prueba: Marcar un espacio como ocupado
        System.out.println("\nOcupando el espacio #3...");
        EspacioDeParqueo espacio3 = parqueo.getEspaciosParqueo().get(2); // Obtener el espacio #3 (índice 2 en la lista)
        espacio3.setDisponible(false);

        // Mostrar el estado actualizado de los espacios
        System.out.println("\nEstado de los espacios después de ocupar el espacio #3:");
        for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
            System.out.println(espacio);
        }
        
        
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
