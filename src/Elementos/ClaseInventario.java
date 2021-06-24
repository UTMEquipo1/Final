/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import static Elementos.Vendedor.tablainventario;
import Vendedor.persisitencia.Inventario;
import static Vendedor.persisitencia.Inventario.idvende;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willm
 */
public class ClaseInventario {
    public static String Nombre_tienda;
    public static Integer Idinventario;
    public static Integer Idvendedor;
    
    
    
    public void MostrarInventario() throws SQLException{
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
        
        
        String sql = "SELECT * FROM Producto WHERE ID_Inventario= '"+Idvendedor+"'";
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
               Producto nuevo = new Producto();
               
               nuevo.setNombre(rs.getObject(1).toString());
               nuevo.setDescripcion(rs.getObject(2).toString());
               nuevo.setCantidad(Float.parseFloat(rs.getObject(3).toString()));
               nuevo.setPrecio(Float.parseFloat(rs.getObject(4).toString()));
               nuevo.setTipo(rs.getObject(5).toString());
               nuevo.setIdproducto(Integer.parseInt(rs.getObject(6).toString()));
               
               
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
               nuevo.setImg(img);
               tablainventario.add(nuevo);
           }
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

    public static String getNombre_tienda() {
        return Nombre_tienda;
    }

    public static void setNombre_tienda(String Nombre_tienda) {
        ClaseInventario.Nombre_tienda = Nombre_tienda;
    }

    public static Integer getIdinventario() {
        return Idinventario;
    }

    public static void setIdinventario(Integer Idinventario) {
        ClaseInventario.Idinventario = Idinventario;
    }

    public static Integer getIdvendedor() {
        return Idvendedor;
    }

    public static void setIdvendedor(Integer Idvendedor) {
        ClaseInventario.Idvendedor = Idvendedor;
    }
    
    
}
