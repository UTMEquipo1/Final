/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor.persisitencia;

import MySQL.BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import Vendedor.persisitencia.EditarV;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author willm
 */
public class Inventario extends javax.swing.JFrame {
    
    
    public static Integer idvende;
    /**
     * Creates new form Inventario
     */
    /**
     * 
     * @throws IOException 
     */
    public Inventario() throws IOException {
        initComponents();
        Pruebas ventanauno = new Pruebas();
        idvende=ventanauno.idvende;
        try {
            MostrarInventario();
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
    }
     public static String nombret = "";
     public static String descripciont = "";
     public static String cantidadt = "";
     public static String preciot = "";
     public static String tipot = "";
     public static String idt = "";
    
    /**
     * 
     * @throws SQLException
     * @throws IOException 
     */
    void MostrarInventario() throws SQLException, IOException{
        /*CONEXION A BD*/
        
        tablainventario.setDefaultRenderer(Object.class, new RenderImagen());
        
        
        String DB="XcRj6qcf4U";
        String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
        String USER="XcRj6qcf4U";
        String PASS="p3SRSqI4Za";
        
        
   
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Tipo");
        modelo.addColumn("ID");
        modelo.addColumn("Imagen");
        tablainventario.setModel(modelo);
        
        
        String sql = "SELECT * FROM Producto WHERE ID_Inventario= '"+idvende+"'";
        Object datos[]= new Object[7];
        Statement st = null;
        
       
        Connection con = null;
         PreparedStatement pps = null ;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(URL,USER,PASS);
           pps= con.prepareStatement(sql);
           ResultSet rs=pps.executeQuery();
           while(rs.next()){
               datos[0]=rs.getObject(1);
               datos[1]=rs.getObject(2);
               datos[2]=rs.getObject(3);
               datos[3]=rs.getObject(4);
               datos[4]=rs.getObject(5);
               datos[5]=rs.getObject(6);
               
               //imagen Render
               Blob blob = rs.getBlob(7);

               byte[] data = blob.getBytes(1,(int)blob.length());
               BufferedImage img = null;
               try{
                   img= ImageIO.read(new ByteArrayInputStream(data));
               }catch(IOException e){
                   
               }
               if(img!=null){
                   ImageIcon icono = new ImageIcon(img);
                datos[6] = new JLabel(icono);
               }
               
               ////Fin render
               
               
               modelo.addRow(datos);
           }
           tablainventario.setModel(modelo);
           tablainventario.setRowHeight(150);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al visualizar");
        }
        finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pps != null) {
                    con.close();
                }
                if (st != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, sqle);
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

        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablainventario = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        jLabel11.setText("jLabel11");

        jLabel13.setText("jLabel13");

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Garamond", 0, 36)); // NOI18N
        jLabel1.setText("INVENTARIO");

        tablainventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablainventario);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Editar Producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(384, 384, 384))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Pruebas Prueba = new Pruebas();
       Prueba.setVisible(true);
       super.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * 
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int fila = tablainventario.getSelectedRow();
        if(fila>=0){
            nombret=tablainventario.getValueAt(fila, 0).toString();
            descripciont=tablainventario.getValueAt(fila, 1).toString();
            cantidadt=tablainventario.getValueAt(fila, 2).toString();
            preciot=tablainventario.getValueAt(fila, 3).toString();
            tipot=tablainventario.getValueAt(fila, 4).toString();
            idt=tablainventario.getValueAt(fila, 5).toString();
            
            
            EditarV ventana;
            try {
                ventana = new EditarV();
                ventana.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null,"Fila no Seleccionada");
        }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = tablainventario.getSelectedRow();
        
        
        if(fila>=0){
            Integer valor = (Integer) tablainventario.getValueAt(fila, 5);
            Connection con = null;
            PreparedStatement pps = null;
            String DB="XcRj6qcf4U";
            String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
            String USER="XcRj6qcf4U";
            String PASS="p3SRSqI4Za";
            
            String sql = "DELETE FROM Producto WHERE ID_Producto="+valor;
            try{

                Class.forName("com.mysql.jdbc.Driver").newInstance();    
                con = DriverManager.getConnection(URL,USER,PASS);
                pps = con.prepareStatement(sql);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Producto Eliminado");
                MostrarInventario();

                }catch (ClassNotFoundException | SQLException | IOException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pps != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
            
        }else{
            JOptionPane.showMessageDialog(null,"Fila no Seleccionada");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inventario().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablainventario;
    // End of variables declaration//GEN-END:variables
}
