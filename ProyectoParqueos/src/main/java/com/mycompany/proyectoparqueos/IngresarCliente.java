/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoparqueos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;


public class IngresarCliente extends javax.swing.JFrame {
    Parqueo parqueo;
    /**
     * Creates new form IngresarCliente
     */
    public IngresarCliente(Parqueo parqueo) {
        initComponents();
        setParqueo(parqueo);
    }
    
    public void setParqueo(Parqueo parqueo){
        this.parqueo = parqueo;
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
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inpIdentificacion = new javax.swing.JTextField();
        inpPin = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INGRESAR CLIENTE");

        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Identificacion de usuario: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PIN : ");

        inpIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpIdentificacionActionPerformed(evt);
            }
        });

        inpPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpPinActionPerformed(evt);
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
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inpIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(inpPin, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))))
                .addGap(154, 154, 154))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver)
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        MenuIngresar menu = new MenuIngresar(parqueo);
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void inpIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpIdentificacionActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //obtiene informacion de inputs
        String id = inpIdentificacion.getText();
        String pin = inpPin.getText();
        leerArchivo(id, pin);

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void inpPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpPinActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarCliente(parqueo).setVisible(true);
            }
        });
    }
        //lee el archivo y verifica si el usuario ingresado existe
    public void leerArchivo(String id, String pin){
        String contenido;
        try{
            FileReader leer = new FileReader("Cliente.txt");
            BufferedReader lectura = new BufferedReader(leer);
            contenido = lectura.readLine(); //lee una línea del archivo
            String [] lista;
            while(contenido != null){
                
                try{
                    lista = contenido.split(","); //divide la linea en cada atributo de administrador
                    if(lista[0].equals(id) && lista[1].equals(pin)){

                        LocalDate fecha = LocalDate.parse(lista[7], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                        
                        int min = Integer.parseInt(lista[11]);
                        long num = Long.parseLong(lista[8]);
                        String[] añoMes = lista[9].split("-");
                        int año = Integer.parseInt(añoMes[0]);
                        int mes = Integer.parseInt(añoMes[1]);
                        int cod = Integer.parseInt(lista[10]);
                        //crea objeto Cliente con atributos respectivos para poder pasarselos a pantalla de acciones de admin
                        Cliente cliente = new Cliente(lista[2], lista[3],lista[4], lista[5], lista[6], fecha, lista[1], lista[0],num,mes,año,cod,min);
                        int contador = 12;
                        while(contador < lista.length){
                            cliente.agregarCarro(lista[contador], lista[contador+1], lista[contador+2]);
                            contador = contador +3;
                        }
                        MenuCliente pantalla = new MenuCliente(cliente, parqueo);
                        pantalla.setVisible(true);
                        this.setVisible(false);
                        return;
                    }
                    contenido = lectura.readLine();
                }catch(Exception e){
                    e.printStackTrace();
                    contenido = lectura.readLine();
                }
            }
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField inpIdentificacion;
    private javax.swing.JPasswordField inpPin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
