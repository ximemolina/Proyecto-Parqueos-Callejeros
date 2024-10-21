package com.mycompany.proyectoparqueos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ximen
 */
public class ReporteCliente {
    
    private Cliente cliente;
    private Parqueo parqueo;
    
    /**
     *
     * @param cliente
     * @param parqueo
     */
    public ReporteCliente(Cliente cliente, Parqueo parqueo){
        this.cliente = cliente;
        this.parqueo = parqueo;
    }
    
    /**
     *
     * @return
     */
    public List<EspacioDeParqueo> obtenerEspaciosDisponibles() {
        List<EspacioDeParqueo> espaciosDisponibles = new ArrayList<>();
        for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
            if (espacio.getDisponible()) {
                espaciosDisponibles.add(espacio);
            }
        }
        return espaciosDisponibles;
    }

        // Función para leer el archivo y devolver una lista ordenada de registros

    /**
     *
     * @param archivoHistorial
     * @param cliente
     * @param precioPorHora
     * @return
     */
    public List<String> obtenerHistorialDescendentePorFecha(File archivoHistorial, Cliente cliente, int precioPorHora) {
        List<String> historial = new ArrayList<>();

        // Obtener todas las placas del cliente
        List<Carro> carrosDelCliente = cliente.getCarros();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoHistorial))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                // Verificar si la placa en el archivo corresponde a algún carro del cliente
                for (Carro carro : carrosDelCliente) {
                    if (datos.length > 5 && datos[2].equals(carro.getPlaca())) {
                        // Extraer fechas de inicio y fin
                        LocalDateTime horaInicio = !datos[5].equals("null") ? LocalDateTime.parse(datos[5]) : null;
                        LocalDateTime horaFin = !datos[6].equals("null") ? LocalDateTime.parse(datos[6]) : null;

                        // Calcular el tiempo de parqueo en minutos y el costo
                        long minutosParqueo = horaInicio != null && horaFin != null ? Duration.between(horaInicio, horaFin).toMinutes() : 0;
                        double costoParqueo = (minutosParqueo / 60.0) * precioPorHora;

                        // Formatear la salida
                        String registro = String.format(
                            "Espacio: %s, Placa: %s, Marca: %s, Modelo: %s, Inicio: %s, Fin: %s, Tiempo: %d minutos, Costo: %.2f",
                            datos[0], datos[2], datos[3], datos[4], 
                            horaInicio != null ? horaInicio : "Sin inicio",
                            horaFin != null ? horaFin : "Sin fin", 
                            minutosParqueo, costoParqueo);

                        historial.add(registro);
                        break; // Salir del loop si ya encontró el carro
                    }
                }
            }

            // Ordenar la lista en orden descendente por fecha (horaFin)
            Collections.sort(historial, new Comparator<String>() {
            @Override
            public int compare(String r1, String r2) {
                // Extraer solo la parte de la fecha en el formato adecuado
                String fecha1Str = r1.split(",")[5].trim().replace("Fin: ", "");
                String fecha2Str = r2.split(",")[5].trim().replace("Fin: ", "");

                LocalDateTime fecha1 = fecha1Str.equals("Sin fin") ? LocalDateTime.MIN : LocalDateTime.parse(fecha1Str);
                LocalDateTime fecha2 = fecha2Str.equals("Sin fin") ? LocalDateTime.MIN : LocalDateTime.parse(fecha2Str);

                return fecha2.compareTo(fecha1);  // Orden descendente
            }
        });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return historial;
    }

    /**
     *
     * @param archivoMultas
     * @param cliente
     * @return
     */
    public List<String> obtenerMultasDescendentesPorFecha(File archivoMultas, Cliente cliente) {
        List<String> historialMultas = new ArrayList<>();

        // Obtener todas las placas del cliente
        List<Carro> carrosDelCliente = cliente.getCarros();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoMultas))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                // Verificar que la multa pertenece a algún carro del cliente (por la placa del carro)
                for (Carro carro : carrosDelCliente) {
                    if (datos.length >= 6 && datos[0].equals(carro.getPlaca())) {
                        // Formatear la salida de la multa
                        String placa = datos[0];
                        String marca = datos[1];
                        String modelo = datos[2];
                        int costoMulta = Integer.parseInt(datos[3]);
                        LocalDateTime fechaMulta = !datos[4].equals("null") ? LocalDateTime.parse(datos[4]) : null;
                        String identificadorMulta = datos[5];

                        String registroMulta = String.format(
                            "Placa: %s, Marca: %s, Modelo: %s, Fecha de la multa: %s, Costo: %d",
                            placa, marca, modelo,
                            fechaMulta != null ? fechaMulta : "Fecha no registrada",
                            costoMulta
                        );

                        historialMultas.add(registroMulta);
                        break; // Salir del loop si ya encontró la multa
                    }
                }
            }

            // Ordenar la lista de multas en orden descendente por fecha (fechaMulta)
            Collections.sort(historialMultas, new Comparator<String>() {
                @Override
                public int compare(String r1, String r2) {
                    String fecha1Str = r1.split(",")[3];  // Fecha está en la posición 3 del String formateado
                    String fecha2Str = r2.split(",")[3];

                    LocalDateTime fecha1 = fecha1Str.equals("Fecha no registrada") ? LocalDateTime.MIN : LocalDateTime.parse(fecha1Str);
                    LocalDateTime fecha2 = fecha2Str.equals("Fecha no registrada") ? LocalDateTime.MIN : LocalDateTime.parse(fecha2Str);

                    return fecha2.compareTo(fecha1);  // Orden descendente
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return historialMultas;
    }
    
    /**
     *
     * @param archivoHistorial
     * @param archivoMultas
     * @param precioPorHora
     * @param archivoPDF
     */
    public void generarReporteCliente(File archivoHistorial, File archivoMultas, int precioPorHora, File archivoPDF) {
        try {
            // Crear el PDF
            PdfWriter writer = new PdfWriter(archivoPDF.getAbsolutePath());
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Agregar contenido al PDF
            document.add(new Paragraph("Reporte de Cliente"));

            // Agregar los espacios disponibles
            List<EspacioDeParqueo> espaciosDisponibles = obtenerEspaciosDisponibles();
            document.add(new Paragraph("\nEspacios disponibles:"));
            for (EspacioDeParqueo espacio : espaciosDisponibles) {
                document.add(new Paragraph("Espacio: " + espacio.getNumeroEspacio()));
            }

            // Agregar historial de parqueo
            List<String> historialParqueo = obtenerHistorialDescendentePorFecha(archivoHistorial, cliente, precioPorHora);
            document.add(new Paragraph("\nHistorial de parqueo:"));
            for (String registro : historialParqueo) {
                document.add(new Paragraph(registro));
            }

            // Agregar historial de multas
            List<String> historialMultas = obtenerMultasDescendentesPorFecha(archivoMultas, cliente);
            document.add(new Paragraph("\nHistorial de multas:"));
            for (String multa : historialMultas) {
                document.add(new Paragraph(multa));
            }

            // Cerrar el documento
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
