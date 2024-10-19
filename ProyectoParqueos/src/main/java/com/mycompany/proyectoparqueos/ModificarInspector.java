package com.mycompany.proyectoparqueos;

import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class ModificarInspector extends javax.swing.JFrame {

    private Parqueo parqueo;
    private Inspector inspector;
    
    public ModificarInspector(Inspector inspector, Parqueo parqueo) {
        initComponents();
        setInspector(inspector);
        setParqueo(parqueo);
        setInformacion();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inpNombre = new javax.swing.JTextField();
        inpApellido = new javax.swing.JTextField();
        inpTelefono = new javax.swing.JTextField();
        inpCorreo = new javax.swing.JTextField();
        inpDireccion = new javax.swing.JTextField();
        inpIdentificacion = new javax.swing.JTextField();
        inpAño = new javax.swing.JTextField();
        inpMes = new javax.swing.JTextField();
        inpDia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblIdentificacion1 = new javax.swing.JLabel();
        inpCodigoTerminal = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnModificarPin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modificar Información de Inspector");

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre :");

        lblApellidos.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidos.setText("Apellidos :");

        lblTelefono.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Teléfono : ");

        lblCorreo.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo electrónico : ");

        lblDireccion.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccion.setText("Dirección fisica : ");

        lblIdentificacion.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        lblIdentificacion.setText("Identificación de usuario : ");

        lblFechaIngreso.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblFechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaIngreso.setText("Fecha de ingreso como trabajador:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Variable", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Formato: YYYY - MMM - DD");

        inpNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNombreActionPerformed(evt);
            }
        });

        inpApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpApellidoActionPerformed(evt);
            }
        });

        inpTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpTelefonoActionPerformed(evt);
            }
        });

        inpCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpCorreoActionPerformed(evt);
            }
        });

        inpDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpDireccionActionPerformed(evt);
            }
        });

        inpIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpIdentificacionActionPerformed(evt);
            }
        });

        inpAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpAñoActionPerformed(evt);
            }
        });

        inpMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpMesActionPerformed(evt);
            }
        });

        inpDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpDiaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("-");

        jLabel12.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("-");

        lblIdentificacion1.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblIdentificacion1.setForeground(new java.awt.Color(255, 255, 255));
        lblIdentificacion1.setText("Código de terminal de inspección:");

        inpCodigoTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpCodigoTerminalActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(204, 204, 204));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnModificarPin.setBackground(new java.awt.Color(204, 204, 204));
        btnModificarPin.setText("Modificar Pin");
        btnModificarPin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblApellidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inpApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inpNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inpTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inpCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inpDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblIdentificacion)
                                            .addComponent(lblFechaIngreso)
                                            .addComponent(jLabel10)
                                            .addComponent(lblIdentificacion1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(inpAño, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel11)
                                        .addGap(7, 7, 7)
                                        .addComponent(inpMes, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inpDia, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnModificarPin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(inpIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(inpCodigoTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(inpApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(inpTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(inpCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(inpDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentificacion)
                    .addComponent(inpIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaIngreso)
                    .addComponent(inpAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inpCodigoTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdentificacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarPin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuInspector pantalla = new MenuInspector (inspector, parqueo);
        pantalla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Inputs"> 
    private void inpNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNombreActionPerformed

    private void inpApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpApellidoActionPerformed

    private void inpTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpTelefonoActionPerformed

    private void inpCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpCorreoActionPerformed

    private void inpDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpDireccionActionPerformed

    private void inpIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpIdentificacionActionPerformed

    private void inpAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpAñoActionPerformed

    private void inpMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpMesActionPerformed

    private void inpDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpDiaActionPerformed

    private void inpCodigoTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpCodigoTerminalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpCodigoTerminalActionPerformed
// </editor-fold > 
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try{
            String mes = inpMes.getText();
            String año = inpAño.getText();
            String dia = inpDia.getText();
            String fechaActualizada = año + "-"+mes+"-"+dia;
            LocalDate fecha = LocalDate.parse(fechaActualizada);
            Inspector inspector2 = new Inspector(inpNombre.getText(), inpApellido.getText(), inpTelefono.getText(), inpCorreo.getText(), inpDireccion.getText(),fecha ,inspector.getPin(), inpIdentificacion.getText(), inpCodigoTerminal.getText());
            String infoACambiar = inspector2.toString();

            inspector2.modificarDatosInspector(infoACambiar);
            MenuInspector pantalla = new MenuInspector(inspector2,parqueo);
            pantalla.setVisible(true);
            this.setVisible(false);
        }
        catch(ValidacionesExceptions e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnModificarPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPinActionPerformed

        String caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            int indiceAleatorio = random.nextInt(caracteresPermitidos.length());
            char caracterAleatorio = caracteresPermitidos.charAt(indiceAleatorio);
            sb.append(caracterAleatorio);
        }

        String pin = sb.toString();
        //******************************************aqui faltaría agregar mandar Pin por correo***************************************///
        System.out.println(pin);
        VerificarPinInspector2 pantalla = new VerificarPinInspector2(inspector,parqueo,pin);
        pantalla.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnModificarPinActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(ModificarInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarInspector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarInspector(inspector, parqueo).setVisible(true);
            }
        });
    }
    
    //muestra atributos en la pantalla
    public void setInformacion(){
        try{
            inpApellido.setText(inspector.getApellido());
            inpCorreo.setText(inspector.getCorreo());
            inpDireccion.setText(inspector.getDireccionFisica());
            LocalDate fecha = inspector.getFechaIngreso();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            // Convertir LocalDate a String
            String fechaEnTexto = fecha.format(formato);
            String[]fechaEnTexto2 =fechaEnTexto.split("/");
            inpAño.setText(fechaEnTexto2[0]);
            inpMes.setText(fechaEnTexto2[1]);
            inpDia.setText(fechaEnTexto2[2]);
            inpIdentificacion.setText(inspector.getIdentificacionUsuario());
            inpNombre.setText(inspector.getNombre());
            inpTelefono.setText(String.valueOf(inspector.getTelefono()));
            inpCodigoTerminal.setText(inspector.getCodigoTerminal());
        } catch(ValidacionesExceptions e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }    
    //setters
    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnModificarPin;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField inpApellido;
    private javax.swing.JTextField inpAño;
    private javax.swing.JTextField inpCodigoTerminal;
    private javax.swing.JTextField inpCorreo;
    private javax.swing.JTextField inpDia;
    private javax.swing.JTextField inpDireccion;
    private javax.swing.JTextField inpIdentificacion;
    private javax.swing.JTextField inpMes;
    private javax.swing.JTextField inpNombre;
    private javax.swing.JTextField inpTelefono;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblIdentificacion1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}
