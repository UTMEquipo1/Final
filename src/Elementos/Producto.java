/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import static Elementos.ClaseInventario.Idvendedor;
import static Elementos.Vendedor.tablainventario;
import Vendedor.persisitencia.AnadirV2;
import static Vendedor.persisitencia.AnadirV2.idvende;
import Vendedor.persisitencia.EditarV;
import Vendedor.persisitencia.Inventario;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class Producto {
    
    public static String Nombre;
    public static String Descripcion;
    public static Float Cantidad;
    public static Float Precio;
    public static String Tipo;
    public static Integer Idproducto;
    public static BufferedImage img;
    public static Integer Idvendedor;
    
    public void MostrarProductos() throws SQLException{ 
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
        
        
        String sql = "SELECT * FROM Producto";
        Object datos[]= new Object[7];
        Statement st = null;
        ArrayList<Producto> tablaproductos=  new ArrayList();
       
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
               tablaproductos.add(nuevo);
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        Producto.Nombre = Nombre;
    }

    public static String getDescripcion() {
        return Descripcion;
    }

    public static void setDescripcion(String Descripcion) {
        Producto.Descripcion = Descripcion;
    }

    public static Float getCantidad() {
        return Cantidad;
    }

    public static void setCantidad(Float Cantidad) {
        Producto.Cantidad = Cantidad;
    }

    public static Float getPrecio() {
        return Precio;
    }

    public static void setPrecio(Float Precio) {
        Producto.Precio = Precio;
    }

    public static String getTipo() {
        return Tipo;
    }

    public static void setTipo(String Tipo) {
        Producto.Tipo = Tipo;
    }

    public static Integer getIdproducto() {
        return Idproducto;
    }

    public static void setIdproducto(Integer Idproducto) {
        Producto.Idproducto = Idproducto;
    }

    public static BufferedImage getImg() {
        return img;
    }

    public static void setImg(BufferedImage img) {
        Producto.img = img;
    }

    public static Integer getIdvendedor() {
        return Idvendedor;
    }
    /**
     * 
     * @param Idvendedor 
     */
    public static void setIdvendedor(Integer Idvendedor) {
        Producto.Idvendedor = Idvendedor;
    }
    public void BuscarProductoVendedor(int idvendedor) throws SQLException{
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
        ArrayList<Producto> tablaproductos=  new ArrayList();
       
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
               tablaproductos.add(nuevo);
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
    }
    
    
    public void AnadirProducto(String nom, int Id, String Des, String tipo, Float Pre, Float cant, File fi, int Idn, String ruta){
        String DB="XcRj6qcf4U";
        String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
        String USER="XcRj6qcf4U";
        String PASS="p3SRSqI4Za";
        
        PreparedStatement pps = null;
        Statement st = null;
        
        Connection con = null;
        
       
        try {
            File file = new File(ruta);
            
            con = DriverManager.getConnection(URL,USER,PASS);
            pps = con.prepareStatement("INSERT INTO Producto VALUES(?,?,?,?,?,?,?,?)");
            pps.setString(1, nom);
            pps.setString(2,Des);
            pps.setFloat(3,cant);
            pps.setFloat(4, Pre);
            pps.setString(5,tipo);
            pps.setInt(6,Id);
            
            pps.setInt(8,idvende);
            
            
            pps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AnadirV2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"No se pudo Guardar");
        }finally {
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
                Logger.getLogger(AnadirV2.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
        
    }
    public void EditarProducto(String nom, int Id, String Des, String tipo, Float Pre, Float cant, File fi, int Idn, String ruta) throws FileNotFoundException{
        String DB="XcRj6qcf4U";
        String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
        String USER="XcRj6qcf4U";
        String PASS="p3SRSqI4Za";
        PreparedStatement pps = null;
        Statement st = null;
        
        Connection con = null;
        
        File file = new File(ruta);
        
        
        try{
            
            con = DriverManager.getConnection(URL,USER,PASS);
            pps = con.prepareStatement("UPDATE Producto SET Nombre='"+nom+"',Descripcion='"+Des+"',Cantidad='"+cant+"',Precio='"+Pre+"',Tipo='"+tipo+"',ID_Producto='"+Idn+"',Imagenp='"+file+"'WHERE ID_Producto='"+Id+"'");
            pps.executeUpdate();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(EditarV.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Logger.getLogger(EditarV.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
        
    }
    public void EliminarProducto(int Id) throws SQLException{
        Connection con = null;
        PreparedStatement pps = null;
        String DB="XcRj6qcf4U";
        String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
        String USER="XcRj6qcf4U";
        String PASS="p3SRSqI4Za";

        String sql = "DELETE FROM Producto WHERE ID_Producto="+Id;
        try{

        Class.forName("com.mysql.jdbc.Driver").newInstance();    
        con = DriverManager.getConnection(URL,USER,PASS);
        pps = con.prepareStatement(sql);
        pps.executeUpdate();


        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pps != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, sqle);
            }
        
        }
    }
    
    
}
