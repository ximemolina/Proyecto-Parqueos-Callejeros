package com.mycompany.proyectoparqueos;

import java.time.*;

public class EspacioDeParqueo {
    private int numeroEspacio;
    private int tiempoComprado;
    private Carro carro;
    private boolean disponible;
    private LocalDateTime horaInicioParqueo;

    // Constructor
    public EspacioDeParqueo(int pNumeroEspacio){
        setNumeroEspacio(pNumeroEspacio);
        tiempoComprado = 0;
        carro = null;
        disponible = true;
        horaInicioParqueo = null;  // Inicializa en null hasta que el carro se parquea
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
        if (carro != null) {
            this.carro = carro;
            this.disponible = false;
            setHoraInicioParqueo(LocalDateTime.now());  // Asigna la hora actual al parquear
        } else {
            this.carro = null;
            this.disponible = true;
            setHoraInicioParqueo(null);  // Si no hay carro, reinicia la hora de parqueo
        }
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
    
    public void setHoraInicioParqueo(LocalDateTime horaInicioParqueo){
        if (horaInicioParqueo != null) {
            this.horaInicioParqueo = horaInicioParqueo;
        }
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
    
    public LocalDateTime getHoraInicioParqueo(){
        return horaInicioParqueo;
    }
    
    public long calcularTiempoParqueo(EspacioDeParqueo espacio) {
        LocalDateTime horaInicio = espacio.getHoraInicioParqueo();
        LocalDateTime horaActual = LocalDateTime.now();

        // Verificar que horaInicio no sea null
        if (horaInicio == null) {
            return 0; // Si no hay hora de inicio, el tiempo es 0
        }

        // Calcular la diferencia en minutos
        long minutosParqueo = Duration.between(horaInicio, horaActual).toMinutes();

        return minutosParqueo;
    }

    public double calcularMontoAPagar(EspacioDeParqueo espacio, Parqueo parqueo) {
        // Calcular el tiempo de parqueo en minutos
        long minutosParqueo = calcularTiempoParqueo(espacio);

        // Obtener el tiempo mínimo que se debe pagar (en minutos)
        int tiempoMinimo = parqueo.getTiempoMinimo();

        // Si el tiempo de parqueo es menor que el tiempo mínimo, se cobrará por el tiempo mínimo
        long minutosFacturables = Math.max(minutosParqueo, tiempoMinimo);

        // Calcular el número de horas a facturar, redondeando hacia arriba
        double horasFacturables = Math.ceil(minutosFacturables / 60.0);

        // Obtener el precio por hora desde el parqueo
        int precioPorHora = parqueo.getPrecioHora();

        // Calcular el monto total
        double montoTotal = horasFacturables * precioPorHora;

        return montoTotal;
    }

    public String toString(){
        try{
            return getNumeroEspacio() +","+ getTiempoComprado() + "," + getCarro().getPlaca()+","+getCarro().getMarca()+","+getCarro().getModelo() + "," + getDisponible() +"\n";
        }catch(NullPointerException e){
            return getNumeroEspacio() +","+ getTiempoComprado() + "," +","+"," + "," + getDisponible() +"\n";
        }
    }
}
