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
import javax.swing.JOptionPane;

public class ReporteAdmin {
    
    private Parqueo parqueo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private int index;
    private int index2;
    private int index3;
    
    public ReporteAdmin(Parqueo parqueo, LocalDateTime fechaInicio, LocalDateTime fechaFinal, int index, int index2, int index3){
        setParqueo(parqueo);
        setFechaInicio(fechaInicio);
        setFechaFinal(fechaFinal);
        setIndex(index);
        setIndex2(index2);
        setIndex3(index3);
    }
    //getters
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }
    //funcion para ingresos de dinero de estacionamiento en un periodo de tiempo
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
                                        info = info +"Placa: "+ espacio.getCarro().getPlaca() + "   Costo: "+ espacio.calcularMontoAPagar(espacio, parqueo, cliente)+ " Tiempos reservados: " + espacio.getHoraInicioParqueo() + "      "+ fechaHoraActual+ "\n";
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
                                        info = info +"Placa: "+ espacio.getCarro().getPlaca() + "   Costo: "+ espacio.calcularMontoAPagar(espacio, parqueo, cliente)+ " Tiempos reservados: " + espacio.getHoraInicioParqueo() + "      "+ fechaHoraActual+ "\n";
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
    
    
    
    //generar el PDF con toda la información
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
            document.add(new Paragraph("\nIngresos de dinero por estacionamiento:"));
            document.add(new Paragraph(String.valueOf(numero)));

            // Agregar ingresos de dinero por multas
            int numero2 = ingresosMultas();
            document.add(new Paragraph("\nIngresos de dinero por multas:"));
            document.add(new Paragraph(String.valueOf(numero2)));

            // Agregar lista de espacios de parqueos según su estado actual
            String info = listaEspaciosActuales();
            document.add(new Paragraph("\nLista de espacios de parqueos según su estado actual:"));
            document.add(new Paragraph(info));      
            
            
            
            // Cerrar el documento
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    1.agarrar ingresos de HistorialParqueo
    2.agarrar ingresos de multas en HistorialMultas
    3.agarrarlo de clase EspaciosParqueo
    4.agarrar solo espacios cuyo atributo de disponible diga false en de HistorialParqueo
    5.agarrar de HistorialMultas
    6.agarrar de HistorialParqueo
    7. agarrar de HistorialParqueo
    */
    // <editor-fold defaultstate="collapsed" desc="Setters"> 
    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    public void setIndex3(int index3) {
        this.index3 = index3;
    }
    // </editor-fold>
}
