
package com.mycompany.proyectoparqueos;

import java.util.ArrayList;

public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    private ArrayList<Multa> multas;
    
    public Carro(String pPlaca, String pMarca, String pModelo) {
        setPlaca(pPlaca);
        setMarca(pMarca);
        setModelo(pModelo);
        this.multas = new ArrayList<>();  // Inicializar la lista de multas
    }

    
    public void setPlaca(String pPlaca){
        if (String.valueOf(pPlaca).length() < 1 || String.valueOf(pPlaca).length() > 6){
            throw new ValidacionesExceptions("La placa debe tener entre 1 y 6 caracteres.");
        }
        this.placa = pPlaca;
    }
    
    public void setMarca(String pMarca){
        if (String.valueOf(pMarca).length() < 0 || String.valueOf(pMarca).length() > 15){
            throw new ValidacionesExceptions("La marca debe tener entre 0 y 15 caracteres.");
        }
        this.marca = pMarca;
    }
    
    public void setModelo(String pModelo){
        if (String.valueOf(pModelo).length() < 0 || String.valueOf(pModelo).length() > 15){
            throw new ValidacionesExceptions("El modelo debe tener entre 0 y 15 caracteres.");
        }
        this.modelo = pModelo;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void agregarMulta(Multa multa) {
        multas.add(multa);
        System.out.println("Multa añadida al carro con placa: " + placa);
    }
    
    public ArrayList<Multa> getMultas(){
        return multas;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carro carro = (Carro) obj;
        return placa.equals(carro.placa);  
    }
    
    @Override
    
    public int hashCode() {
        return placa.hashCode();  // Utilizar el hashCode de la placa, ya que es el único atributo relevante para la comparación
    }
}
