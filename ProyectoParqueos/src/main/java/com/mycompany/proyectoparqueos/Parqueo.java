
package com.mycompany.proyectoparqueos;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author ximena molina - juan pablo cambronero
 */
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
    
    /**
     *
     * @param pCodigoTerminal
     * @param pTiempoMinimo
     * @param pPrecioHora
     * @param pAbre
     * @param pCierra
     * @param pCostoMulta
     */
    public Parqueo(String pCodigoTerminal, int pTiempoMinimo, int pPrecioHora, String pAbre, String pCierra, int pCostoMulta){
        setCodigoTerminal(pCodigoTerminal);
        setTiempoMinimo(pTiempoMinimo);
        setPrecioHora(pPrecioHora);
        setAbre(pAbre);
        setCierra(pCierra);
        setCostoMulta(pCostoMulta);
        espaciosParqueo = new ArrayList<>();
    }

    /**
     *
     * @param historialMultas
     */
    public void setHistorialMultas(HistorialMultas historialMultas) {
        this.historialMultas = historialMultas;
    }

    /**
     *
     * @param historialParqueo
     */
    public void setHistorialParqueo(HistorialParqueo historialParqueo) {
        this.historialParqueo = historialParqueo;
    }

    /**
     *
     * @return
     */
    public HistorialMultas getHistorialMultas() {
        return historialMultas;
    }

    /**
     *
     * @return
     */
    public HistorialParqueo getHistorialParqueo() {
        return historialParqueo;
    }
    
    //retorna toda la informacion del parqueo en un String

    /**
     *
     * @return
     */
    public String toString(){
        String info = "";
        for(EspacioDeParqueo espacio : espaciosParqueo){ //agarra toda la información almacenada en el array
            info= info + espacio.toString();
        }
        return getCodigoTerminal()+"\n"+getTiempoMinimo()+"\n"+getPrecioHora()+"\n"+ getAbre()+"\n"+getCierra()+"\n"+getCostoMulta()+"\n"+info;
    
    }
    
        
    //setters

    /**
     *
     * @param codigoTerminal
     */
    public void setCodigoTerminal(String codigoTerminal) {
        if (codigoTerminal != null && codigoTerminal.length() == 6) {
            this.codigoTerminal = codigoTerminal;
        } 
        else {
            throw new ValidacionesExceptions("Código terminal inválido: Debe tener exactamente 6 caracteres.");
        }
    }
    
    /**
     *
     * @param pTiempoMinimo
     */
    public void setTiempoMinimo(int pTiempoMinimo) {
        if (pTiempoMinimo >= 0) { 
            this.tiempoMinimo = pTiempoMinimo;
        } 
        else {
            throw new ValidacionesExceptions("El tiempo mínimo debe ser un número entero positivo.");
        }
    }
    
    /**
     *
     * @param pPrecioHora
     */
    public void setPrecioHora(int pPrecioHora) {
        if (pPrecioHora % 2 == 0) {
            this.precioHora = pPrecioHora;
        } 
        else {
            throw new ValidacionesExceptions("El precio por hora debe ser un número entero par.");
        }
    }

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");
    
    /**
     *
     * @param pAbre
     */
    public void setAbre(String pAbre) {
        try {
            this.abre = LocalTime.parse(pAbre, TIME_FORMATTER);
            System.out.println("Horario de apertura establecido: " + this.abre);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de hora de apertura inválido. Por favor, ingrese en formato HH:mm");
        }
    }
    
    /**
     *
     * @param pCierra
     */
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
    
    /**
     *
     * @param pCostoMulta
     */
    public void setCostoMulta(int pCostoMulta) {
        if (pCostoMulta >= 0) {
            this.costoMulta = pCostoMulta;
        } 
        else {
            throw new ValidacionesExceptions("El costo de la multa no puede ser negativo.");
        }
    }
    
    /**
     *
     * @param pEspaciosParqueo
     */
    public void setEspaciosParqueo(ArrayList<EspacioDeParqueo> pEspaciosParqueo){
        espaciosParqueo = pEspaciosParqueo;
    }
    
    /**
     *
     * @return
     */
    public String getCodigoTerminal(){
        return codigoTerminal;
    }
    
    /**
     *
     * @return
     */
    public int getTiempoMinimo(){
        return tiempoMinimo;
    }
    
    /**
     *
     * @return
     */
    public int getPrecioHora(){
        return precioHora;
    }
    
    /**
     *
     * @return
     */
    public LocalTime getAbre(){
        return abre;
    }
    
    /**
     *
     * @return
     */
    public LocalTime getCierra(){
        return cierra;
    }
    
    /**
     *
     * @return
     */
    public int getCostoMulta(){
        return costoMulta;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<EspacioDeParqueo> getEspaciosParqueo(){
        return espaciosParqueo;
    }
    
    /**
     *
     * @return
     */
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
    
    /**
     *
     * @param espacio
     */
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
    
    /**
     *
     * @param inicio
     * @param fin
     */
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
    
    /**
     *
     * @param inicio
     * @param fin
     */
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
    
    /**
     *
     */
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
    
    /**
     *
     * @return
     */
    public boolean estaDentroDeHorario() {
        LocalTime horaActual = LocalTime.now();
        return horaActual.isAfter(abre) && horaActual.isBefore(cierra);
    }
    
    //guarda información en archivo

    /**
     *
     * @param nombreArchivo
     */
   public void guardarParqueo(File nombreArchivo){
       try{
            FileWriter escribir = new FileWriter(nombreArchivo); //permite escribir en diferentes ocasiones en archivos
            System.out.println("Datos a guardar: " + toString());
            escribir.write(toString()); //escribe informarion de usuario
            escribir.close(); //cierra escritor
       } catch(Exception e){
           System.out.print(e.getMessage());
       }
   }
   
   public EspacioDeParqueo buscarEspacioPorCarro(Carro carro) {
        for (EspacioDeParqueo espacio : espaciosParqueo) {
            if (espacio.getCarro() != null && espacio.getCarro().equals(carro)) {
                return espacio;
            }
        }
        return null;  // Si no se encuentra el espacio
    }
   
   


   
}
