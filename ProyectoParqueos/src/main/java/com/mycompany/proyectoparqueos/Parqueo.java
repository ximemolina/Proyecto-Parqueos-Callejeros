
package com.mycompany.proyectoparqueos;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Parqueo {
    private String codigoTerminal;
    private int tiempoMinimo;
    private int precioHora;
    private LocalTime abre;
    private LocalTime cierra;
    private int costoMulta;
    private ArrayList<EspacioDeParqueo> espaciosParqueo;
    private HistorialMultas historialMultas;
    private HistorialParqueo historialParqueo;
    
    public Parqueo(String pCodigoTerminal, int pTiempoMinimo, int pPrecioHora, String pAbre, String pCierra, int pCostoMulta){
        setCodigoTerminal(pCodigoTerminal);
        setTiempoMinimo(pTiempoMinimo);
        setPrecioHora(pPrecioHora);
        setAbre(pAbre);
        setCierra(pCierra);
        setCostoMulta(pCostoMulta);
        espaciosParqueo = new ArrayList<>();
    }

    public void setHistorialMultas(HistorialMultas historialMultas) {
        this.historialMultas = historialMultas;
    }

    public void setHistorialParqueo(HistorialParqueo historialParqueo) {
        this.historialParqueo = historialParqueo;
    }

    public HistorialMultas getHistorialMultas() {
        return historialMultas;
    }

    public HistorialParqueo getHistorialParqueo() {
        return historialParqueo;
    }
    
    //retorna toda la informacion del parqueo en un String
    public String toString(){
        String info = "";
        for(EspacioDeParqueo espacio : espaciosParqueo){ //agarra toda la información almacenada en el array
            info= info + espacio.toString();
        }
        return getCodigoTerminal()+"\n"+getTiempoMinimo()+"\n"+getPrecioHora()+"\n"+ getAbre()+"\n"+getCierra()+"\n"+getCostoMulta()+"\n"+info;
    
    }
    
        
    //setters
    public void setCodigoTerminal(String codigoTerminal) {
        if (codigoTerminal != null && codigoTerminal.length() == 6) {
            this.codigoTerminal = codigoTerminal;
        } 
        else {
            throw new ValidacionesExceptions("Código terminal inválido: Debe tener exactamente 6 caracteres.");
        }
    }
    
    public void setTiempoMinimo(int pTiempoMinimo) {
        if (pTiempoMinimo >= 0) { 
            this.tiempoMinimo = pTiempoMinimo;
        } 
        else {
            throw new ValidacionesExceptions("El tiempo mínimo debe ser un número entero positivo.");
        }
    }
    
    public void setPrecioHora(int pPrecioHora) {
        if (pPrecioHora % 2 == 0) {
            this.precioHora = pPrecioHora;
        } 
        else {
            throw new ValidacionesExceptions("El precio por hora debe ser un número entero par.");
        }
    }

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");
    
    public void setAbre(String pAbre) {
        try {
            this.abre = LocalTime.parse(pAbre, TIME_FORMATTER);
            System.out.println("Horario de apertura establecido: " + this.abre);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de hora de apertura inválido. Por favor, ingrese en formato HH:mm");
        }
    }
    
    public void setCierra(String pCierra) {
        try {
            LocalTime horaCierre = LocalTime.parse(pCierra, TIME_FORMATTER);
            
            if (horaCierre.isAfter(abre)) {
                this.cierra = horaCierre;
                System.out.println("Horario de cierre establecido: " + this.cierra);
            } else {
                System.out.println("La hora de cierre debe ser posterior a la hora de apertura.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de hora de cierre inválido. Por favor, ingrese en formato HH:mm");
        }
    }
    
    public void setCostoMulta(int pCostoMulta) {
        if (pCostoMulta >= 0) {
            this.costoMulta = pCostoMulta;
        } 
        else {
            throw new ValidacionesExceptions("El costo de la multa no puede ser negativo.");
        }
    }
    
    public void setEspaciosParqueo(ArrayList<EspacioDeParqueo> pEspaciosParqueo){
        espaciosParqueo = pEspaciosParqueo;
    }
    
    public String getCodigoTerminal(){
        return codigoTerminal;
    }
    
    public int getTiempoMinimo(){
        return tiempoMinimo;
    }
    
    public int getPrecioHora(){
        return precioHora;
    }
    
    public LocalTime getAbre(){
        return abre;
    }
    
    public LocalTime getCierra(){
        return cierra;
    }
    
    public int getCostoMulta(){
        return costoMulta;
    }
    
    public ArrayList<EspacioDeParqueo> getEspaciosParqueo(){
        return espaciosParqueo;
    }
    
    public ArrayList<EspacioDeParqueo> getEspaciosDisponibles() {
        ArrayList<EspacioDeParqueo> espaciosDisponibles = new ArrayList<>();

        for (EspacioDeParqueo espacio : espaciosParqueo) {
            // Si el espacio no está ocupado, se agrega a la lista de disponibles
            if (espacio.getDisponible()) {
                espaciosDisponibles.add(espacio);
            }
        }

        return espaciosDisponibles; // Retorna la lista de espacios disponibles
    }
    
    public void agregarEspacioParqueo(EspacioDeParqueo espacio) {
        if (!espacioExiste(espacio.getNumeroEspacio())) {
            espaciosParqueo.add(espacio);
        } else {
            throw new ValidacionesExceptions("El espacio de parqueo " + espacio.getNumeroEspacio() + " ya existe.");
        }
    }

    private boolean espacioExiste(int numeroEspacio) {
        for (EspacioDeParqueo espacio : espaciosParqueo) {
            if (espacio.getNumeroEspacio() == numeroEspacio) {
                return true; 
            }
        }
        return false;
    }
    
    public void agregarGrupoEspacios(int inicio, int fin) {
        if (inicio > fin) {
            throw new ValidacionesExceptions("El rango de inicio para agregar debe ser menor o igual que el final.");
        }

        for (int i = inicio; i <= fin; i++) {
            if (!espacioExiste(i)) {
                EspacioDeParqueo nuevoEspacio = new EspacioDeParqueo(i); 
                espaciosParqueo.add(nuevoEspacio); 
            } else {
                System.out.println("El espacio de parqueo " + i + " ya existe. No se puede agregar.");
            }
        }
    }
    
    private void eliminarEspacio(int numeroEspacio) {
        for (int i = 0; i < espaciosParqueo.size(); i++) {
            if (espaciosParqueo.get(i).getNumeroEspacio() == numeroEspacio) {
                espaciosParqueo.remove(i);
                return;
            }
        }
    }
    
    public void eliminarGrupoEspacios(int inicio, int fin) {
        if (inicio > fin) {
            throw new ValidacionesExceptions("El rango de inicio debe ser menor o igual que el final.");
        }

        for (int i = inicio; i <= fin; i++) {
            if (espacioExiste(i)) {
                eliminarEspacio(i);
                System.out.println("Espacio de parqueo " + i + " eliminado.");
            } else {
                System.out.println("El espacio de parqueo " + i + " no existe. No se puede eliminar.");
            }
        }
    }
    
    public void mostrarEspaciosYCarros() {
        for (EspacioDeParqueo espacio : this.getEspaciosParqueo()) {
            Carro carro = espacio.getCarro();
            if (carro != null) {
                System.out.println("Espacio " + espacio.getNumeroEspacio() + " - Ocupado por carro: " + carro.getPlaca());
            } else {
                System.out.println("Espacio " + espacio.getNumeroEspacio() + " - Libre");
            }
        }
    }
    
    public boolean estaDentroDeHorario() {
        LocalTime horaActual = LocalTime.now();
        return horaActual.isAfter(abre) && horaActual.isBefore(cierra);
    }
    
    //guarda información en archivo
   public void guardarParqueo(File nombreArchivo){
       try{
            FileWriter escribir = new FileWriter(nombreArchivo); //permite escribir en diferentes ocasiones en archivos
            escribir.write(toString()); //escribe informarion de usuario
            escribir.close(); //cierra escritor
       } catch(Exception e){
           System.out.print(e.getMessage());
       }
   } 
   
}
