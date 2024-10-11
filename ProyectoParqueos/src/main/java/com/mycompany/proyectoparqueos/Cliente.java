package com.mycompany.proyectoparqueos;

public class Cliente extends Usuario{ //cliente hereda todo del usuario
    //constructor
    public Cliente(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, String pPin, String pIdentificacionUsuario){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica,pPin,pIdentificacionUsuario);
    }
}
