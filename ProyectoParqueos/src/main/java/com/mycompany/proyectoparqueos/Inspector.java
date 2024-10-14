package com.mycompany.proyectoparqueos;
import java.util.ArrayList;

public class Inspector extends Usuario{
    private ArrayList<Multa> multas;
    
     //constructor
    public Inspector(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, String pPin, String pIdentificacionUsuario){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica,pPin,pIdentificacionUsuario);
    }   
    
    
}
