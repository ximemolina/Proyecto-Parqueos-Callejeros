
package com.mycompany.proyectoparqueos;
import java.io.*;
import java.time.*;
public class Administrador extends Usuario{//administrador hereda todo del Usuario
    //constructor
    public Administrador(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso,String pPin, String pIdentificacionUsuario){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica, pFechaIngreso,pPin,pIdentificacionUsuario);
    }
    
    //modificar los datos de un archivo del admin
    public void modificarDatosAdmin(String informacion){
        
        try{
            String [] info = guardarInfoAdmin(informacion);

            File archivoAdministrador = new File("Administrador.txt");
            FileWriter leer = new FileWriter(archivoAdministrador, true);
            BufferedWriter buffer = new BufferedWriter(leer);

            for(String i : info){ //revisar esta linea tmb
                buffer.write(i+"\n");
            
            }
            buffer.close();
            leer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    //contar cantidad total de admins en el archivo
    public int totalAdmins(BufferedReader lector){
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
    
    public String[] guardarInfoAdmin(String informacion)throws IOException{
        FileReader leer = new FileReader("Administrador.txt");
        BufferedReader buffer = new BufferedReader(leer);
        String [] arreglo = new String[totalAdmins(buffer)];
        String[] informacionCompleta = informacion.split(",");
        leer = new FileReader("Administrador.txt");
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
            if(elemento2.trim().equals(elemento1.trim())){ //revisar esta linea
                arreglo[elemento] =informacion;
            }else{
                arreglo[elemento] = infoAdmin;
            }
            elemento ++;
            
        }
        new PrintWriter("Administrador.txt").write("");
        new PrintWriter("Administrador.txt").close();
        buffer.close();
        leer.close();
        return arreglo;
    }
    
}
