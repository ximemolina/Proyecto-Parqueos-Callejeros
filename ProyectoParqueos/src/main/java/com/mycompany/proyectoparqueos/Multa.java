
package com.mycompany.proyectoparqueos;

import java.time.*;

public class Multa {
    private Carro carro;
    private int costoMulta;
    private LocalDateTime fechaMulta;
    private boolean estadoPago;
    
    public Multa(Carro carro, int costoMulta, LocalDateTime fechaMulta, boolean estadoPago){
        this.carro = carro;
        this.costoMulta = costoMulta;
        this.fechaMulta = fechaMulta;
        this.estadoPago = false;
    }
    
    public void setCarro(Carro carro){
        this.carro = carro;
    }
    
    public void setCostoMulta(int costoMulta){
        this.costoMulta = costoMulta;
    }
    
    public void setFechaMulta(LocalDateTime fechaMulta) {
        if (fechaMulta != null && fechaMulta.isBefore(LocalDateTime.now())) {
            this.fechaMulta = fechaMulta;
        } else {
            throw new IllegalArgumentException("La fecha de la multa no puede ser futura.");
        }
    }
    
    public void setEstadoPago(boolean estadoPago){
        this.estadoPago = estadoPago;
    }
    
    public Carro getCarro(){
        return carro;
    }
    
    public int getCostoMulta(){
        return costoMulta;
    }
    
    public LocalDateTime getFechaMulta(){
        return fechaMulta;
    }
    
    public boolean getEstadoPago(){
        return estadoPago;
    }
    
    
}
