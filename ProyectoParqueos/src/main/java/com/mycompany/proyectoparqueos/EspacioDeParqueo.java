package com.mycompany.proyectoparqueos;

import java.time.*;

public class EspacioDeParqueo {
    private int numeroEspacio;
    private int tiempoComprado;
    private Carro carro;
    private boolean disponible;
    private boolean estadoPago;
    private LocalDateTime horaInicioParqueo;
    private LocalDateTime horaFinParqueo;

    // Constructor
    public EspacioDeParqueo(int pNumeroEspacio){
        setNumeroEspacio(pNumeroEspacio);
        tiempoComprado = 0;
        carro = null;
        disponible = true;
        estadoPago = false;
        horaInicioParqueo = null;
        horaInicioParqueo = null;
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
    
    public void setEstadoPago(boolean estadoPago){
        this.estadoPago = estadoPago;
    }
    
    public void setHoraInicioParqueo(LocalDateTime horaInicioParqueo){
            this.horaInicioParqueo = horaInicioParqueo;
        }
    
    
    public void setHoraFinParqueo(LocalDateTime horaFinParqueo){
            this.horaFinParqueo = horaFinParqueo;
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
    
    public boolean getEstadoPago(){
        return estadoPago;
    }
    
    public boolean getDisponible(){
        return disponible;
    }
    
    public LocalDateTime getHoraInicioParqueo(){
        return horaInicioParqueo;
    }

    public LocalDateTime getHoraFinParqueo() {
        return horaFinParqueo;
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

    public double calcularMontoAPagar(EspacioDeParqueo espacio, Parqueo parqueo, Cliente cliente) {
        // Verificar si el parqueo está dentro del horario de operación
        if (!parqueo.estaDentroDeHorario()) {
            System.out.println("El parqueo está fuera de horario de operación. No se requiere pago.");
            return 0;  // No se cobra si está fuera del horario de operación
        }

        // Calcular el tiempo de parqueo en minutos
        long minutosParqueo = calcularTiempoParqueo(espacio);

        // Obtener el tiempo mínimo que se debe pagar (en minutos)
        int tiempoMinimo = parqueo.getTiempoMinimo();

        // Si el tiempo de parqueo es menor que el tiempo mínimo, se cobrará por el tiempo mínimo
        long minutosFacturables = Math.max(minutosParqueo, tiempoMinimo);

        // Restar los minutos no utilizados del cliente
        if (cliente.getMinsNoUtilizados() > 0) {
            minutosFacturables -= cliente.getMinsNoUtilizados();  // Restar minutos no utilizados
        }

        // Asegurarse de que los minutos facturables no sean negativos
        if (minutosFacturables < 0) {
            minutosFacturables = 0;  // Evitar valores negativos
        }

        // Calcular el número de horas a facturar, redondeando hacia arriba
        double horasFacturables = Math.ceil(minutosFacturables / 60.0);

        // Obtener el precio por hora desde el parqueo
        int precioPorHora = parqueo.getPrecioHora();

        // Calcular el monto total
        double montoTotal = horasFacturables * precioPorHora;

        // Asegurarse de que el monto total no sea negativo
        if (montoTotal < 0) {
            montoTotal = 0;
        }

        // Resetear los minutos no utilizados del cliente después de calcular el monto
        cliente.setMinsNoUtilizados(0);

        return montoTotal;
    }
    
    public long calcularTiempoRestante() {
        LocalDateTime horaInicio = this.getHoraInicioParqueo();
        LocalDateTime horaActual = LocalDateTime.now();

        // Tiempo en minutos desde que el carro fue aparcado
        long minutosParqueo = Duration.between(horaInicio, horaActual).toMinutes();

        // Restar el tiempo ya utilizado del tiempo comprado
        long minutosRestantes = this.tiempoComprado - minutosParqueo;

        return minutosRestantes > 0 ? minutosRestantes : 0;  // Retornar solo los minutos restantes positivos
    }



    public String toString() {
        // Verificamos si horaInicioParqueo y horaFinParqueo son null
        String horaInicioStr = (getHoraInicioParqueo() != null) ? getHoraInicioParqueo().toString() : "null";
        String horaFinStr = (getHoraFinParqueo() != null) ? getHoraFinParqueo().toString() : "null";

        try {
            return getNumeroEspacio() + "," + getTiempoComprado() + "," + getCarro().getPlaca() + "," +
                   getCarro().getMarca() + "," + getCarro().getModelo() + "," + horaInicioStr + "," + horaFinStr + "," + getDisponible() + "\n";
        } catch (NullPointerException e) {
            return getNumeroEspacio() + "," + getTiempoComprado() + ",," + "," + "," + horaInicioStr + "," + horaFinStr + "," + getDisponible() + "\n";
        }
    }

}


