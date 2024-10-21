package com.mycompany.proyectoparqueos;

import java.io.File;
import javax.swing.JOptionPane;
import java.time.*;

/**
 *
 * @author ximen
 */
public class MenuReporteInspector extends javax.swing.JFrame {

    private Inspector inspector;
    private Parqueo parqueo;
    
    /**
     *
     * @param inspector
     * @param parqueo
     */
    public MenuReporteInspector(Inspector inspector, Parqueo parqueo) {
        initComponents();
        setInspector(inspector);
        setParqueo(parqueo);  

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        ComboBox1 = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        inpFechaInicio = new javax.swing.JTextField();
        lblNombre4 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        inpFechaFinal = new javax.swing.JTextField();
        btnAceptar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 450));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REPORTE DE INSPECTOR");

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar todos los espacios.", "Mostrar solo los espacios ocupados.", "Mostrar solo los espacios vacíos." }));
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Lista de espacios de parqueos según su estado actual:");

        lblNombre3.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblNombre3.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre3.setText("Periodo de tiempo a considerar para realizar el reporte:");

        lblNombre4.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblNombre4.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre4.setText("Desde:");

        lblNombre5.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblNombre5.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre5.setText("Hasta:");

        btnAceptar3.setBackground(new java.awt.Color(204, 204, 204));
        btnAceptar3.setText("Aceptar");
        btnAceptar3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(lblNombre5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNombre))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAceptar3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(201, 201, 201))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(18, 18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre4)
                    .addComponent(lblNombre5)
                    .addComponent(inpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnAceptar3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //setters

    /**
     *
     * @param inspector
     */
    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    /**
     *
     * @param parqueo
     */
    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //crear ventana de menu inicial
        MenuInspector pantalla = new MenuInspector(inspector, parqueo);
        pantalla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed
    // <editor-fold defaultstate="collapsed" desc="ComboBox"> 
    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox1ActionPerformed
    // </editor-fold>
    private void btnAceptar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar3ActionPerformed
        LocalDateTime fechaInicio = null;
        LocalDateTime fechaFinal = null;
        try{
            if(!"".equals(inpFechaInicio.getText())){
                try{
                    fechaInicio = LocalDateTime.parse(inpFechaInicio.getText());
                }catch(Exception e){
                    throw new ValidacionesExceptions("Ha ingresado la fecha de inicio en formato incorrecto");
                }
            }else
                fechaInicio = null;
            if(!"".equals(inpFechaFinal.getText())){
                try{
                    fechaFinal = LocalDateTime.parse(inpFechaFinal.getText());
                }catch(Exception e){
                    throw new ValidacionesExceptions("Ha ingresado la fecha de fin en formato incorrecto");
                }
            }
            else
            fechaFinal = null;
        }catch(ValidacionesExceptions e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        int index = ComboBox1.getSelectedIndex();

        ReporteInspector reporte = new ReporteInspector(parqueo, fechaInicio, fechaFinal, index, inspector);

        try {
            // Ruta donde se generará el PDF
            File archivoPDF = new File("reporteInspector.pdf");
            // Llamar al método que genera el reporte para el inspector
            reporte.generarReporte(archivoPDF);
            // Mostrar un mensaje de éxito cuando se haya generado el reporte
            JOptionPane.showMessageDialog(null, "Reporte generado exitosamente en: " + archivoPDF.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            Correo correo = new Correo("juanpacamal08@gmail.com", "adqs eueu mrbs vngz", "smtp.gmail.com");
            String rutaArchivoAdjunto = "reporteInspector.pdf";
            File archivoAdjunto = new File(rutaArchivoAdjunto); // Convertir la ruta en un archivo

            correo.enviarCorreoConAdjunto(
            "juanpacamal08@gmail.com",  // Dirección de correo del destinatario correcta
            "REPORTE CLIENTE",          // Asunto del correo
            "Este es el reporte del cliente del servicio de parqueo utilizado.", // Cuerpo del correo
            archivoAdjunto);              // El archivo PDF adjunto
        } catch (Exception e) {
            // Mostrar un mensaje de error si ocurre un problema al generar el reporte
            JOptionPane.showMessageDialog(null, "Error al generar el reporte: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAceptar3ActionPerformed

    /**
     *
     * @param args
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuReporteInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuReporteInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuReporteInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuReporteInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuReporteInspector(inspector, parqueo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JButton btnAceptar3;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField inpFechaFinal;
    private javax.swing.JTextField inpFechaInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    // End of variables declaration//GEN-END:variables
}
