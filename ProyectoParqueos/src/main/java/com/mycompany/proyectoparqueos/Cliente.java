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

public class Cliente extends Usuario { 
    private ArrayList<Carro> carros;  // Lista de carros asociados al cliente
    private Tarjeta tarjeta;
    private int minsNoUtilizados;
    // Constructor
    public Cliente(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso,String pPin, String pIdentificacionUsuario,long pNumTarjeta,int pMes, int pAño, int pCodValidacion, int minNoUtilizado) {
        super(pNombre, pApellido, pTelefono, pCorreo, pDireccionFisica,pFechaIngreso, pPin, pIdentificacionUsuario);
        this.carros = new ArrayList<>();
        
        YearMonth fechaEspecifica = YearMonth.of(pAño, pMes);
        Tarjeta tarjetaNueva = new Tarjeta(pNumTarjeta,fechaEspecifica, pCodValidacion);
        setTarjeta(tarjetaNueva);
        setMinsNoUtilizados(minNoUtilizado);
    }

    public int getMinsNoUtilizados() {
        return minsNoUtilizados;
    }
    
    
    public void setMinsNoUtilizados(int minsNoUtilizados) {
        this.minsNoUtilizados = minsNoUtilizados;
    }
    
    public ArrayList<Carro> getCarros() {
        return carros;
    }
    
    public void agregarCarro(String placa, String marca, String modelo) {
        Carro carro = new Carro(placa, marca, modelo);
        carros.add(carro);
    }
    
    public void setTarjeta(Tarjeta pTarjeta){
        tarjeta = pTarjeta;
    }
    
    public boolean removerCarro(Carro carro) {
        return carros.remove(carro);
    }
    //getter
    public Tarjeta getTarjeta() {
        return tarjeta;
    }
    //retorna string con informaicon
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
    
    public boolean parquear(Carro carro, EspacioDeParqueo espacioSeleccionado) {
        
        if (espacioSeleccionado.getDisponible()) { 
            espacioSeleccionado.setCarro(carro);  
            espacioSeleccionado.setDisponible(false); 

            System.out.println("Carro parqueado en el espacio: " + espacioSeleccionado.getNumeroEspacio());
            return true;  
        }
        
            System.out.println("El espacio ya está ocupado.");
            return false;  
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
       

