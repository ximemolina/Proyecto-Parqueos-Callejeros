package com.mycompany.proyectoparqueos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import javax.swing.JOptionPane;

public class MenuInicial extends javax.swing.JFrame {
    Parqueo parqueo;
    /**
     * Creates new form MenuInicial
     */
    public MenuInicial(Parqueo parqueo) {
        initComponents();        
        try{
            File archivoParqueo = new File("Parqueo.txt");
            if(!archivoParqueo.exists())
                archivoParqueo.createNewFile();
            else if(archivoParqueo.length()!= 0){
                try{
                    leerArchivo(parqueo);
                    //System.out.println(parqueo.toString());
                }catch(Exception e){
                    e.printStackTrace();
                }
            } 
            setParqueo(parqueo);
        }
        
        catch(Exception e){
            
            e.getMessage();
        }
        setParqueo(parqueo);
    }
    
    public void setParqueo(Parqueo parqueo){
        this.parqueo = parqueo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 450));

        btnRegistrar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setText("Registrar usuario");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnIngresar.setBackground(new java.awt.Color(204, 204, 204));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIngresar.setText("Ingresar usuario");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setText("PARQUEOS CALLEJEROS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrar)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        btnRegistrar.getAccessibleContext().setAccessibleName("btnRegistrar");
        btnIngresar.getAccessibleContext().setAccessibleName("btnIngresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //se crea ventana para ingresar y se pone visible
        if (parqueo == null) 
                System.out.println("El objeto parqueo es null");
        MenuIngresar menuIngresar = new MenuIngresar(parqueo);
        menuIngresar.setVisible(true);
        this.setVisible(false); //menu inicial desaparece    
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        //se crea ventana para registrar y se pone visible
        MenuRegistrar menuRegistrar = new MenuRegistrar(parqueo);
        menuRegistrar.setVisible(true);
        this.setVisible(false); //menu inicial desaparece
    }//GEN-LAST:event_btnRegistrarActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial(parqueo).setVisible(true);
            }
        });
    }
    //lee el archivo y actualiza datos
    public void leerArchivo(Parqueo parqueo){
        String contenido;
        int contador = 0;
        try{

            FileReader leer = new FileReader("Parqueo.txt");
            BufferedReader lectura = new BufferedReader(leer);
            contenido = lectura.readLine(); //lee una línea del archivo
            String [] lista;
            while(contenido != null){
                
                try{
                    if(contador == 0)
                        parqueo.setCodigoTerminal(contenido);
                    if(contador ==1)
                        parqueo.setTiempoMinimo(Integer.parseInt(contenido));
                    if(contador ==2)
                        parqueo.setPrecioHora(Integer.parseInt(contenido));
                    if(contador ==3)
                        parqueo.setAbre(contenido);
                    if(contador ==4)
                        parqueo.setCierra(contenido);
                    if(contador == 5)
                        parqueo.setCostoMulta(Integer.parseInt(contenido));
                    if(contador >=6){
                        lista = contenido.split(",");
                        EspacioDeParqueo espacio = new EspacioDeParqueo(Integer.parseInt(lista[0]));
                        espacio.setTiempoComprado(Integer.parseInt(lista[1]));
                        if(lista[2]!= ""){
                            Carro carro = new Carro(lista[2], lista[3], lista[4]);
                            espacio.setCarro(carro);
                        }
                        if(!String.valueOf(lista[5]).equals("null")){
                            espacio.setHoraInicioParqueo(LocalDateTime.parse(lista[5]));}
                        if(!String.valueOf(lista[6]).equals("null")){
                            espacio.setHoraFinParqueo(LocalDateTime.parse(lista[6]));}
                        espacio.setDisponible(Boolean.parseBoolean(lista[7]));
                        parqueo.agregarEspacioParqueo(espacio);
                    }
                    
                    contenido = lectura.readLine();
                }catch(Exception e){
                    e.printStackTrace();
                    contenido = lectura.readLine();
                }
                contador ++;
            }
            
        } catch(IOException exception){
            exception.printStackTrace();
        }
        //se actualiza historial de parqueo       
        try{
            HistorialParqueo nuevo = new HistorialParqueo();
            FileReader leer = new FileReader("HistorialParqueo.txt"); //se lee el txt en donde están almaenados los datos
            BufferedReader lectura = new BufferedReader(leer);
            contenido = lectura.readLine(); //lee una línea del archivo
            String [] lista;
            while(contenido != null){  
                try{
                    lista = contenido.split("\\,"); //se realiza un split apartir de "," para que se puedan almacenar los distintos atributos en la lista
                    EspacioDeParqueo espacio = new EspacioDeParqueo(Integer.parseInt(lista[0]));
                    espacio.setTiempoComprado(Integer.parseInt(lista[1]));
                    if(lista[2]!= ""){//se verifica que ese indice no esté vacío, ya que en caso de que lo esté, implica que no hay carro ahí
                        Carro carro = new Carro(lista[2], lista[3], lista[4]);
                        espacio.setCarro(carro);
                    }
                    if(!String.valueOf(lista[5]).equals("null")){//verificar que lista[5] no sea null para que no de error la conversión
                        espacio.setHoraInicioParqueo(LocalDateTime.parse(lista[5]));
                    }
                    if(!String.valueOf(lista[6]).equals("null")){ //verificar que lista[6] no sea null para que no de error la conversión
                       espacio.setHoraFinParqueo(LocalDateTime.parse(lista[6]));}
                    espacio.setDisponible(Boolean.parseBoolean(lista[7]));
                    nuevo.agregarHistorialParqueo(espacio); //agregar el espacio de parqueo al Historial
                    contenido = lectura.readLine();//continua leyendo la otra linea del archivo
                }catch(Exception e){
                    //e.printStackTrace();
                    contenido = lectura.readLine();
                }
                contador ++;
            }
            parqueo.setHistorialParqueo(nuevo);
            
        } catch(IOException exception){
            exception.printStackTrace();
        }
        //se actualiza historial de parqueo       
        try{
            HistorialMultas otro = new HistorialMultas();
            FileReader leer = new FileReader("HistorialMulta.txt"); //se lee el txt en donde están almaenados los datos
            BufferedReader lectura = new BufferedReader(leer);
            contenido = lectura.readLine(); //lee una línea del archivo
            String [] lista;
            while(contenido != null){  
                try{
                    lista = contenido.split("\\,"); //se realiza un split apartir de "," para que se puedan almacenar los distintos atributos en la lista
                    Carro carro = new Carro(lista[0],lista[1],lista[2]);
                    int costo = Integer.parseInt(lista[3]);
                    LocalDateTime fecha = LocalDateTime.parse(lista[4]);
                    Multa multa = new Multa(carro,costo,fecha,false);
                    otro.agregarMulta(multa,lista[5]); //lista[5] sería el id del inspector que realizó la multa
                    contenido = lectura.readLine();//continua leyendo la otra linea del archivo
                }catch(Exception e){
                    //e.printStackTrace();
                    contenido = lectura.readLine();
                }
                contador ++;
            }
            parqueo.setHistorialMultas(otro);
            
        } catch(IOException exception){
            exception.printStackTrace();
        }
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
