package com.mycompany.proyectoparqueos;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.time.*;
import javax.swing.JOptionPane;
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
    public Usuario(String pNombre, String pApellido, String pTelefono, String pCorreo, String pDireccionFisica, LocalDate pFechaIngreso,String pPin, String pIdentificacionUsuario) {
            setNombre(pNombre);
            setApellido(pApellido);
            setTelefono(pTelefono);
            setCorreo(pCorreo);
            setDireccionFisica(pDireccionFisica);
            setFechaIngreso(pFechaIngreso);
            setPin(pPin);
            setIdentificacionUsuario(pIdentificacionUsuario);
    }
    //guarda información en archivo
   public void guardarUsuario(File nombreArchivo){
       try{
            FileWriter escribir = new FileWriter(nombreArchivo, true); //permite escribir en diferentes ocasiones en archivos
            escribir.write(toString()); //escribe informarion de usuario
            escribir.close(); //cierra escritor
       } catch(Exception e){
           System.out.print(e.getMessage());
       }
   } 
    //retornar String con informacion
    public String toString(){
        LocalDate fecha = getFechaIngreso();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // Convertir LocalDate a String
        String fechaEnTexto = fecha.format(formato);
        return "\n" + getIdentificacionUsuario() + "," + getPin() +"," + getNombre() +"," + getApellido()+","+getTelefono()+","+getCorreo()+","+getDireccionFisica()+","+ fechaEnTexto;
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
            try{
                String [] partesSeparadas = pCorreo.split("@");
                if(partesSeparadas[0].length() >= 3 && partesSeparadas[1].length() >= 3)
                    correo = pCorreo;
                else
                    throw new ValidacionesExceptions("Error: Correo inválido");}
            catch(Exception e){
                throw new ValidacionesExceptions("Error: Correo inválido");
            }
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

    public void setFechaIngreso(LocalDate pFechaIngreso) {
        LocalDate hoy = LocalDate.now();  
        if (pFechaIngreso.isBefore(hoy) || pFechaIngreso.isEqual(hoy)) {
            fechaIngreso = pFechaIngreso;
        } else {
            throw new ValidacionesExceptions("Fecha de ingreso como trabajador debe ser menor o igual a la fecha actual");
        }
        
    }

    public void setPin(String pPin) {
        
        if(pPin.length() == 4){
            
            pin = pPin;
        }
        else
            throw new ValidacionesExceptions("Error: PIN debe tener 4 caracteres exactos");
    }

    public void setIdentificacionUsuario(String pIdentificacionUsuario) {
        if(pIdentificacionUsuario.length()>= 2 && pIdentificacionUsuario.length() <= 25){
            String contenido;
            try{
                //se busca en los archivos de inspector, admin y cliente para verificar que id sea único
                FileReader leer = new FileReader("Cliente.txt");
                BufferedReader lectura = new BufferedReader(leer);
                contenido = lectura.readLine(); //lee una línea del archivo
                String [] lista;
                while(contenido != null){

                    try{
                        lista = contenido.split(","); //divide la linea en cada atributo de usuario
                        if(lista[0].equals(pIdentificacionUsuario) && !lista[1].equals(getPin()) && !lista[2].equals(getNombre())){ //si id coinciden, entonces tira error

                            throw new ValidacionesExceptions("Error: Identificación debe ser única en la aplicación");
                        }
                        contenido = lectura.readLine();
                    }catch(ValidacionesExceptions e){
                        throw new ValidacionesExceptions("Error: Identificación debe ser única en la aplicación");
                    }
                    
                    catch(Exception e){
                        contenido = lectura.readLine();
                    }
                }
                leer.close();
                lectura.close();
                leer = new FileReader("Administrador.txt");
                lectura = new BufferedReader(leer);
                contenido = lectura.readLine(); //lee una línea del archivo
                String [] lista2;
                while(contenido != null){

                    try{
                        lista2 = contenido.split(","); //divide la linea en cada atributo de usuario
                        if(lista2[0].equals(pIdentificacionUsuario) && !lista2[1].equals(getPin()) && !lista2[2].equals(getNombre())){//si id coinciden, entonces tira error

                            throw new ValidacionesExceptions("Error: Identificación debe ser única en la aplicación");
                        }
                        contenido = lectura.readLine();
                    }catch(ValidacionesExceptions e){
                        throw new ValidacionesExceptions("Error: Identificación debe ser única en la aplicación");
                    }
                    catch(Exception e){
                        contenido = lectura.readLine();
                    }
                }
                leer.close();
                lectura.close();
                leer = new FileReader("Inspector.txt");
                lectura = new BufferedReader(leer);
                contenido = lectura.readLine(); //lee una línea del archivo
                String [] lista3;
                while(contenido != null){

                    try{
                        lista3 = contenido.split(","); //divide la linea en cada atributo de usuario
                        if(lista3[0].equals(pIdentificacionUsuario) && !lista3[1].equals(getPin()) && !lista3[2].equals(getNombre())){//si id coinciden, entonces tira error

                            throw new ValidacionesExceptions("Error: Identificación debe ser única en la aplicación");
                        }
                        contenido = lectura.readLine();
                    }catch(ValidacionesExceptions e){
                        throw new ValidacionesExceptions("Error: Identificación debe ser única en la aplicación");
                    }
                    catch(Exception e){
                        contenido = lectura.readLine();
                    }
                }             
                identificacionUsuario = pIdentificacionUsuario;

            } catch(IOException exception){
                exception.printStackTrace();
            }
        }
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
