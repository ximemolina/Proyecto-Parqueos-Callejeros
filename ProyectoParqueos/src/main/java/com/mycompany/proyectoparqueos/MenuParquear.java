
package com.mycompany.proyectoparqueos;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.File;


public class MenuParquear extends javax.swing.JFrame {
    Cliente cliente;
    Parqueo parqueo;
    private Carro carroSeleccionado;
    private EspacioDeParqueo espacioSeleccionado;

    
    public MenuParquear(Cliente cliente, Parqueo parqueo) {
        initComponents();
        setCliente(cliente);
        setParqueo(parqueo);
        llenarComboBoxEspaciosDeParqueo();
        actualizarComboBoxCarros();
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public void setParqueo(Parqueo parqueo){
        this.parqueo = parqueo;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxCarros = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboBoxEspaciosDeParqueo = new javax.swing.JComboBox<>();
        BtnAceptarParquear = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inpTiempoComprado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PARQUEAR");

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccionar espacio:");

        comboBoxCarros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCarros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCarrosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        comboBoxEspaciosDeParqueo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxEspaciosDeParqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEspaciosDeParqueoActionPerformed(evt);
            }
        });

        BtnAceptarParquear.setText("ACEPTAR");
        BtnAceptarParquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarParquearActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tus carros:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Espacios disponibles:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tiempo que desea comprar:");

        inpTiempoComprado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpTiempoCompradoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Seleccionar carro:");

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
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(inpTiempoComprado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxEspaciosDeParqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnAceptarParquear, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel8)
                    .addContainerGap(426, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCarros, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxEspaciosDeParqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpTiempoComprado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addComponent(BtnAceptarParquear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(345, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void comboBoxCarrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCarrosActionPerformed
        if (comboBoxCarros.getSelectedItem() != null) {
        // Obtener la placa seleccionada del ComboBox
        String placaSeleccionada = (String) comboBoxCarros.getSelectedItem();

        // Buscar el carro correspondiente en la lista de carros del cliente
        for (Carro carro : cliente.getCarros()) {
            if (carro.getPlaca().equals(placaSeleccionada)) {
                this.carroSeleccionado = carro;  // Asignar el carro seleccionado
                break; 
            }
        }

        // Aquí puedes usar el carro seleccionado
        if (carroSeleccionado != null) {
            System.out.println("Carro seleccionado: " + carroSeleccionado.getPlaca());
        }
    }
        
    }//GEN-LAST:event_comboBoxCarrosActionPerformed
    private void llenarComboBoxEspaciosDeParqueo() {
        comboBoxEspaciosDeParqueo.removeAllItems();  // Limpiar ComboBox antes de llenarlo

        ArrayList<EspacioDeParqueo> espaciosDisponibles = parqueo.getEspaciosDisponibles();

        // Llenar ComboBox con los espacios disponibles
        for (EspacioDeParqueo espacio : espaciosDisponibles) {
            comboBoxEspaciosDeParqueo.addItem(String.valueOf(espacio.getNumeroEspacio()));
        }
    }
    
    private void actualizarComboBoxCarros() {
        comboBoxCarros.removeAllItems();  // Limpiar el ComboBox antes de llenarlo

        // Obtener la lista de carros del cliente
        ArrayList<Carro> carrosDelCliente = cliente.getCarros();

        // Recorrer todos los carros del cliente
        for (Carro carro : carrosDelCliente) {
            boolean estaParqueado = false;

            // Verificar si el carro está asociado a algún espacio de parqueo
            for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
                if (espacio.getCarro() != null && espacio.getCarro().equals(carro)) {
                    estaParqueado = true;  // Si el carro está parqueado, lo marcamos
                    break;  // Salimos del bucle si ya sabemos que está parqueado
                }
            }

            // Si el carro no está parqueado, lo agregamos al ComboBox
            if (!estaParqueado) {
                comboBoxCarros.addItem(carro.getPlaca());  // Agregar la placa del carro no parqueado al ComboBox
                System.out.println("Carro no parqueado agregado: " + carro.getPlaca());
            } else {
                System.out.println("Carro ya está parqueado: " + carro.getPlaca());
            }
        }

        // Si no quedan carros disponibles, agregar un mensaje
        if (comboBoxCarros.getItemCount() == 0) {
            comboBoxCarros.addItem("No hay carros disponibles para parquear");
        }
    }

    

    
    private void comboBoxEspaciosDeParqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEspaciosDeParqueoActionPerformed
       if (comboBoxEspaciosDeParqueo.getSelectedItem() != null) {
        // Obtener el valor seleccionado del ComboBox como String
        String numeroEspacioSeleccionado = (String) comboBoxEspaciosDeParqueo.getSelectedItem();
        
        // Convertir el String a entero
        int numeroParqueoSeleccionado = Integer.parseInt(numeroEspacioSeleccionado);
        
        // Obtener los espacios disponibles
        ArrayList<EspacioDeParqueo> espaciosDisponibles = parqueo.getEspaciosDisponibles();

        // Buscar el espacio correspondiente
        EspacioDeParqueo espacioSeleccionadoObjeto = null;
        for (EspacioDeParqueo espacio : espaciosDisponibles) {
            if (espacio.getNumeroEspacio() == numeroParqueoSeleccionado) {
                espacioSeleccionadoObjeto = espacio;  // Asignar el objeto espacio
                break;
            }
        }

        // Si se encontró el espacio, asignarlo a la variable de la clase
        if (espacioSeleccionadoObjeto != null) {
            espacioSeleccionado = espacioSeleccionadoObjeto;  // Asignar al atributo de la clase
            System.out.println("Espacio seleccionado asignado: " + espacioSeleccionado.getNumeroEspacio());
        }
    }
    }//GEN-LAST:event_comboBoxEspaciosDeParqueoActionPerformed

    private void BtnAceptarParquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarParquearActionPerformed
       if (comboBoxCarros.getSelectedItem() == null || comboBoxCarros.getSelectedItem().equals("No hay carros disponibles para parquear")) {
        JOptionPane.showMessageDialog(null, "Error: No hay carros disponibles para parquear.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir de la función si no hay carros disponibles
    }
       
        if (espacioSeleccionado != null) {
            // Intentar parquear el carro en el espacio primero
            File archivoParqueo = new File("Parqueo.txt");
            boolean parqueoExitoso = cliente.parquear(carroSeleccionado, espacioSeleccionado, parqueo, archivoParqueo);

            // Si el parqueo fue exitoso, procedemos a comprar tiempo
            if (parqueoExitoso) {
                try {
                    // Obtener el tiempo ingresado
                    int tiempoAgregar = Integer.parseInt(inpTiempoComprado.getText());

                    // Validar y actualizar el tiempo comprado **después** de parquear el carro
                    cliente.comprarTiempo(tiempoAgregar, espacioSeleccionado, parqueo);

                    // Mensaje de éxito de parqueo y compra de tiempo
                    JOptionPane.showMessageDialog(null, "Carro parqueado y tiempo agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // Guardar cambios en el archivo después de parquear y agregar tiempo
                    parqueo.guardarParqueo(archivoParqueo);

                    // Buscar el espacio 1 y mostrar su estado directamente
                    for (EspacioDeParqueo espacio : parqueo.getEspaciosParqueo()) {
                        if (espacio.getNumeroEspacio() == 1) {  // Verifica si es el espacio 1
                            Carro carro = espacio.getCarro();
                            if (carro != null) {
                                JOptionPane.showMessageDialog(null, "Espacio 1 - Ocupado por carro: " + carro.getPlaca(), "Información", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Espacio 1 - Libre", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;  // Salir después de encontrar y mostrar el espacio 1
                        }
                    }

                    // Actualizar ComboBox de carros no parqueados y espacios disponibles
                    actualizarComboBoxCarros();
                    llenarComboBoxEspaciosDeParqueo();

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido para el tiempo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo parquear el carro.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se encontró el espacio seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_BtnAceptarParquearActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuCliente pantalla = new MenuCliente(cliente, parqueo);
        pantalla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void inpTiempoCompradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpTiempoCompradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpTiempoCompradoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuParquear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuParquear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuParquear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuParquear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuParquear(cliente, parqueo).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptarParquear;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboBoxCarros;
    private javax.swing.JComboBox<String> comboBoxEspaciosDeParqueo;
    private javax.swing.JTextField inpTiempoComprado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
