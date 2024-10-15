
package com.mycompany.proyectoparqueos;
import java.io.*;
import java.time.*;
public class Administrador extends Usuario{//administrador hereda todo del Usuario
    //constructor
    public Administrador(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso,String pPin, String pIdentificacionUsuario){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica, pFechaIngreso,pPin,pIdentificacionUsuario);
    }
    
    //modificar los datos de un archivo del admin
    public void modificarDatosAdmin(){
        FileWriter leer = null;
        BufferedWriter buffer = null;
        try{
            String[] info = guardarInfoAdmin(toString());
            leer = new FileWriter("Administrador.txt, true");
            buffer = new BufferedWriter(leer);
            String[] stringsCompletos;
            for(int i = 0; i < info.length; i++){ //revisar esta linea tmb
                stringsCompletos = info[i].split(",");
                buffer.write("\n"+stringsCompletos[2]+","+ stringsCompletos[3]+","+ stringsCompletos[4]+","+stringsCompletos[5]+","+stringsCompletos[6]+","+stringsCompletos[1]+","+stringsCompletos[0]);
            
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try{
            buffer.close();
            leer.close();
            
            }catch(IOException e){
                System.out.println(e.getMessage());
            
            }
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
        String infoAdmin;
        while((infoAdmin = buffer.readLine())!= null ){
            if(infoAdmin.split(",")[0].equals(informacionCompleta[0])){ //revisar esta linea
                arreglo[elemento] =informacion;
            }else{
                arreglo[elemento] = infoAdmin;
            }
            System.out.println(arreglo[elemento]);
            elemento ++;
            
        }
        new PrintWriter("Administrador.txt").write("");
        new PrintWriter("Administrador.txt").close();
        buffer.close();
        leer.close();
        return arreglo;
    }
    
}
