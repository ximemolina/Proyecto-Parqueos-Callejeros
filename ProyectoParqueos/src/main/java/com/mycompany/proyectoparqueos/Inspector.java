package com.mycompany.proyectoparqueos;

import java.io.*;
import java.util.ArrayList;
import java.time.*;
public class Inspector extends Usuario{
    private ArrayList<Multa> multas;
    private String codigoTerminal;
     //constructor
    public Inspector(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso, String pPin, String pIdentificacionUsuario, String pCodigoTerminal){
        super(pNombre,pApellido,pTelefono,pCorreo,pDireccionFisica,pFechaIngreso,pPin,pIdentificacionUsuario);
        setCodigoTerminal(pCodigoTerminal);
        
    }   
    //retorna String con Informacion
    public String toString(){
    return super.toString() + ","+ codigoTerminal;
    }
    //modificar los datos de un archivo del admin
    public void modificarDatosInspector(String informacion){
        
        try{
            String [] info = guardarInfoInspector(informacion);

            File archivoAdministrador = new File("Inspector.txt");
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
    
    //contar cantidad total de admins en el archivo
    public int totalInspectores(BufferedReader lector){
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
    public String[] guardarInfoInspector(String informacion)throws IOException{
        FileReader leer = new FileReader("Inspector.txt");
        BufferedReader buffer = new BufferedReader(leer);
        String [] arreglo = new String[totalInspectores(buffer)];
        String[] informacionCompleta = informacion.split(",");
        leer = new FileReader("Inspector.txt");
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
        new PrintWriter("Inspector.txt").write("");
        new PrintWriter("Inspector.txt").close();
        buffer.close();
        leer.close();
        return arreglo;
    }
        
    public void eliminarInspector(String informacion){
            try{
            String [] info = guardarInfoInspector2(informacion);

            File archivoAdministrador = new File("Inspector.txt");
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
    public String[] guardarInfoInspector2(String informacion)throws IOException{
        FileReader leer = new FileReader("Inspector.txt");
        BufferedReader buffer = new BufferedReader(leer);
        String [] arreglo = new String[totalInspectores(buffer)];
        String[] informacionCompleta = informacion.split(",");
        leer = new FileReader("Inspector.txt");
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
        new PrintWriter("Inspector.txt").write("");
        new PrintWriter("Inspector.txt").close();
        buffer.close();
        leer.close();
        return arreglo;
    }    
    
    //setter
    public void setCodigoTerminal(String pCodigoTerminal){
        if(pCodigoTerminal.length() ==6){ 
            String contenido;
            try{
                //se busca en los archivos de inspector, admin y cliente para verificar que id sea único
                FileReader leer = new FileReader("Cliente.txt");
                BufferedReader lectura = new BufferedReader(leer);
                contenido = lectura.readLine(); //lee una línea del archivo
                String [] lista;
                while(contenido != null){

                    try{
                        lista = contenido.split("\\,"); //divide la linea en cada atributo de usuario
                        if(lista[8].equals(pCodigoTerminal) && !lista[1].equals(getPin()) && !lista[2].equals(getNombre())){ //si codigos coinciden entonces tira error

                            throw new ValidacionesExceptions("Error: Codigo de terminal debe ser único en la aplicación");
                        }
                        contenido = lectura.readLine();
                    }catch(ValidacionesExceptions e){
                        throw new ValidacionesExceptions("Error: Código de terminal debe ser único en la aplicación");
                    }
                    
                    catch(Exception e){
                        contenido = lectura.readLine();
                    }
                }} catch(IOException exception){
                exception.printStackTrace();
            }            
            codigoTerminal = pCodigoTerminal;
        }else
            throw new ValidacionesExceptions("Error: Terminal de inspección debe de ser de 6 caracteres exactos");
    }

    public ArrayList<Multa> getMultas() {
        return multas;
    }

    public String getCodigoTerminal() {
        return codigoTerminal;
    }
    
    public void multar(Parqueo parqueo, EspacioDeParqueo espacio, String placaSeleccionada) {
      // Verificar si el espacio tiene un carro estacionado
      if (espacio.getCarro() != null && espacio.getCarro().getPlaca().equals(placaSeleccionada)) {
          // Verificar si el espacio no ha sido pagado
          if (!espacio.getEstadoPago()) {
              // Crear una multa para el carro
              Carro carro = espacio.getCarro();
              Multa nuevaMulta = new Multa(carro, parqueo.getCostoMulta(), LocalDateTime.now(), false);  

              // Asignar la multa al carro (suponiendo que la clase Carro tiene un método para agregar multas)
              carro.agregarMulta(nuevaMulta);
              parqueo.getHistorialMultas().agregarMulta(nuevaMulta, getIdentificacionUsuario());
              parqueo.getHistorialMultas().guardarHistorial();
              // Mensaje de confirmación
              System.out.println("Multa asignada al carro con placa: " + placaSeleccionada);
          } else {
              System.out.println("El espacio ya ha sido pagado. No se necesita una multa.");
          }
      } else {
          System.out.println("No se encontró un carro con esa placa en el espacio seleccionado.");
      }
  }

    
}
