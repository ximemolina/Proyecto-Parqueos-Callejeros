
package com.mycompany.proyectoparqueos;

public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    
    public Carro(String pPlaca, String pMarca, String pModelo){
        setPlaca(pPlaca);
        setMarca(pMarca);
        setModelo(pModelo);
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
      
}
