
package com.mycompany.proyectoparqueos;

import java.time.YearMonth;

public class Tarjeta {
    private String numeroTarjeta; // Número de tarjeta de 16 dígitos
    private YearMonth fechaVencimiento; // Solo mes y año ejemplo (2025, 12) 
    private String codigoValidacion; // Código de validación de 3 dígitos

    // Constructor
    public Tarjeta(String numeroTarjeta, YearMonth fechaVencimiento, String codigoValidacion) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoValidacion = codigoValidacion;
    }

    // Getters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public YearMonth getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }
}

