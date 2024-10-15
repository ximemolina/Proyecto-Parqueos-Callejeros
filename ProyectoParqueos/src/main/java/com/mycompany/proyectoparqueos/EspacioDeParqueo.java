
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
            throw new ValidacionesExceptions("El número de espacio debe tener entre 1 y 5 dígitos.");
        }
        this.numeroEspacio = pNumeroEspacio;
    }
    
   public void setTiempoComprado(int pTiempoComprado) {
        this.tiempoComprado = pTiempoComprado; 
    }
    
    public void setCarro(Carro carro){
    if (carro != null){
        this.carro = carro;
        this.disponible = false;
    } else {
        this.carro = null;
        this.disponible = true;
    }
}


    
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
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
