package com.mycompany.proyectoparqueos;

import java.util.ArrayList;

public class Cliente extends Usuario { 
    private ArrayList<Carro> carros;  // Lista de carros asociados al cliente
    private ArrayList<Tarjeta> tarjetas;
    
    // Constructor
    public Cliente(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, String pPin, String pIdentificacionUsuario) {
        super(pNombre, pApellido, pTelefono, pCorreo, pDireccionFisica, pPin, pIdentificacionUsuario);
        this.carros = new ArrayList<>();
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }
    
    public void agregarCarro(Carro carro) {
        carros.add(carro);
    }
    
    
    public boolean removerCarro(Carro carro) {
        return carros.remove(carro);
    }
    
    public void agregarTarjeta(Tarjeta tarjeta){
        tarjetas.add(tarjeta);
    }
    
    public boolean parquear(Carro carro, Parqueo parqueo) {
        // Buscar un espacio disponible en el parqueo
        for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
            if (!espacio.getDisponible()) {  // Si el espacio está libre
                espacio.setCarro(carro);  // Asociar el espacio con el carro
                System.out.println("Carro parqueado en el espacio: " + espacio.getNumeroEspacio());
                return true;  // Carro parqueado con éxito
            }
        }
        System.out.println("No hay espacios disponibles.");
        return false;  // No se pudo parquear porque no hay espacios libres
    }
        
    public boolean desaparcar(Carro carro, Parqueo parqueo) {
        // Buscar en la lista de espacios del parqueo el carro a desaparcar
        for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
            if (espacio.getCarro() != null && espacio.getCarro().equals(carro)) {
                espacio.setCarro(null);  // Liberar el espacio
                System.out.println("El carro con placa " + carro.getPlaca() + " ha sido desaparcado.");
                return true;  // Desaparcar con éxito
            }
        }
        System.out.println("El carro con placa " + carro.getPlaca() + " no está estacionado en este parqueo.");
        return false;  // No se encontró el carro en el parqueo
        }
    
    public void comprarTiempo(int cantidad, EspacioDeParqueo espacio, Parqueo parqueo) {
        // Validar que la cantidad sea positiva
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de tiempo debe ser positiva.");
        }

        // Validar que la cantidad de tiempo sea un múltiplo del precio por hora
        if (cantidad % parqueo.getPrecioHora() != 0) {
            throw new IllegalArgumentException("El tiempo comprado debe ser un múltiplo del precio por hora.");
        }

        // Verificar que el espacio esté ocupado y que el carro en el espacio sea del cliente
        if (espacio.getDisponible() && carros.contains(espacio.getCarro())) {
            // Actualizar el tiempo comprado en el espacio
            int tiempoActual = espacio.getTiempoComprado();
            espacio.setTiempoComprado(tiempoActual + cantidad);
            System.out.println("Tiempo comprado: " + cantidad + " horas. Tiempo total ahora: " + espacio.getTiempoComprado() + " horas.");
        } else {
            System.out.println("No puedes comprar tiempo para este espacio porque no está ocupado por uno de tus carros.");
        }
    }
}
       

