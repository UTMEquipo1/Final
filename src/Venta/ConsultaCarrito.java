/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta;

import Elementos.Producto;
import Elementos.ProductoCompra;
import Frame.MostrarCarrito;
import Frame.menu;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que realiza las operaciones de consulta sql.
 * @author Leonel
 */
public class ConsultaCarrito {
    public static Integer id_carrito;
    private final String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U?useSSL=false";
    private final String USER="XcRj6qcf4U";
    private final String PASS="p3SRSqI4Za";
    public static ArrayList<ProductoCompra> lista;
    
    public ConsultaCarrito() throws IOException, SQLException{
        menu ventana = new menu();
        id_carrito = ventana.IDCliente;
        lista=realizarConsulta(id_carrito);
        
    }
    /**
     * Método que obtiene los productos que se encuentran en el carrito del cliente. Posteriormente se envían a la clase 
     * boundary MostrarCarrito para que las vea el Cliente.
     * @param idCarrito es el identificador que se usa para la consulta sql.
     * @return la lista de productos en un ArrayList
     * @throws IOException
     * @throws SQLException 
     */
    public ArrayList<ProductoCompra> realizarConsulta(int idCarrito)throws IOException, SQLException{
        String sql = "SELECT * FROM Productocompra WHERE id_carrito='"+idCarrito+"'";
        Object datos[]= new Object[5];
        
        Connection con=null;
        PreparedStatement pps=null;
        Statement st=null;
        ArrayList<ProductoCompra> listaCarrito = new ArrayList<ProductoCompra>();
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(URL,USER,PASS);
           pps= con.prepareStatement(sql);
           ResultSet rs=pps.executeQuery();
           while(rs.next()){
               ProductoCompra prodNuevo = new ProductoCompra();
               datos[0]=rs.getObject(1);
               datos[1]=rs.getObject(3);
               datos[2]=rs.getObject(4);
               datos[3]=rs.getObject(5);
               datos[4]=rs.getObject(2);
               prodNuevo.setNombre_producto(String.valueOf(datos[0]));
               prodNuevo.setCantidad(Float.valueOf(String.valueOf(datos[1])));
               prodNuevo.setPrecio(Float.valueOf(String.valueOf(datos[2])));
               prodNuevo.setId_productocompra(Integer.valueOf(String.valueOf(datos[3])));
               prodNuevo.setId_carrito(Integer.valueOf(String.valueOf(datos[4])));
               listaCarrito.add(prodNuevo);
               
           }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarCarrito.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ConsultaCarrito.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
        return listaCarrito;
    }
    /**
     * Método que elimina un producto del carrito.
     * @param id_producto el producto que se necesita eliminar
     * @param id_carrito el carrito en el que se encuentra dicho producto
     * @throws IOException
     * @throws SQLException 
     */
    public void eliminarProducto(int id_producto,int id_carrito)throws IOException, SQLException{
        PreparedStatement pps = null;
        Statement st = null;
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USER,PASS);
            pps = con.prepareStatement("DELETE FROM Productocompra WHERE id_carrito ='"+id_carrito+"'and id_productocompra='"+id_producto+"'");
            pps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarCarrito.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
                Logger.getLogger(ConsultaCarrito.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
    }
}
