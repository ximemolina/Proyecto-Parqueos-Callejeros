package com.mycompany.proyectoparqueos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ConsultarCliente extends javax.swing.JFrame {

    Cliente cliente;
    
    public ConsultarCliente(Cliente cliente) {
        initComponents();
        setCliente(cliente);
        mostrarInfoCliente();
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
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        lblNumeroTarjeta = new javax.swing.JLabel();
        lblVencimiento = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblInfoCarro = new javax.swing.JLabel();
        lblInfoCarro2 = new javax.swing.JLabel();
        lblInfoCarro3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 450));

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consultar Información de Cliente");

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
        lblFechaIngreso.setText("Fecha de ingreso a sistema:");

        lblNumeroTarjeta.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblNumeroTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroTarjeta.setText("Número de tarjeta:");

        lblVencimiento.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblVencimiento.setForeground(new java.awt.Color(255, 255, 255));
        lblVencimiento.setText("Fecha de vencimiento de tarjeta:");

        lblCodigo.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("Codigo de validación:");

        lblNombre1.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setText("Información autos:");

        lblMarca.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(255, 255, 255));

        lblInfoCarro.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        lblInfoCarro.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCarro.setText("Placa: ");

        lblInfoCarro2.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        lblInfoCarro2.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCarro2.setText("Marca: ");

        lblInfoCarro3.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        lblInfoCarro3.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCarro3.setText("Modelo: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver)
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblNumeroTarjeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFechaIngreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                                        .addComponent(lblIdentificacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblInfoCarro3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblInfoCarro2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblInfoCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoCarro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoCarro2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInfoCarro3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMarca))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuCliente pantalla = new MenuCliente(cliente);
        pantalla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarCliente(cliente).setVisible(true);
            }
        });
    }
    public void mostrarInfoCliente(){
        lblNombre.setText("Nombre: " + cliente.getNombre());
        lblApellidos.setText("Apellidos: " + cliente.getApellido());
        lblCorreo.setText("Correo electrónico: "+cliente.getCorreo());
        lblTelefono.setText("Número de teléfono: "+ String.valueOf(cliente.getTelefono()));
        lblIdentificacion.setText("Identificacion de Usuario: "+ cliente.getIdentificacionUsuario());
        lblDireccion.setText("Dirección física: " + cliente.getDireccionFisica());
        LocalDate fecha = cliente.getFechaIngreso();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Convertir LocalDate a String
        String fechaEnTexto = fecha.format(formato);
        lblFechaIngreso.setText("Fecha de ingreso al sistema: " + fechaEnTexto);
        lblNumeroTarjeta.setText("Número de tarjeta: "+ (cliente.getTarjeta()).getNumeroTarjeta());
        lblVencimiento.setText("Fecha de vencimiento de tarjeta: "+ (cliente.getTarjeta()).getFechaVencimiento());
        lblCodigo.setText("Número de tarjeta: "+ (cliente.getTarjeta()).getCodigoValidacion());
        for(Carro carro : cliente.getCarros()){
            lblInfoCarro.setText(lblInfoCarro.getText() + carro.getPlaca() +" | ");
            lblInfoCarro2.setText(lblInfoCarro2.getText()+ carro.getMarca()+ " | ");
            lblInfoCarro3.setText(lblInfoCarro3.getText()+ carro.getModelo()+ " | ");
        }
    }
    public void setCliente(Cliente pCliente){
        cliente = pCliente;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblInfoCarro;
    private javax.swing.JLabel lblInfoCarro2;
    private javax.swing.JLabel lblInfoCarro3;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNumeroTarjeta;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblVencimiento;
    // End of variables declaration//GEN-END:variables
}
