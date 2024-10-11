
package com.mycompany.proyectoparqueos;

public class EspacioDeParqueo {
    private int numeroEspacio;
    private int tiempoComprado;
    private Carro carro;
    private boolean disponible;
    
    public EspacioDeParqueo(int pNumeroEspacio){
        setNumeroEspacio(pNumeroEspacio);
        tiempoComprado = 0;
        carro = null;
        disponible = true;
    }
    
    public void setNumeroEspacio(int pNumeroEspacio) {   
        if (String.valueOf(pNumeroEspacio).length() < 1 || String.valueOf(pNumeroEspacio).length() > 5) {
            throw new IllegalArgumentException("El número de espacio debe tener entre 1 y 5 dígitos.");
        }
        this.numeroEspacio = pNumeroEspacio;
    }
    
    public void setTiempoComprado(int pTiempoComprado, Parqueo parqueo) {
        if (pTiempoComprado % parqueo.getPrecioHora() != 0) {
            throw new IllegalArgumentException("El tiempo comprado debe ser un múltiplo del precio por hora.");
        }
        this.tiempoComprado = pTiempoComprado;
    }
    
    public int getNumeroEspacio(){
        return numeroEspacio;
    }
    
    public int getTiempoComprado(){
        return tiempoComprado;
    }
    
    public Carro getCarro(){
        return carro;
    }
    
    public boolean getDisponible(){
        return disponible;
    }
    
    public String toString(){
        return "Numero de espacio: "+ getNumeroEspacio() +" Tiempo Comprado: " + getTiempoComprado() +
        " Carro: " + getCarro() + " Disponible: " + getDisponible();
    }
    
}
