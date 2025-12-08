package com.mycompany.proyectoparqueos;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author ximena molina - juan pablo cambronero
 */
public class ReporteAdmin {
    
    private Parqueo parqueo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private int index;
    private int index2;

    /**
     *
     * @param parqueo
     * @param fechaInicio
     * @param fechaFinal
     * @param index
     * @param index2
     */
    public ReporteAdmin(Parqueo parqueo, LocalDateTime fechaInicio, LocalDateTime fechaFinal, int index, int index2){
        setParqueo(parqueo);
        setFechaInicio(fechaInicio);
        setFechaFinal(fechaFinal);
        setIndex(index);
        setIndex2(index2);
    }
    //getters

    /**
     *
     * @return
     */
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }
    //funcion para ingresos de dinero de estacionamiento en un periodo de tiempo

    /**
     *
     * @return
     */
    public int ingresosDinero(){
        int monto = 0;
        if(fechaInicio==null && fechaFinal == null){ //si ambos están en null, se calcula total ingresos
            for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){
                monto = monto + espacio.getTiempoComprado();
            }
            return monto;
        }
        if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
              for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){
                try{
                    if((espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        monto = monto + espacio.getTiempoComprado();}
                }catch(NullPointerException e){
                    
                }     
            } 
            return monto;
        }
        if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
              for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio)){ 
                        monto = monto + espacio.getTiempoComprado();}
                }catch(NullPointerException e){
                    
                }     
            } 
            return monto;
        }
        if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
              for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio) && (espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        monto = monto + espacio.getTiempoComprado();}
                }catch(NullPointerException e){
                    
                }     
            } 
            return monto;
        }return monto;
    }
     //funcion de ingresos por multas

    /**
     *
     * @return
     */
    public int ingresosMultas(){
        int monto = 0;
        if(fechaInicio==null && fechaFinal == null){ //si ambos están en null, se calcula total ingresos
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                monto = monto + multa.getCostoMulta();
            }
            return monto;
        }
        if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
              for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                try{
                    if((multa.getFechaMulta()).isBefore(fechaFinal)){ 
                        monto = monto + multa.getCostoMulta();}
                }catch(NullPointerException e){
                    
                }     
            } 
            return monto;
        }
        if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
              for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                try{
                    if((multa.getFechaMulta()).isAfter(fechaInicio)){ 
                        monto = monto + multa.getCostoMulta();}
                }catch(NullPointerException e){
                    
                }     
            } 
            return monto;
        }
        if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
              for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                try{
                    if((multa.getFechaMulta()).isAfter(fechaInicio) && (multa.getFechaMulta()).isBefore(fechaFinal)){ 
                        monto = monto + multa.getCostoMulta();}
                }catch(NullPointerException e){
                    
                }     
            } 
            return monto;
        }return monto;
    } 
    //funcion de lista de espacios de parqueos según su estado actual

    /**
     *
     * @return
     */
    public String listaEspaciosActuales(){
        String info = "";
        if(index == 0){ //se deben mostrar todos los espacios
            for(EspacioDeParqueo espacio: parqueo.getEspaciosParqueo()){
                if(espacio.getDisponible() == false){
                    String contenido;
                    try{
                        FileReader leer = new FileReader("Cliente.txt");
                        BufferedReader lectura = new BufferedReader(leer);
                        contenido = lectura.readLine(); //lee una línea del archivo
                        String [] lista;
                        while(contenido != null){

                            try{
                                lista = contenido.split("\\,"); //divide la linea en cada atributo de administrador
                                int contador = 12;
                                while(contador < lista.length){
                                    if(lista[contador].equals(espacio.getCarro().getPlaca())){
                                        LocalDate fecha = LocalDate.parse(lista[7], DateTimeFormatter.ofPattern("yyyy/MM/dd"));

                                        int min = Integer.parseInt(lista[11]);
                                        long num = Long.parseLong(lista[8]);
                                        String[] añoMes = lista[9].split("-");
                                        int año = Integer.parseInt(añoMes[0]);
                                        int mes = Integer.parseInt(añoMes[1]);
                                        int cod = Integer.parseInt(lista[10]);
                                        //crea objeto Cliente con atributos respectivos para poder pasarselos a pantalla de acciones de admin
                                        Cliente cliente = new Cliente(lista[2], lista[3],lista[4], lista[5], lista[6], fecha, lista[1], lista[0],num,mes,año,cod,min);

                                            try{
                                                if(" ".equals(String.valueOf(lista[contador+1]))){
                                                    if(lista[contador+2]== ""){
                                                        cliente.agregarCarro(lista[contador], "", "");}
                                                    else{
                                                        cliente.agregarCarro(lista[contador], "", lista[contador+2]);
                                                    }}
                                                else{
                                                    if(lista[contador+2]== ""){
                                                        cliente.agregarCarro(lista[contador], lista[contador+1], "");}
                                                    else{
                                                        cliente.agregarCarro(lista[contador], lista[contador+1], lista[contador+2]);}}
                                            }catch(ArrayIndexOutOfBoundsException e ){
                                                cliente.agregarCarro(lista[contador], "", "");
                                            }
                                        LocalDateTime fechaHoraActual = LocalDateTime.now();
                                        info = info +"Número de espacio ocupado: "+espacio.getNumeroEspacio()+" | Placa: "+ espacio.getCarro().getPlaca() + " | Costo: "+ espacio.calcularMontoAPagar(espacio, parqueo, cliente)+ " | Tiempos reservados: " + espacio.getHoraInicioParqueo() + "----"+ fechaHoraActual+ "\n";
                                        break;
                                    }
                                    contador = contador +3;
                                }
                                contenido = lectura.readLine();
                            }catch(Exception e){
                                e.printStackTrace();
                                contenido = lectura.readLine();
                            }
                        }            
                    } catch(IOException exception){
                        exception.printStackTrace();
                    }
                    
                }else if (espacio.getDisponible() == true){
                    info = info +"Numero de espacio libre: "+espacio.getNumeroEspacio()+"\n";
                }
            }                
        }else if (index == 1){ //se deben mostrar solo espacios ocupados
            info = "Espacios Ocupados:\n";
            for(EspacioDeParqueo espacio: parqueo.getEspaciosParqueo()){
                if(espacio.getDisponible() == false){
                    String contenido;
                    try{
                        FileReader leer = new FileReader("Cliente.txt");
                        BufferedReader lectura = new BufferedReader(leer);
                        contenido = lectura.readLine(); //lee una línea del archivo
                        String [] lista;
                        while(contenido != null){

                            try{
                                lista = contenido.split("\\,"); //divide la linea en cada atributo de administrador
                                int contador = 12;
                                while(contador < lista.length){
                                    if(lista[contador].equals(espacio.getCarro().getPlaca())){
                                        LocalDate fecha = LocalDate.parse(lista[7], DateTimeFormatter.ofPattern("yyyy/MM/dd"));

                                        int min = Integer.parseInt(lista[11]);
                                        long num = Long.parseLong(lista[8]);
                                        String[] añoMes = lista[9].split("-");
                                        int año = Integer.parseInt(añoMes[0]);
                                        int mes = Integer.parseInt(añoMes[1]);
                                        int cod = Integer.parseInt(lista[10]);
                                        //crea objeto Cliente con atributos respectivos para poder pasarselos a pantalla de acciones de admin
                                        Cliente cliente = new Cliente(lista[2], lista[3],lista[4], lista[5], lista[6], fecha, lista[1], lista[0],num,mes,año,cod,min);

                                            try{
                                                if(" ".equals(String.valueOf(lista[contador+1]))){
                                                    if(lista[contador+2]== ""){
                                                        cliente.agregarCarro(lista[contador], "", "");}
                                                    else{
                                                        cliente.agregarCarro(lista[contador], "", lista[contador+2]);
                                                    }}
                                                else{
                                                    if(lista[contador+2]== ""){
                                                        cliente.agregarCarro(lista[contador], lista[contador+1], "");}
                                                    else{
                                                        cliente.agregarCarro(lista[contador], lista[contador+1], lista[contador+2]);}}
                                            }catch(ArrayIndexOutOfBoundsException e ){
                                                cliente.agregarCarro(lista[contador], "", "");
                                            }
                                        LocalDateTime fechaHoraActual = LocalDateTime.now();
                                        info = info +"Número de espacio: "+espacio.getNumeroEspacio()+" | Placa: "+ espacio.getCarro().getPlaca() + " | Costo: "+ espacio.calcularMontoAPagar(espacio, parqueo, cliente)+ " | Tiempos reservados: " + espacio.getHoraInicioParqueo() + "----"+ fechaHoraActual+ "\n";
                                        break;
                                    }
                                    contador = contador +3;
                                }
                                contenido = lectura.readLine();
                            }catch(Exception e){
                                e.printStackTrace();
                                contenido = lectura.readLine();
                            }
                        }            
                    } catch(IOException exception){
                        exception.printStackTrace();
                    }
                }
            }           
        }else if (index == 2){ //se deben mostrar solo espacios desocupados
            info = "Espacios desocupados: \n";
            for(EspacioDeParqueo espacio: parqueo.getEspaciosParqueo()){
                if (espacio.getDisponible() == true)
                    info = info +"Numero de espacio: "+espacio.getNumeroEspacio()+"\n";
            }
        } 
        return info; //se retorna string con toda la información obtenida
    }

    //funcion de historial en un periodo de tiempo de los espacios usados

    /**
     *
     * @return
     */
    public String historialEspaciosUsados(){
        String info = "";
        for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){ //se recorre todo el historial de parqueos
            if(fechaInicio==null && fechaFinal == null){ //si ambas son null, se tomaran las multas de todo el tiempo
                try{
                    if(!espacio.getHoraFinParqueo().equals("null")){
                        String contenido;
                        try{
                            FileReader leer = new FileReader("Cliente.txt");
                            BufferedReader lectura = new BufferedReader(leer);
                            contenido = lectura.readLine(); //lee una línea del archivo
                            String [] lista;
                            while(contenido != null){

                                try{
                                    lista = contenido.split("\\,"); //divide la linea en cada atributo de administrador
                                    int contador = 12;
                                    while(contador < lista.length){
                                        if(lista[contador].equals(espacio.getCarro().getPlaca())){
                                            LocalDate fecha = LocalDate.parse(lista[7], DateTimeFormatter.ofPattern("yyyy/MM/dd"));

                                            int min = Integer.parseInt(lista[11]);
                                            long num = Long.parseLong(lista[8]);
                                            String[] añoMes = lista[9].split("-");
                                            int año = Integer.parseInt(añoMes[0]);
                                            int mes = Integer.parseInt(añoMes[1]);
                                            int cod = Integer.parseInt(lista[10]);
                                            //crea objeto Cliente con atributos respectivos para poder pasarselos a pantalla de acciones de admin
                                            Cliente cliente = new Cliente(lista[2], lista[3],lista[4], lista[5], lista[6], fecha, lista[1], lista[0],num,mes,año,cod,min);

                                                try{
                                                    if(" ".equals(String.valueOf(lista[contador+1]))){
                                                        if(lista[contador+2]== ""){
                                                            cliente.agregarCarro(lista[contador], "", "");}
                                                        else{
                                                            cliente.agregarCarro(lista[contador], "", lista[contador+2]);
                                                        }}
                                                    else{
                                                        if(lista[contador+2]== ""){
                                                            cliente.agregarCarro(lista[contador], lista[contador+1], "");}
                                                        else{
                                                            cliente.agregarCarro(lista[contador], lista[contador+1], lista[contador+2]);}}
                                                }catch(ArrayIndexOutOfBoundsException e ){
                                                    cliente.agregarCarro(lista[contador], "", "");
                                                }
                                             info = "Número de espacio: "+espacio.getNumeroEspacio() +" | Placa: "+espacio.getCarro().getPlaca()+ " | Costo: "+espacio.calcularMontoAPagar(espacio, parqueo, cliente)+" | Hora de Parqueo: "+espacio.getHoraInicioParqueo()+ " | Hora de Desaparqueo: "+espacio.getHoraFinParqueo()+"\n"+info;
                                            break;
                                        }
                                        contador = contador +3;
                                    }
                                    contenido = lectura.readLine();
                                }catch(Exception e){
                                    e.printStackTrace();
                                    contenido = lectura.readLine();
                                }
                            }            
                        } catch(IOException exception){
                            exception.printStackTrace();
                        }

                    }
                }catch(Exception e){}
            }
             if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
                try{
                    if((espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        try{
                            if(!espacio.getHoraFinParqueo().equals("null")){
                               String contenido;
                               try{
                                   FileReader leer = new FileReader("Cliente.txt");
                                   BufferedReader lectura = new BufferedReader(leer);
                                   contenido = lectura.readLine(); //lee una línea del archivo
                                   String [] lista;
                                   while(contenido != null){

                                       try{
                                           lista = contenido.split("\\,"); //divide la linea en cada atributo de administrador
                                           int contador = 12;
                                           while(contador < lista.length){
                                               if(lista[contador].equals(espacio.getCarro().getPlaca())){
                                                   LocalDate fecha = LocalDate.parse(lista[7], DateTimeFormatter.ofPattern("yyyy/MM/dd"));

                                                   int min = Integer.parseInt(lista[11]);
                                                   long num = Long.parseLong(lista[8]);
                                                   String[] añoMes = lista[9].split("-");
                                                   int año = Integer.parseInt(añoMes[0]);
                                                   int mes = Integer.parseInt(añoMes[1]);
                                                   int cod = Integer.parseInt(lista[10]);
                                                   //crea objeto Cliente con atributos respectivos para poder pasarselos a pantalla de acciones de admin
                                                   Cliente cliente = new Cliente(lista[2], lista[3],lista[4], lista[5], lista[6], fecha, lista[1], lista[0],num,mes,año,cod,min);

                                                       try{
                                                           if(" ".equals(String.valueOf(lista[contador+1]))){
                                                               if(lista[contador+2]== ""){
                                                                   cliente.agregarCarro(lista[contador], "", "");}
                                                               else{
                                                                   cliente.agregarCarro(lista[contador], "", lista[contador+2]);
                                                               }}
                                                           else{
                                                               if(lista[contador+2]== ""){
                                                                   cliente.agregarCarro(lista[contador], lista[contador+1], "");}
                                                               else{
                                                                   cliente.agregarCarro(lista[contador], lista[contador+1], lista[contador+2]);}}
                                                       }catch(ArrayIndexOutOfBoundsException e ){
                                                           cliente.agregarCarro(lista[contador], "", "");
                                                       }
                                                    info = "Número de espacio: "+espacio.getNumeroEspacio() +" | Placa: "+espacio.getCarro().getPlaca()+ " | Costo: "+espacio.calcularMontoAPagar(espacio, parqueo, cliente)+" | Hora de Parqueo: "+espacio.getHoraInicioParqueo()+ " | Hora de Desaparqueo: "+espacio.getHoraFinParqueo()+"\n"+info;
                                                    break;
                                               }
                                               contador = contador +3;
                                           }
                                           contenido = lectura.readLine();
                                       }catch(Exception e){
                                           e.printStackTrace();
                                           contenido = lectura.readLine();
                                       }
                                   }            
                               } catch(IOException exception){
                                   exception.printStackTrace();
                               }

                           }  
                        }catch(Exception e){}
                    }
                }catch(Exception e){}
            }
            if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio)){
                        if(!espacio.getHoraFinParqueo().equals("null")){
                            String contenido;
                            try{
                                FileReader leer = new FileReader("Cliente.txt");
                                BufferedReader lectura = new BufferedReader(leer);
                                contenido = lectura.readLine(); //lee una línea del archivo
                                String [] lista;
                                while(contenido != null){

                                    try{
                                        lista = contenido.split("\\,"); //divide la linea en cada atributo de administrador
                                        int contador = 12;
                                        while(contador < lista.length){
                                            if(lista[contador].equals(espacio.getCarro().getPlaca())){
                                                LocalDate fecha = LocalDate.parse(lista[7], DateTimeFormatter.ofPattern("yyyy/MM/dd"));

                                                int min = Integer.parseInt(lista[11]);
                                                long num = Long.parseLong(lista[8]);
                                                String[] añoMes = lista[9].split("-");
                                                int año = Integer.parseInt(añoMes[0]);
                                                int mes = Integer.parseInt(añoMes[1]);
                                                int cod = Integer.parseInt(lista[10]);
                                                //crea objeto Cliente con atributos respectivos para poder pasarselos a pantalla de acciones de admin
                                                Cliente cliente = new Cliente(lista[2], lista[3],lista[4], lista[5], lista[6], fecha, lista[1], lista[0],num,mes,año,cod,min);

                                                    try{
                                                        if(" ".equals(String.valueOf(lista[contador+1]))){
                                                            if(lista[contador+2]== ""){
                                                                cliente.agregarCarro(lista[contador], "", "");}
                                                            else{
                                                                cliente.agregarCarro(lista[contador], "", lista[contador+2]);
                                                            }}
                                                        else{
                                                            if(lista[contador+2]== ""){
                                                                cliente.agregarCarro(lista[contador], lista[contador+1], "");}
                                                            else{
                                                                cliente.agregarCarro(lista[contador], lista[contador+1], lista[contador+2]);}}
                                                    }catch(ArrayIndexOutOfBoundsException e ){
                                                        cliente.agregarCarro(lista[contador], "", "");
                                                    }
                                                 info = "Número de espacio: "+espacio.getNumeroEspacio() +" | Placa: "+espacio.getCarro().getPlaca()+ " | Costo: "+espacio.calcularMontoAPagar(espacio, parqueo, cliente)+" | Hora de Parqueo: "+espacio.getHoraInicioParqueo()+ " | Hora de Desaparqueo: "+espacio.getHoraFinParqueo()+"\n"+info;
                                                break;
                                            }
                                            contador = contador +3;
                                        }
                                        contenido = lectura.readLine();
                                    }catch(Exception e){
                                        e.printStackTrace();
                                        contenido = lectura.readLine();
                                    }
                                }            
                            } catch(IOException exception){
                                exception.printStackTrace();
                            }

                        }
                        }
                }catch(Exception e){}
                           
            }
            if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio)){
                        if((espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                            if(!espacio.getHoraFinParqueo().equals("null")){
                                String contenido;
                                try{
                                    FileReader leer = new FileReader("Cliente.txt");
                                    BufferedReader lectura = new BufferedReader(leer);
                                    contenido = lectura.readLine(); //lee una línea del archivo
                                    String [] lista;
                                    while(contenido != null){

                                        try{
                                            lista = contenido.split("\\,"); //divide la linea en cada atributo de administrador
                                            int contador = 12;
                                            while(contador < lista.length){
                                                if(lista[contador].equals(espacio.getCarro().getPlaca())){
                                                    LocalDate fecha = LocalDate.parse(lista[7], DateTimeFormatter.ofPattern("yyyy/MM/dd"));

                                                    int min = Integer.parseInt(lista[11]);
                                                    long num = Long.parseLong(lista[8]);
                                                    String[] añoMes = lista[9].split("-");
                                                    int año = Integer.parseInt(añoMes[0]);
                                                    int mes = Integer.parseInt(añoMes[1]);
                                                    int cod = Integer.parseInt(lista[10]);
                                                    //crea objeto Cliente con atributos respectivos para poder pasarselos a pantalla de acciones de admin
                                                    Cliente cliente = new Cliente(lista[2], lista[3],lista[4], lista[5], lista[6], fecha, lista[1], lista[0],num,mes,año,cod,min);

                                                        try{
                                                            if(" ".equals(String.valueOf(lista[contador+1]))){
                                                                if(lista[contador+2]== ""){
                                                                    cliente.agregarCarro(lista[contador], "", "");}
                                                                else{
                                                                    cliente.agregarCarro(lista[contador], "", lista[contador+2]);
                                                                }}
                                                            else{
                                                                if(lista[contador+2]== ""){
                                                                    cliente.agregarCarro(lista[contador], lista[contador+1], "");}
                                                                else{
                                                                    cliente.agregarCarro(lista[contador], lista[contador+1], lista[contador+2]);}}
                                                        }catch(ArrayIndexOutOfBoundsException e ){
                                                            cliente.agregarCarro(lista[contador], "", "");
                                                        }
                                                     info = "Número de espacio: "+espacio.getNumeroEspacio() +" | Placa: "+espacio.getCarro().getPlaca()+ " | Costo: "+espacio.calcularMontoAPagar(espacio, parqueo, cliente)+" | Hora de Parqueo: "+espacio.getHoraInicioParqueo()+ " | Hora de Desaparqueo: "+espacio.getHoraFinParqueo()+"\n"+info;
                                                    break;
                                                }
                                                contador = contador +3;
                                            }
                                            contenido = lectura.readLine();
                                        }catch(Exception e){
                                            e.printStackTrace();
                                            contenido = lectura.readLine();
                                        }
                                    }            
                                } catch(IOException exception){
                                    exception.printStackTrace();
                                }

                            }
                            }
                        }
                }catch(Exception e){}
            }        
        }
        return info;
    }
    
    //funcion para generar historial de multas

    /**
     *
     * @return String
     */
    public String historialMultas(){
        String info = "";
        if(fechaInicio==null && fechaFinal == null){ //si ambas son null, se tomaran las multas de todo el tiempo
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
            }
        }
         if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                try{
                    if((multa.getFechaMulta()).isBefore(fechaFinal)){ 
                        info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
                    }
                }catch(NullPointerException e){
                }
            }
            }
        if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                try{
                    if((multa.getFechaMulta()).isAfter(fechaInicio)){
                        info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
                        }
                }catch(NullPointerException e){}
            }            
        }
        if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                try{
                    if((multa.getFechaMulta()).isAfter(fechaInicio)){
                        if((multa.getFechaMulta()).isBefore(fechaFinal)){ 
                            info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
                        }
                    }
                }catch(NullPointerException e){}
            } 

        }
        return info;
    }
    //funcion para estadistica de un espacio en específico

    /**
     *
     * @param numEspacio
     * @return
     */
    public String estadisticaEspacioUnico(int numEspacio){
        String info = "";
        for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){ //se recorre todo el historial de parqueos
            if(fechaInicio==null && fechaFinal == null){ 
                if(espacio.getNumeroEspacio()== numEspacio){
                    if(getFechaFinal() != null){
                     LocalTime fechaInicio1;
                     LocalTime fechaFinal1;
                    if((fechaInicio.toLocalTime()).isBefore(parqueo.getAbre())){
                        fechaInicio1 = parqueo.getAbre();
                    } else{
                        fechaInicio1 = fechaInicio.toLocalTime();
                    }

                    if((fechaFinal.toLocalTime()).isBefore(parqueo.getCierra())){
                        fechaFinal1 = parqueo.getCierra();
                    } else{
                        fechaFinal1 = fechaFinal.toLocalTime();
                    }                    
                    Duration tiempoUtilizado = Duration.between(fechaInicio1, fechaFinal1);
                    long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas
                    
                    Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso

                    long horasTotalesParqueo = tiempoTotalParqueo.toHours();
                    
                    long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío
                    
                    double porcentajeUtilizados = ((double) horasUtilizadas * 100) / horasTotalesParqueo;
                    double porcentajeVacio = ((double) horasVacias * 100) / horasTotalesParqueo;
                    
                    return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;
                }}
            }
            if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
                try{
                    if((espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        if(espacio.getNumeroEspacio()== numEspacio){
                            if(getFechaFinal() != null){
                                LocalTime fechaInicio1;
                                LocalTime fechaFinal1;
                            if((fechaInicio.toLocalTime()).isBefore(parqueo.getAbre())){
                                fechaInicio1 = parqueo.getAbre();
                            } else{
                                fechaInicio1 = fechaInicio.toLocalTime();
                            }

                            if((fechaFinal.toLocalTime()).isBefore(parqueo.getCierra())){
                                fechaFinal1 = parqueo.getCierra();
                            } else{
                                fechaFinal1 = fechaFinal.toLocalTime();
                            }                    
                            Duration tiempoUtilizado = Duration.between(fechaInicio1, fechaFinal1);
                            long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas

                            Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso

                            long horasTotalesParqueo = tiempoTotalParqueo.toHours();

                            long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío

                            double porcentajeUtilizados = ((double) horasUtilizadas * 100) / horasTotalesParqueo;
                            double porcentajeVacio = ((double) horasVacias * 100) / horasTotalesParqueo;

                            return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;
                        }
                        }                          
                    }
                }catch(NullPointerException e){}
            }
            if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio)){
                        if(espacio.getNumeroEspacio()== numEspacio){
                            if(getFechaFinal() != null){
                                LocalTime fechaInicio1;
                                LocalTime fechaFinal1;
                               if((fechaInicio.toLocalTime()).isBefore(parqueo.getAbre())){
                                   fechaInicio1 = parqueo.getAbre();
                               } else{
                                   fechaInicio1 = fechaInicio.toLocalTime();
                               }

                               if((fechaFinal.toLocalTime()).isBefore(parqueo.getCierra())){
                                   fechaFinal1 = parqueo.getCierra();
                               } else{
                                   fechaFinal1 = fechaFinal.toLocalTime();
                               }                    
                               Duration tiempoUtilizado = Duration.between(fechaInicio1, fechaFinal1);
                               long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas

                               Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso

                               long horasTotalesParqueo = tiempoTotalParqueo.toHours();

                               long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío

                               double porcentajeUtilizados = ((double) horasUtilizadas * 100) / horasTotalesParqueo;
                               double porcentajeVacio = ((double) horasVacias * 100) / horasTotalesParqueo;

                               return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;
                           }
                        }
                    }
                }catch(NullPointerException e){}
                           
            }
            if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio) && (espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        if(espacio.getNumeroEspacio()== numEspacio){
                            // Calcular la duración entre ambas fechas y horas
                            Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                            long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas

                            Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                            long horasTotalesParqueo = tiempoTotalParqueo.toHours();

                            long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío

                            double porcentajeUtilizados = (horasUtilizadas*100)/horasTotalesParqueo;
                            double porcentajeVacio = (horasVacias*100)/horasTotalesParqueo;

                            return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;
                        }                        
                    }
                }catch(NullPointerException e){}
            }        
        }
        return info;    
    }
    
    //funcion para estadistica desde un espacio hasta otro

    /**
     *
     * @param espacioInicio
     * @param espacioFinal
     * @return
     */
    public String estadisticaVariosEspacios(int espacioInicio, int espacioFinal){
        long horasUtilizadas = 0;
        long horasTotalesParqueo =0;
        long horasVacias = 0;
        double porcentajeUtilizados = 0;
        double porcentajeVacio = 0;
        
        for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){ //se recorre todo el historial de parqueos
            if(fechaInicio==null && fechaFinal == null){ 
                if(espacio.getNumeroEspacio() >= espacioInicio && espacio.getNumeroEspacio() <= espacioFinal){
                    // Calcular la duración entre ambas fechas y horas
                    Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                    horasUtilizadas = horasUtilizadas + tiempoUtilizado.toHours(); //se realiza conversión a horas
                    
                    Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                    horasTotalesParqueo = horasTotalesParqueo + tiempoTotalParqueo.toHours();
                    
                    horasVacias = horasVacias + (horasTotalesParqueo - horasUtilizadas); //horas en que ese espacio estuvo vacío
                }
            }
            if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
                try{
                    if((espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        if(espacio.getNumeroEspacio() >= espacioInicio && espacio.getNumeroEspacio() <= espacioFinal){
                            // Calcular la duración entre ambas fechas y horas
                            Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                            horasUtilizadas = horasUtilizadas + tiempoUtilizado.toHours(); //se realiza conversión a horas

                            Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                            horasTotalesParqueo = horasTotalesParqueo + tiempoTotalParqueo.toHours();

                            horasVacias = horasVacias + (horasTotalesParqueo - horasUtilizadas); //horas en que ese espacio estuvo vacío

                        }                          
                    }
                }catch(NullPointerException e){}
            }
            if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio)){
                        if(espacio.getNumeroEspacio() >= espacioInicio && espacio.getNumeroEspacio() <= espacioFinal){
                            // Calcular la duración entre ambas fechas y horas
                            Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                            horasUtilizadas = horasUtilizadas + tiempoUtilizado.toHours(); //se realiza conversión a horas

                            Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                            horasTotalesParqueo = horasTotalesParqueo + tiempoTotalParqueo.toHours();

                            horasVacias = horasVacias + (horasTotalesParqueo - horasUtilizadas); //horas en que ese espacio estuvo vacío

                        }
                    }
                }catch(NullPointerException e){}
                           
            }
            if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio) && (espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        if(espacio.getNumeroEspacio() >= espacioInicio && espacio.getNumeroEspacio() <= espacioFinal){
                            // Calcular la duración entre ambas fechas y horas
                            Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                            horasUtilizadas = horasUtilizadas + tiempoUtilizado.toHours(); //se realiza conversión a horas

                            Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                            horasTotalesParqueo = horasTotalesParqueo + tiempoTotalParqueo.toHours();

                            horasVacias = horasVacias + (horasTotalesParqueo - horasUtilizadas); //horas en que ese espacio estuvo vacío

                        }                        
                    }
                }catch(NullPointerException e){}
            }        
        }
        porcentajeUtilizados = (horasUtilizadas*100)/horasTotalesParqueo;
        porcentajeVacio = (horasVacias*100)/horasTotalesParqueo;
        return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;      
    }
    
    //funcion para estadistica de todos los espacios

    /**
     *
     * @return
     */
    public String estadisticaTodos(){
        String info = "";
        for(EspacioDeParqueo espacio : parqueo.getHistorialParqueo().getListaParqueo()){ //se recorre todo el historial de parqueos
            if(fechaInicio==null && fechaFinal == null){ 
                // Calcular la duración entre ambas fechas y horas
                Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas
                    
                Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                long horasTotalesParqueo = tiempoTotalParqueo.toHours();
                    
                long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío
                    
                double porcentajeUtilizados = (horasUtilizadas*100)/horasTotalesParqueo;
                double porcentajeVacio = (horasVacias*100)/horasTotalesParqueo;
                    
                return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;        
            }
            if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
                try{
                    if((espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        // Calcular la duración entre ambas fechas y horas
                        Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                        long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas

                        Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                        long horasTotalesParqueo = tiempoTotalParqueo.toHours();

                        long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío

                        double porcentajeUtilizados = (horasUtilizadas*100)/horasTotalesParqueo;
                        double porcentajeVacio = (horasVacias*100)/horasTotalesParqueo;

                        return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;
                                                
                    }
                }catch(NullPointerException e){}
            }
            if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio)){
                        // Calcular la duración entre ambas fechas y horas
                        Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                        long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas

                        Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                        long horasTotalesParqueo = tiempoTotalParqueo.toHours();

                        long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío

                        double porcentajeUtilizados = (horasUtilizadas*100)/horasTotalesParqueo;
                        double porcentajeVacio = (horasVacias*100)/horasTotalesParqueo;

                        return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;
                        
                    }
                }catch(NullPointerException e){}
                           
            }
            if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
                try{
                    if((espacio.getHoraFinParqueo()).isAfter(fechaInicio) && (espacio.getHoraFinParqueo()).isBefore(fechaFinal)){ 
                        // Calcular la duración entre ambas fechas y horas
                        Duration tiempoUtilizado = Duration.between(fechaInicio, fechaFinal);
                        long horasUtilizadas = tiempoUtilizado.toHours(); //se realiza conversión a horas

                        Duration tiempoTotalParqueo = Duration.between(parqueo.getAbre(), parqueo.getCierra()); //calcular tiempo total en que se mantiene el estacionamiento en uso
                        long horasTotalesParqueo = tiempoTotalParqueo.toHours();

                        long horasVacias = horasTotalesParqueo - horasUtilizadas; //horas en que ese espacio estuvo vacío

                        double porcentajeUtilizados = (horasUtilizadas*100)/horasTotalesParqueo;
                        double porcentajeVacio = (horasVacias*100)/horasTotalesParqueo;

                        return "Horas utilizadas en total: " + horasUtilizadas + " /En porcentaje: "+porcentajeUtilizados+" | Horas en que el espacio estuvo vacío: "+ horasVacias +" /En porcentaje: "+porcentajeVacio;                  
                    }
                }catch(NullPointerException e){}
            }        
        }
        return info;  
    }
    
    //revisar de cuales espacios se quiere la estadística

    /**
     *
     * @return
     */
    public String revisarEspacioEstadistica(){
        if(index2 == 0){
            String respuesta = JOptionPane.showInputDialog(null, "¿De cuál espacio desea la estadística?", "Pregunta", JOptionPane.QUESTION_MESSAGE);
            // Comprobar si el usuario introdujo una respuesta
            if (respuesta != null && !respuesta.isEmpty()) {
                try{
                    int numEspacio = Integer.parseInt(respuesta);
                    return estadisticaEspacioUnico(numEspacio);
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Digite un número de espacio correcto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ingresó ningún número de espacio.", "Error", JOptionPane.ERROR_MESSAGE);
            }           
        }else if(index2 == 1){
            //crear dos textFields para el panel emergente
            JTextField campoTexto1 = new JTextField(10); 
            JTextField campoTexto2 = new JTextField(10); 

            // Crear el JPanel y añadir los campos de texto
            JPanel panel = new JPanel();
            panel.add(new JLabel("Desde el espacio número : "));
            panel.add(campoTexto1);
            panel.add(Box.createHorizontalStrut(10)); 
            panel.add(new JLabel("Hasta el espacio número : "));
            panel.add(campoTexto2);

            int resultado = JOptionPane.showConfirmDialog(null, panel, "Indique desde cuál y hasta cuál espacio desea la estadística", JOptionPane.OK_CANCEL_OPTION);

            if (resultado == JOptionPane.OK_OPTION) {
               try{
                    int espacioInicio = Integer.parseInt(campoTexto1.getText());
                    int espacioFinal = Integer.parseInt(campoTexto2.getText());
                    if(espacioFinal < espacioInicio){
                        JOptionPane.showMessageDialog(null, "Espacio de inicio debe ser menor que el espacio final", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        return estadisticaVariosEspacios(espacioInicio, espacioFinal);
                    }
               } catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Digite un número de espacios correctos", "Error", JOptionPane.ERROR_MESSAGE);
               }
            }       
        } else {
            return estadisticaTodos();
        } 
        return "";
    }
    
    //generar el PDF con toda la información

    /**
     *
     * @param archivoPDF
     */
    public void generarReporte(File archivoPDF) {
        try {
            // Crear el PDF
            PdfWriter writer = new PdfWriter(archivoPDF.getAbsolutePath());
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Agregar contenido al PDF
            document.add(new Paragraph("Reporte de Administrador"));

            // Agregar ingresos de dinero
            int numero = ingresosDinero();
            document.add(new Paragraph("\nIngresos de dinero por estacionamiento: " +String.valueOf(numero)));

            // Agregar ingresos de dinero por multas
            int numero2 = ingresosMultas();
            document.add(new Paragraph("\nIngresos de dinero por multas: "+String.valueOf(numero2)));

            // Agregar lista de espacios de parqueos según su estado actual
            String info = listaEspaciosActuales();
            document.add(new Paragraph("\nLista de espacios de parqueos según su estado actual:"));
            document.add(new Paragraph(info));      
            
            // Agregar historial en un periodo de tiempo de espacios utilizadsos
            String info2 = historialEspaciosUsados();
            document.add(new Paragraph("\nHistorial de espacios utilizados: "));
            document.add(new Paragraph(info2));  
            
            // Agregar historial en un periodo de tiempo de multas generadas en el parqueo
            String info3 = historialMultas();
            document.add(new Paragraph("\nHistorial de multas: "));
            document.add(new Paragraph(info3));              
            
            // Agregar estadísticas detalladas
            String info4 = revisarEspacioEstadistica();
            document.add(new Paragraph("\nEstadística detallada de espacio(s): "));
            document.add(new Paragraph(info4));     
            
            
            // Cerrar el documento
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    6.agarrar de HistorialParqueo
    7. agarrar de HistorialParqueo
    */
    // <editor-fold defaultstate="collapsed" desc="Setters"> 

    /**
     *
     * @param parqueo
     */
    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }

    /**
     *
     * @param fechaInicio
     */
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @param fechaFinal
     */
    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     *
     * @param index2
     */
    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    // </editor-fold>
}
