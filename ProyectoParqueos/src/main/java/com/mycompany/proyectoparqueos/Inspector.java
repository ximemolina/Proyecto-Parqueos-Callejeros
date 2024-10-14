package com.mycompany.proyectoparqueos;
import java.util.ArrayList;
import java.time.*;
public class Inspector extends Usuario{
    private ArrayList<Multa> multas;
    
     //constructor
    public Inspector(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso, String pPin, String pIdentificacionUsuario){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica,pFechaIngreso,pPin,pIdentificacionUsuario);
    }   
    
    
}
