package com.mycompany.proyectoparqueos;

import java.time.*;
public class Usuario {
    //atributos
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
    private String direccionFisica;
    private LocalDate fechaIngreso;
    private String pin;
    private String identificacionUsuario;
    //constructor
    public Usuario(String pNombre, String pApellido, int pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso, String pPin, String pIdentificacionUsuario){
        setNombre(pNombre);
        setApellido(pApellido);
        setTelefono(pTelefono);
        setCorreo(pCorreo);
        setDireccionFisica(pDireccionFisica);
        setFechaIngreso(pFechaIngreso);
        setPin(pPin);
        setIdentificacionUsuario(pIdentificacionUsuario);
    }
    //setters
    public void setNombre(String pNombre) {
        if(pNombre.length()>= 2 && pNombre.length() <= 20){
            nombre = pNombre;
        }
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getPin() {
        return pin;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }
    
}
