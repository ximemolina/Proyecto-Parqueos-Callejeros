
package com.mycompany.proyectoparqueos;


public class Administrador extends Usuario{//administrador hereda todo del Usuario
    //constructor
    public Administrador(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, String pPin, String pIdentificacionUsuario){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica,pPin,pIdentificacionUsuario);
    }
}
