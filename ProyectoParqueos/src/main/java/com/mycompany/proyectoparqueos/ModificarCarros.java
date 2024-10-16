package com.mycompany.proyectoparqueos;
import java.time.*;
import javax.swing.JOptionPane;

public class ModificarCarros extends javax.swing.JFrame {

    private Cliente cliente;
    private Parqueo parqueo;
    
    public ModificarCarros(Cliente cliente, Parqueo parqueo) {
        initComponents();
        setCliente(cliente);
        setParqueo(parqueo);
        setInformacion();
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
        btnVolver = new javax.swing.JButton();
        lblInfoCarro = new javax.swing.JLabel();
        lblInfoCarro2 = new javax.swing.JLabel();
        lblInfoCarro3 = new javax.swing.JLabel();
        inpModelo = new javax.swing.JTextField();
        inpPlaca = new javax.swing.JTextField();
        inpMarca = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        lblInfoCarro4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modificar Carros de Cliente");

        btnVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblInfoCarro.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblInfoCarro.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCarro.setText("Placa: ");

        lblInfoCarro2.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblInfoCarro2.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCarro2.setText("Marca: ");

        lblInfoCarro3.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblInfoCarro3.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCarro3.setText("Modelo: ");

        inpModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpModeloActionPerformed(evt);
            }
        });

        inpPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpPlacaActionPerformed(evt);
            }
        });

        inpMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpMarcaActionPerformed(evt);
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

        lblInfoCarro4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lblInfoCarro4.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoCarro4.setText("Importante: Utilice \"|\" para separar entre carros");

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
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInfoCarro2)
                                .addGap(30, 30, 30)
                                .addComponent(inpMarca))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInfoCarro3)
                                .addGap(18, 18, 18)
                                .addComponent(inpModelo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInfoCarro4, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInfoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(inpPlaca)))))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(183, 183, 183))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnVolver)
                .addGap(13, 13, 13)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInfoCarro4)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfoCarro)
                    .addComponent(inpPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInfoCarro3)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inpMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblInfoCarro2)))
                    .addComponent(inpModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
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
        MenuCliente pantalla = new MenuCliente(cliente, parqueo);
        pantalla.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void inpModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpModeloActionPerformed

    private void inpPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpPlacaActionPerformed

    private void inpMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpMarcaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try{
            YearMonth fecha = cliente.getTarjeta().getFechaVencimiento();
            String año1 = String.valueOf(fecha.getYear());
            int año = Integer.parseInt(año1);
            String mes1 = String.valueOf(fecha.getMonthValue());
            int mes = Integer.parseInt(mes1);
            String telefono = String.valueOf(cliente.getTelefono());
            Cliente cliente2 = new Cliente(cliente.getNombre(), cliente.getApellido(), telefono, cliente.getCorreo(), cliente.getDireccionFisica(),cliente.getFechaIngreso() ,cliente.getPin(),cliente.getIdentificacionUsuario() ,cliente.getTarjeta().getNumeroTarjeta(), mes, año, cliente.getTarjeta().getCodigoValidacion(),cliente.getMinsNoUtilizados());
            //se hace split para obtener todas las placas,marcas y modelos. Se utiliza \\ ya que | es un caracter especial y puede dar errores
            String [] placas = inpPlaca.getText().trim().split("\\|");
            String [] marcas = inpMarca.getText().trim().split("\\|"); 
            String [] modelos = inpModelo.getText().trim().split("\\|"); 
            
            for(int i =0; i<placas.length;i++){
                cliente2.agregarCarro(placas[i],marcas[i] , modelos[i]);
            }
            String infoACambiar = cliente2.toString();

            cliente2.modificarDatosCliente(infoACambiar);
            MenuCliente pantalla = new MenuCliente(cliente, parqueo);
            pantalla.setVisible(true);
            this.setVisible(false);
        }
        catch(ValidacionesExceptions e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(ModificarCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarCarros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarCarros(cliente, parqueo).setVisible(true);
            }
        });
    }

    //setters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setParqueo(Parqueo parqueo) {
        this.parqueo = parqueo;
    }
    //muestra atributos en la pantalla
    public void setInformacion(){
        for (Carro auto : cliente.getCarros()){ 
           inpPlaca.setText(inpPlaca.getText()+ auto.getPlaca() + "|");
           inpMarca.setText(inpMarca.getText()+auto.getMarca()+"|");
           inpModelo.setText(inpModelo.getText()+auto.getModelo()+"|");
        }    
    }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextField inpMarca;
    private javax.swing.JTextField inpModelo;
    private javax.swing.JTextField inpPlaca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfoCarro;
    private javax.swing.JLabel lblInfoCarro2;
    private javax.swing.JLabel lblInfoCarro3;
    private javax.swing.JLabel lblInfoCarro4;
    // End of variables declaration//GEN-END:variables
}
