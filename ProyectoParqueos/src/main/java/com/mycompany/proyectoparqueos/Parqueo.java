
package com.mycompany.proyectoparqueos;

import java.util.ArrayList;
import java.time.LocalTime;

public class Parqueo {
    private String codigoTerminal;
    private int tiempoMinimo;
    private int precioHora;
    private int abre;
    private int cierra;
    private int costoMulta;
    private ArrayList<EspacioDeParqueo> espaciosParqueo;
    
    public Parqueo(String pCodigoTerminal, int pTiempoMinimo, int pPrecioHora, int pAbre, int pCierra, int pCostoMulta){
        setCodigoTerminal(pCodigoTerminal);
        setTiempoMinimo(pTiempoMinimo);
        setPrecioHora(pPrecioHora);
        setAbre(pAbre);
        setCierra(pCierra);
        setCostoMulta(pCostoMulta);
        espaciosParqueo = new ArrayList<>();
    }
    
    public void setCodigoTerminal(String codigoTerminal) {
        if (codigoTerminal != null && codigoTerminal.length() == 6) {
            this.codigoTerminal = codigoTerminal;
        } 
        else {
            throw new IllegalArgumentException("Código terminal inválido: Debe tener exactamente 6 caracteres.");
        }
    }
    
    public void setTiempoMinimo(int pTiempoMinimo) {
        if (pTiempoMinimo >= 0) { 
            this.tiempoMinimo = pTiempoMinimo;
        } 
        else {
            throw new IllegalArgumentException("El tiempo mínimo debe ser un número entero positivo.");
        }
    }
    
    public void setPrecioHora(int pPrecioHora) {
        if (pPrecioHora % 2 == 0) {
            this.precioHora = pPrecioHora;
        } 
        else {
            throw new IllegalArgumentException("El precio por hora debe ser un número entero par.");
        }
    }

    
    public void setAbre(int pAbre) {
        LocalTime horaApertura = LocalTime.of(pAbre / 100, pAbre % 100); // pAbre está en formato HHMM (por ejemplo, 830 para 08:30)
        this.abre = pAbre;
    }
    
    public void setCierra(int pCierra) {
        LocalTime horaCierre = LocalTime.of(pCierra / 100, pCierra % 100); // pCierra está en formato HHMM (por ejemplo, 1630 para 16:30)
        if (horaCierre.isAfter(LocalTime.of(abre / 100, abre % 100))) {
            this.cierra = pCierra;
        } 
        else {
            throw new IllegalArgumentException("La hora de cierre debe ser posterior a la hora de apertura.");
        }
    }
    
    public void setCostoMulta(int pCostoMulta) {
        if (pCostoMulta >= 0) {
            this.costoMulta = pCostoMulta;
        } 
        else {
            throw new IllegalArgumentException("El costo de la multa no puede ser negativo.");
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
    
    public int getAbre(){
        return abre;
    }
    
    public int getCierra(){
        return cierra;
    }
    
    public int getCostoMulta(){
        return costoMulta;
    }
    
    public ArrayList<EspacioDeParqueo> getEspaciosParqueo(){
        return espaciosParqueo;
    }
    
    public void configuracionParqueo(){
        // falta implementar la configuracion solo la puede usar el administrador
    }
    
    public void agregarEspacioParqueo(EspacioDeParqueo espacio) {
        if (!espacioExiste(espacio.getNumeroEspacio())) {
            espaciosParqueo.add(espacio);
        } else {
            throw new IllegalArgumentException("El espacio de parqueo " + espacio.getNumeroEspacio() + " ya existe.");
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
            throw new IllegalArgumentException("El rango de inicio para agregar debe ser menor o igual que el final.");
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
            throw new IllegalArgumentException("El rango de inicio debe ser menor o igual que el final.");
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
}
