package com.mycompany.proyectoparqueos;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReporteInspector{
    //atributos
    private Inspector inspector;
    private Parqueo parqueo;
    private int index;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    //constructor
    public ReporteInspector(Parqueo parqueo, LocalDateTime fechaInicio, LocalDateTime fechaFinal, int index, Inspector inspector){

        setParqueo(parqueo);
        setInspector(inspector);
        setIndex(index);
        setFechaInicio(fechaInicio);
        setFechaFinal(fechaFinal);

    }
    
    //setter
    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    //funcion para obtener la información sobre el estado actual de los espacios del parqueo
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
                                        info = info +"Placa: "+ espacio.getCarro().getPlaca() + "   Costo: "+ espacio.calcularMontoAPagar(espacio, parqueo, cliente)+ " Tiempos reservados: " + espacio.getHoraInicioParqueo() + "<--->"+ fechaHoraActual+ "\n";
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
                    info = info +"Numero de espacio: "+espacio.getNumeroEspacio()+"\n";
                }
            }                
        }else if (index == 1){ //se deben mostrar solo espacios ocupados
            info = "Espacios Ocupados:";
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
                                        info = info +"Placa: "+ espacio.getCarro().getPlaca() + "   Costo: "+ espacio.calcularMontoAPagar(espacio, parqueo, cliente)+ " Tiempos reservados: " + espacio.getHoraInicioParqueo() + "<--->"+ fechaHoraActual+ "\n";
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
    
    public String multasEnTiempo(){
        String info = "";
        int contador = 0;
        int contador2;
        if(fechaInicio==null && fechaFinal == null){ //si ambas son null, se tomaran las multas de todo el tiempo
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                contador2 = 0;
                for(String id : parqueo.getHistorialMultas().getListaInspectores()){
                    if(contador2 == contador){
                        System.out.println(id +  "||||"+inspector.getIdentificacionUsuario());
                        if(id.equals(inspector.getIdentificacionUsuario()+multa.getCarro().getPlaca())){
                            info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
                        }
                        break;
                    }
                    contador2 ++;
                }
            }
        }
         if(fechaInicio == null && fechaFinal !=null){ //si inicio está en null, significa que solo se toma en cuenta fechaFinal
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                contador2 = contador;
                try{
                    if((multa.getFechaMulta()).isBefore(fechaFinal)){ 
                        contador2 = 0;
                        for(String id : parqueo.getHistorialMultas().getListaInspectores()){
                            if(contador2 == contador){
                                System.out.println(id +  "||||"+inspector.getIdentificacionUsuario());
                                if(id.equals(inspector.getIdentificacionUsuario()+multa.getCarro().getPlaca())){
                                    info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
                                }
                                break;
                            }
                            contador2 ++;
                        }
                    }
                }catch(NullPointerException e){
                }
            }
            }
        if(fechaInicio != null && fechaFinal ==null){ //si final está en null, significa que solo se toma en cuenta fechaInicio
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                contador2 = contador;
                try{
                    if((multa.getFechaMulta()).isAfter(fechaInicio)){
                        contador2 = 0;
                        for(String id : parqueo.getHistorialMultas().getListaInspectores()){
                            if(contador2 == contador){
                                System.out.println(id +  "||||"+inspector.getIdentificacionUsuario());
                                if(id.equals(inspector.getIdentificacionUsuario()+multa.getCarro().getPlaca())){
                                    info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
                                }
                                break;
                            }
                            contador2 ++;
                        }
                        }
                    }catch(NullPointerException e){
                }
            }            
        }
        if(fechaInicio != null && fechaFinal !=null){ //si ambas son distintas, se tiene que limitar dos fechas
            for(Multa multa : parqueo.getHistorialMultas().getListaMultas()){
                contador2 = contador;
                try{
                    if((multa.getFechaMulta()).isAfter(fechaInicio)){
                        if((multa.getFechaMulta()).isBefore(fechaFinal)){ 
                            contador2 = 0;
                            for(String id : parqueo.getHistorialMultas().getListaInspectores()){
                                if(contador2 == contador){
                                    System.out.println(id +  "||||"+inspector.getIdentificacionUsuario());
                                    if(id.equals(inspector.getIdentificacionUsuario()+multa.getCarro().getPlaca())){
                                        info = "Placa: "+multa.getCarro().getPlaca()+" | Costo de multa: "+ multa.getCostoMulta()+" | Fecha de multa: "+multa.getFechaMulta()+" | Descripción de multa: "+multa.getDescripcion()+"\n"+"\n"+info;
                                    }
                                    break;
                                }
                                contador2 ++;
                            }
                        }
                    }
                }catch(NullPointerException e){
                }
            } 

        }
        return info;
    }
    
    //generar el reporte de inspector
    public void generarReporte(File archivoPDF){
       try {

            // Crear el PDF
            PdfWriter writer = new PdfWriter(archivoPDF.getAbsolutePath());
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Agregar contenido al PDF
            document.add(new Paragraph("Reporte de Inspector"));

            // Agregar lista de espacios de parqueos según su estado actual
            String info = listaEspaciosActuales();
            document.add(new Paragraph("\nLista de espacios de parqueos según su estado actual:"));
            document.add(new Paragraph(info));      
            
            //agregar lista de multas hechas por ese inspector
            String info2 = multasEnTiempo();
            document.add(new Paragraph("\nLista de multas realizadas por este inspector :"));
            document.add(new Paragraph(info2));     
            
            // Cerrar el documento
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }    
       
    }
}
