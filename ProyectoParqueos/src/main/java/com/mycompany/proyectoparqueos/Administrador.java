
package com.mycompany.proyectoparqueos;

import java.time.*;
public class Administrador extends Usuario{//administrador hereda todo del Usuario
    //constructor
    public Administrador(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso,String pPin, String pIdentificacionUsuario){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica, pFechaIngreso,pPin,pIdentificacionUsuario);
    }

}
