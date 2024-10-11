package com.mycompany.proyectoparqueos;

import java.time.*;
public class Usuario {
    //atributos
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
    private String direccionFisica;
    private LocalDateTime fechaIngreso;
    private String pin;
    private String identificacionUsuario;
    //constructor
    public Usuario(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, String pPin, String pIdentificacionUsuario) {
            setNombre(pNombre);
            setApellido(pApellido);
            setTelefono(pTelefono);
            setCorreo(pCorreo);
            setDireccionFisica(pDireccionFisica);
            setFechaIngreso();
            setPin(pPin);
            setIdentificacionUsuario(pIdentificacionUsuario);
    }
    //setters
    public void setNombre(String pNombre){
        if(pNombre.length()>= 2 && pNombre.length() <= 20){
            nombre = pNombre;
        }else{
            throw new ValidacionesExceptions("Error: Nombre debe ser de 2 a 20 caracteres");
        }
    }

    public void setApellido(String pApellido){
        if(pApellido.length()>= 1 && pApellido.length() <= 40){
            apellido = pApellido;
        }else{
            throw new ValidacionesExceptions("Error: Apellido debe ser de 1 a 40 caracteres");
        }
    }

    public void setTelefono(String telefono){
        try{
            int num= Integer.parseInt(telefono);
            if(num>=10000000 && num<=99999999)
                this.telefono = num;
            else
                throw new ValidacionesExceptions("Error: Telefono debe tener 8 digitos exactos");
        }catch(NumberFormatException e){
            throw new ValidacionesExceptions("Error: Telefono debe ser un número entero");
        }
    }

    public void setCorreo(String pCorreo) {
        if(pCorreo.contains("@")){
            String [] partesSeparadas = pCorreo.split("@");
            if(partesSeparadas[0].length() >= 3 && partesSeparadas[1].length() >= 3)
                correo = pCorreo;
            else
                throw new ValidacionesExceptions("Error: Correo inválido");
        } else{
            throw new ValidacionesExceptions("Error: Correo debe contener @");
        }

    }

    public void setDireccionFisica(String pDireccionFisica) {
        if(pDireccionFisica.length()>= 5 && pDireccionFisica.length() <= 60){
            direccionFisica = pDireccionFisica;
        }else{
            throw new ValidacionesExceptions("Error: Direccion fisica debe ser de 5 a 60 caracteres");
        }
        
    }

    public void setFechaIngreso() {
        LocalDateTime hoy = LocalDateTime.now();  
        fechaIngreso = hoy;
    }

    public void setPin(String pPin) {
        if(pPin.length() == 4)
            pin = pPin;
        else
            throw new ValidacionesExceptions("Error: PIN debe tener 4 caracteres exactos");
    }

    public void setIdentificacionUsuario(String pIdentificacionUsuario) {
        if(pIdentificacionUsuario.length()>= 2 && pIdentificacionUsuario.length() <= 25)
            identificacionUsuario = pIdentificacionUsuario;
        else
            throw new ValidacionesExceptions("Error: Identificacion debe tener de 2 a 25 caracteres");
    }
    
    //getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public String getPin() {
        return pin;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }
    
}
