
package com.mycompany.proyectoparqueos;

import java.time.*;

/**
 *
 * @author ximena molina - juan pablo cambronero
 */
public class Multa {
    private Carro carro;
    private int costoMulta;
    private LocalDateTime fechaMulta;
    private boolean estadoPago;
    private String descripcion = "Su vehículo se encuentra parqueado en un espacio de parqueo que no ha sido pagado.";
    
    /**
     *
     * @param carro
     * @param costoMulta
     * @param fechaMulta
     * @param estadoPago
     */
    public Multa(Carro carro, int costoMulta, LocalDateTime fechaMulta, boolean estadoPago){
        this.carro = carro;
        this.costoMulta = costoMulta;
        this.fechaMulta = fechaMulta;
        this.estadoPago = false;
    }
    
    /**
     *
     * @return
     */
    public String toString(){
        return carro.getPlaca()+"," + carro.getMarca()+","+carro.getModelo()+","+getCostoMulta()+","+ getFechaMulta()+","+getDescripcion();
    }
    
    /**
     *
     * @param carro
     */
    public void setCarro(Carro carro){
        this.carro = carro;
    }
    
    /**
     *
     * @param costoMulta
     */
    public void setCostoMulta(int costoMulta){
        this.costoMulta = costoMulta;
    }
    
    /**
     *
     * @param fechaMulta
     */
    public void setFechaMulta(LocalDateTime fechaMulta) {
        if (fechaMulta != null && fechaMulta.isBefore(LocalDateTime.now())) {
            this.fechaMulta = fechaMulta;
        } else {
            throw new ValidacionesExceptions("La fecha de la multa no puede ser futura.");
        }
    }
    
    /**
     *
     * @param estadoPago
     */
    public void setEstadoPago(boolean estadoPago){
        this.estadoPago = estadoPago;
    }
    
    /**
     *
     * @return
     */
    public Carro getCarro(){
        return carro;
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
    public LocalDateTime getFechaMulta(){
        return fechaMulta;
    }
    
    /**
     *
     * @return
     */
    public boolean getEstadoPago(){
        return estadoPago;
        
    }
    
    /**
     *
     * @return
     */
    public String getDescripcion(){
        return descripcion;
    }
    
    
}
