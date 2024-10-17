/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoparqueos;

import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class MenuPagar extends javax.swing.JFrame {
    Parqueo parqueo;
    Cliente cliente;
    EspacioDeParqueo espacioSeleccionado;
    /**
     * Creates new form MenuPagar
     */
    public MenuPagar(Cliente cliente, Parqueo parqueo) {
        initComponents();
        setParqueo(parqueo);
        setCliente(cliente);
        llenarComboBoxEspaciosOcupados();
    }
    
    public void setParqueo(Parqueo parqueo){
        this.parqueo = parqueo;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    private void llenarComboBoxEspaciosOcupados() {
        // Limpiar el ComboBox antes de llenarlo
        comboBoxEspaciosOcupados.removeAllItems();

        // Obtener la lista de espacios del parqueo
        ArrayList<EspacioDeParqueo> espaciosParqueo = parqueo.getEspaciosParqueo();

        // Obtener la lista de carros del cliente
        ArrayList<Carro> carrosDelCliente = cliente.getCarros();

        // Recorrer los espacios de parqueo y verificar si están ocupados por un carro del cliente
        for (EspacioDeParqueo espacio : espaciosParqueo) {
            Carro carroEnEspacio = espacio.getCarro();

            // Si el espacio está ocupado y el carro pertenece al cliente
            if (carroEnEspacio != null && carrosDelCliente.contains(carroEnEspacio)) {
                // Agregar el número del espacio al ComboBox
                comboBoxEspaciosOcupados.addItem(String.valueOf(espacio.getNumeroEspacio()));
            }
        }

        // Si no hay espacios ocupados por el cliente, agregar un mensaje
        if (comboBoxEspaciosOcupados.getItemCount() == 0) {
            comboBoxEspaciosOcupados.addItem("No hay espacios ocupados");
        } else {
            // Selecciona automáticamente el primer elemento del ComboBox si hay espacios ocupados
            comboBoxEspaciosOcupados.setSelectedIndex(0);
            String espacioSeleccionadoStr = (String) comboBoxEspaciosOcupados.getSelectedItem();

            // Asegúrate de que el espacio seleccionado no sea "No hay espacios ocupados"
            if (!espacioSeleccionadoStr.equals("No hay espacios ocupados")) {
                int numeroEspacioSeleccionado = Integer.parseInt(espacioSeleccionadoStr);

                // Buscar el espacio correspondiente y asignarlo a espacioSeleccionado
                for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
                    if (espacio.getNumeroEspacio() == numeroEspacioSeleccionado) {
                        espacioSeleccionado = espacio;
                        break;
                    }
                }

                // Calcular y mostrar el monto a pagar
                if (espacioSeleccionado != null) {
                    double monto = espacioSeleccionado.calcularMontoAPagar(espacioSeleccionado, parqueo,cliente);
                    jLabelMontoAPagar.setText(String.valueOf(monto));
                    jLabelTiempoGuardado.setText("Tiempo guardado: "+String.valueOf(cliente.getMinsNoUtilizados()));
                }
            }
        }
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxEspaciosOcupados = new javax.swing.JComboBox<>();
        jLabelMonto = new javax.swing.JLabel();
        jLabelMontoAPagar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnVolver1 = new javax.swing.JButton();
        jLabelTiempoGuardado = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        inpCodigoValidacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Espacios ocupados por el cliente:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PAGAR");

        comboBoxEspaciosOcupados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelMonto.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabelMonto.setForeground(new java.awt.Color(255, 255, 255));

        jLabelMontoAPagar.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabelMontoAPagar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMontoAPagar.setText("0");

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Monto a pagar:");

        btnVolver1.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver1.setText("Volver");
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jLabelTiempoGuardado.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabelTiempoGuardado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTiempoGuardado.setText("Tiempo  guardado:");

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese el código de validación de la tarjeta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelMontoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelTiempoGuardado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelMonto))
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxEspaciosOcupados, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
                                .addComponent(comboBoxEspaciosOcupados, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inpCodigoValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(272, 272, 272)
                    .addComponent(jLabel3)
                    .addContainerGap(276, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver1)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEspaciosOcupados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTiempoGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMontoAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpCodigoValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(397, Short.MAX_VALUE)))
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

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        MenuCliente pantalla = new MenuCliente(cliente, parqueo);
        pantalla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        try {
        // Obtener el código de validación ingresado desde el text field
        int codigoValidacionIngresado = Integer.parseInt(inpCodigoValidacion.getText());

        // Obtener la tarjeta del cliente
        Tarjeta tarjetaCliente = cliente.getTarjeta();

        // Obtener el espacio seleccionado en el comboBox
        String espacioSeleccionadoStr = (String) comboBoxEspaciosOcupados.getSelectedItem();
        if (espacioSeleccionadoStr != null && !espacioSeleccionadoStr.equals("No hay espacios ocupados")) {
            int numeroEspacioSeleccionado = Integer.parseInt(espacioSeleccionadoStr);

            // Encontrar el espacio de parqueo correspondiente
            EspacioDeParqueo espacioSeleccionado = null;
            for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
                if (espacio.getNumeroEspacio() == numeroEspacioSeleccionado) {
                    espacioSeleccionado = espacio;
                    break;
                }
            }

            // Verificar que el espacio seleccionado no sea nulo
            if (espacioSeleccionado != null) {
                // Llamar al método pagar del cliente
                cliente.pagar(parqueo, espacioSeleccionado, tarjetaCliente, codigoValidacionIngresado);

                // Actualizar la interfaz gráfica después del pago
                jLabelMontoAPagar.setText("0"); // Resetear el monto después del pago
                jLabelTiempoGuardado.setText("0"); // Resetear el tiempo guardado después del pago

                System.out.println("Pago procesado con éxito.");
            } else {
                System.out.println("Error: Espacio seleccionado no encontrado.");
            }
        } else {
            System.out.println("Error: No se ha seleccionado un espacio.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Error: Ingrese un código de validación numérico válido.");
    }
        MenuCliente pantalla = new MenuCliente(cliente, parqueo);
        pantalla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPagar(cliente, parqueo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JComboBox<String> comboBoxEspaciosOcupados;
    private javax.swing.JTextField inpCodigoValidacion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMonto;
    private javax.swing.JLabel jLabelMontoAPagar;
    private javax.swing.JLabel jLabelTiempoGuardado;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
