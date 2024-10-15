
package com.mycompany.proyectoparqueos;
import java.text.DecimalFormat;
import java.time.YearMonth;

public class Tarjeta {
    private long numeroTarjeta; // Número de tarjeta de 16 dígitos
    private YearMonth fechaVencimiento; // Solo mes y año ejemplo (2025, 12) 
    private int codigoValidacion; // Código de validación de 3 dígitos

    // Constructor
    public Tarjeta(long numeroTarjeta, YearMonth fechaVencimiento, int codigoValidacion) {
        setNumeroTarjeta(numeroTarjeta);
        setFechaVencimiento(fechaVencimiento);
        setCodigoValidacion(codigoValidacion);
    }
    
    public void setNumeroTarjeta(long numeroTarjeta) {

        String num = String.valueOf(numeroTarjeta);
       
        if (num.length() != 16) {
            throw new ValidacionesExceptions("El número de tarjeta debe tener exactamente 16 dígitos.");
        }else
            this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaVencimiento(YearMonth fechaVencimiento) {
        // Validar la fecha de vencimiento (no debe estar vencida)
        YearMonth fechaActual = YearMonth.now();
        if (fechaVencimiento.isBefore(fechaActual)) {
            throw new ValidacionesExceptions("La tarjeta está vencida.");
        }else
            this.fechaVencimiento = fechaVencimiento;
    }

    public void setCodigoValidacion(int codigoValidacion) {
        // Validar que el código de validación tenga exactamente 3 dígitos
        if ((codigoValidacion > 99) && (codigoValidacion < 1000)) {
            this.codigoValidacion = codigoValidacion;
        }else
            throw new ValidacionesExceptions("El código de validación debe tener exactamente 3 dígitos.");
    }
    
    // Getters
    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public YearMonth getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCodigoValidacion() {
        return codigoValidacion;
    }
}

