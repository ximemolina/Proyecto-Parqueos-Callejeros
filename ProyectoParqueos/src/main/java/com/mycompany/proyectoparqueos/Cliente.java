package com.mycompany.proyectoparqueos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.time.*;

/**
 *
 * @author ximena molina - juan pablo cambronero
 */
public class Cliente extends Usuario { 
    private ArrayList<Carro> carros;  // Lista de carros asociados al cliente
    private Tarjeta tarjeta;
    private int minsNoUtilizados;
    
    // Constructor

    /**
     *
     * @param pNombre
     * @param pApellido
     * @param pTelefono
     * @param pCorreo
     * @param pDireccionFisica
     * @param pFechaIngreso
     * @param pPin
     * @param pIdentificacionUsuario
     * @param pNumTarjeta
     * @param pMes
     * @param pAño
     * @param pCodValidacion
     * @param minNoUtilizado
     */
    public Cliente(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso,String pPin, String pIdentificacionUsuario,long pNumTarjeta,int pMes, int pAño, int pCodValidacion, int minNoUtilizado) {
        super(pNombre, pApellido, pTelefono, pCorreo, pDireccionFisica,pFechaIngreso, pPin, pIdentificacionUsuario);
        this.carros = new ArrayList<>();
        
        YearMonth fechaEspecifica = YearMonth.of(pAño, pMes);
        Tarjeta tarjetaNueva = new Tarjeta(pNumTarjeta,fechaEspecifica, pCodValidacion);
        setTarjeta(tarjetaNueva);
        setMinsNoUtilizados(minNoUtilizado);
    }

    /**
     *
     * @return
     */
    public int getMinsNoUtilizados() {
        return minsNoUtilizados;
    }
    
    /**
     *
     * @param minsNoUtilizados
     */
    public void setMinsNoUtilizados(int minsNoUtilizados) {
        this.minsNoUtilizados = minsNoUtilizados;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Carro> getCarros() {
        return carros;
    }
    
    /**
     *
     * @param placa
     * @param marca
     * @param modelo
     */
    public void agregarCarro(String placa, String marca, String modelo) {
        Carro carro = new Carro(placa, marca, modelo);
        carros.add(carro);
    }
    
    /**
     *
     * @param pTarjeta
     */
    public void setTarjeta(Tarjeta pTarjeta){
        tarjeta = pTarjeta;
    }
    
    /**
     *
     * @param carro
     * @return
     */
    public boolean removerCarro(Carro carro) {
        return carros.remove(carro);
    }
    //getter

    /**
     *
     * @return
     */
    public Tarjeta getTarjeta() {
        return tarjeta;
    }
    //retorna string con informaicon

    /**
     *
     * @return
     */
    public String toString(){
        String listaCarros = "";
        for (Carro auto : carros){ //llenar string con informacion de carros
            if (auto.getMarca() != null && auto.getModelo() != null)
                listaCarros = listaCarros + "," + auto.getPlaca() + "," + auto.getMarca() + "," + auto.getModelo();
            else if (auto.getMarca() == null && auto.getModelo() != null){
                listaCarros = listaCarros + "," + auto.getPlaca() + "," + " "+ "," + auto.getModelo();
            } else if(auto.getMarca() != null && auto.getModelo() == null)
                listaCarros = listaCarros + "," + auto.getPlaca() + "," + auto.getMarca()+ "," + " ";
        } 
        return super.toString() + ","+ tarjeta.getNumeroTarjeta() + "," + tarjeta.getFechaVencimiento() + "," + tarjeta.getCodigoValidacion() +","+minsNoUtilizados+ listaCarros;
    }
    
    /**
     *
     * @param carro
     * @param espacioSeleccionado
     * @param parqueo
     * @param archivoParqueo
     * @return
     */
    public boolean parquear(Carro carro, EspacioDeParqueo espacioSeleccionado, Parqueo parqueo, File archivoParqueo) {
        
        if (espacioSeleccionado.getDisponible()) { 
            espacioSeleccionado.setCarro(carro);  
            espacioSeleccionado.setDisponible(false);
            espacioSeleccionado.setHoraFinParqueo(null);
            LocalDateTime horaInicioParqueo = LocalDateTime.now();
            espacioSeleccionado.setHoraInicioParqueo(horaInicioParqueo);
            parqueo.guardarParqueo(archivoParqueo);
            parqueo.getHistorialParqueo().agregarHistorialParqueo(espacioSeleccionado);
            parqueo.getHistorialParqueo().guardarHistorialParqueo();

            System.out.println("Carro parqueado en el espacio: " + espacioSeleccionado.getNumeroEspacio());
            return true;  
        }
        
            System.out.println("El espacio ya está ocupado.");
            return false;  
        }
        
    /**
     *
     * @param carro
     * @param parqueo
     * @param archivoParqueo
     * @return
     */
    public boolean desaparcar(Carro carro, Parqueo parqueo, File archivoParqueo) {
        // Buscar en la lista de espacios del parqueo el carro a desaparcar
        for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
            if (espacio.getCarro() != null && espacio.getCarro().equals(carro)) {
                // Registrar la hora en la que se está desaparcando el carro
                LocalDateTime horaFinParqueo = LocalDateTime.now();
                espacio.setHoraFinParqueo(horaFinParqueo);

                // Guardar el archivo justo antes de resetear los valores
                parqueo.guardarParqueo(archivoParqueo);
                parqueo.getHistorialParqueo().agregarHistorialParqueo(espacio);
                parqueo.getHistorialParqueo().guardarHistorialParqueo();
                // Resetear valores del espacio de parqueo
                espacio.setTiempoComprado(0);
                espacio.setCarro(null);  // Liberar el espacio
                espacio.setDisponible(true);
                espacio.setHoraFinParqueo(null);  // Aseguramos que se seteé a null
                espacio.setHoraInicioParqueo(null);  // Aseguramos que se seteé a null

                // Guardar el archivo nuevamente con los valores reseteados
                parqueo.guardarParqueo(archivoParqueo);
                System.out.println("El carro con placa " + carro.getPlaca() + " ha sido desaparcado.");
                return true;  // Desaparcar con éxito
            }
        }

    // Si no se encontró el carro en el parqueo
    System.out.println("El carro con placa " + carro.getPlaca() + " no está estacionado en este parqueo.");
    return false;  // No se encontró el carro en el parqueo
}

    /**
     *
     * @param cantidad
     * @param espacio
     * @param parqueo
     */
    public void comprarTiempo(int cantidad, EspacioDeParqueo espacio, Parqueo parqueo) {
        // Validar que la cantidad sea positiva
        if (cantidad <= 0) {
            throw new ValidacionesExceptions("La cantidad de tiempo debe ser positiva.");
        }

        // Validar que la cantidad de tiempo sea un múltiplo del precio por hora
        if (cantidad % parqueo.getTiempoMinimo() != 0) {
            throw new ValidacionesExceptions("El tiempo comprado debe ser un múltiplo del tiempo minimo que se puede comprar.");
        }

        // Verificar que el espacio esté ocupado y que el carro en el espacio sea del cliente
        if (!espacio.getDisponible() && carros.contains(espacio.getCarro())) {
            // Actualizar el tiempo comprado en el espacio
            int tiempoActual = espacio.getTiempoComprado();
            espacio.setTiempoComprado(tiempoActual + cantidad);
            System.out.println("Tiempo comprado: " + cantidad + " minutos. Tiempo total ahora: " + espacio.getTiempoComprado() + " minutos.");
        } else {
            System.out.println("No puedes comprar tiempo para este espacio porque no está ocupado por uno de tus carros.");
        }
    }
    
        //modificar los datos de un archivo del admin

    /**
     *
     * @param informacion
     */
    public void modificarDatosCliente(String informacion){
        
        try{
            String [] info = guardarInfoCliente(informacion);

            File archivoAdministrador = new File("Cliente.txt");
            FileWriter leer = new FileWriter(archivoAdministrador, true);
            BufferedWriter buffer = new BufferedWriter(leer);
            
            for(String i : info){ 
                buffer.write(i+"\n");
            
            }
            buffer.close();
            leer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    //contar cantidad total de clientes en el archivo

    /**
     *
     * @param lector
     * @return
     */
    public int totalClientes(BufferedReader lector){
        int numAdmins = 0;
        try{
            while(lector.readLine() != null){
                numAdmins++;
            }
            lector.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return numAdmins;
    }
    
    //guarda la informacion del archivo en arreglo para utilizarla en modificarDatosAdmin

    /**
     *
     * @param informacion
     * @return
     * @throws IOException
     */
    public String[] guardarInfoCliente(String informacion)throws IOException{
        FileReader leer = new FileReader("Cliente.txt");
        BufferedReader buffer = new BufferedReader(leer);
        String [] arreglo = new String[totalClientes(buffer)];
        String[] informacionCompleta = informacion.split(",");
        leer = new FileReader("Cliente.txt");
        buffer = new BufferedReader(leer);
        int elemento = 0;
        String elemento1;
        String elemento2;
        String infoAdmin;
        String[] infoRecopilar;

        while((infoAdmin = buffer.readLine())!= null ){
            infoRecopilar = infoAdmin.split(",");
            elemento1 = infoRecopilar[0];
            elemento2 = informacionCompleta[0];
            if(elemento2.trim().equals(elemento1.trim())){ 
                arreglo[elemento] =informacion;
            }else{
                arreglo[elemento] = infoAdmin;
            }
            elemento ++;
            
        }
        new PrintWriter("Cliente.txt").write("");
        new PrintWriter("Cliente.txt").close();
        buffer.close();
        leer.close();
        return arreglo;
    }
    
    //elimina el archivo del cliente

    /**
     *
     * @param informacion
     */
    public void eliminarCliente(String informacion){
            try{
            String [] info = guardarInfoCliente2(informacion);

            File archivoAdministrador = new File("Cliente.txt");
            FileWriter leer = new FileWriter(archivoAdministrador, true);
            BufferedWriter buffer = new BufferedWriter(leer);

            for(String i : info){ 
                if(i != null){
                    buffer.write(i+"\n");}
            
            }
            buffer.close();
            leer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
        
        //guarda la informacion del archivo excepto por el usuario a eliminar

    /**
     *
     * @param informacion
     * @return
     * @throws IOException
     */
    public String[] guardarInfoCliente2(String informacion)throws IOException{
        FileReader leer = new FileReader("Cliente.txt");
        BufferedReader buffer = new BufferedReader(leer);
        String [] arreglo = new String[totalClientes(buffer)];
        String[] informacionCompleta = informacion.split(",");
        leer = new FileReader("Cliente.txt");
        buffer = new BufferedReader(leer);
        int elemento = 0;
        String elemento1;
        String elemento2;
        String infoAdmin;
        String[] infoRecopilar;
        //System.out.println(informacion);
        while((infoAdmin = buffer.readLine())!= null ){
            infoRecopilar = infoAdmin.split(",");
            elemento1 = infoRecopilar[0];
            elemento2 = informacionCompleta[0];
            if(!elemento2.trim().equals(elemento1.trim())){
                arreglo[elemento] = infoAdmin;
            }
            elemento ++;
            
        }
        new PrintWriter("Cliente.txt").write("");
        new PrintWriter("Cliente.txt").close();
        buffer.close();
        leer.close();
        return arreglo;
    }
    
    /**
     *
     * @param parqueo
     * @param espacioSeleccionado
     * @param tarjeta
     * @param codigoValidacionIngresado
     */
    public void pagar(Parqueo parqueo, EspacioDeParqueo espacioSeleccionado, Tarjeta tarjeta, int codigoValidacionIngresado) {
        // Verificar tarjeta y código de validación (igual que antes)
        YearMonth fechaActual = YearMonth.now();
        if (tarjeta.getFechaVencimiento().isBefore(fechaActual)) {
            System.out.println("Error: La tarjeta está vencida.");
            return;
        }

        if (tarjeta.getCodigoValidacion() != codigoValidacionIngresado) {
            System.out.println("Error: Código de validación incorrecto.");
            return;
        }

        // Calcular el monto total utilizando el método que incluye los minutos no utilizados
        double montoTotal = espacioSeleccionado.calcularMontoAPagar(espacioSeleccionado, parqueo, this);
        espacioSeleccionado.setEstadoPago(true);

        // Realizar el pago
        System.out.println("Pago realizado con éxito. Monto pagado: " + montoTotal + " colones.");
    }



}
       

