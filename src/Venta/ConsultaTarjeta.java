/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta;

import Elementos.Tarjeta;
import Frame.MostrarCarrito;
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
 *
 * @author Rlope
 */
public class ConsultaTarjeta {
    
    public static Integer id_cliente;
    public static ArrayList<Tarjeta> lista;
    private final String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
    private final String USER="XcRj6qcf4U";
    private final String PASS="p3SRSqI4Za";
    
    public ConsultaTarjeta()throws IOException, SQLException{
        
        ConsultaCarrito ventana = new ConsultaCarrito();
        
        id_cliente = ventana.id_carrito;
        lista=realizaConsulta(id_cliente);
        Tarjeta t= new Tarjeta(0,"Efectivo","","",0);
        lista.add(t);
        
    }
    ArrayList<Tarjeta> realizaConsulta(int id_carrito)throws IOException, SQLException{
        String sql = "SELECT * FROM Tarjeta WHERE ID_Cliente='"+id_carrito+"'";
        Object datos[]= new Object[5];
        
        Connection con=null;
        PreparedStatement pps=null ;
        Statement st=null;
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();
       
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection(URL,USER,PASS);
           pps= con.prepareStatement(sql);
           ResultSet rs=pps.executeQuery();
           while(rs.next()){
               
               Tarjeta nuevaTarjeta = new Tarjeta();
               datos[0]=rs.getObject(1);
               datos[1]=rs.getObject(2);
               datos[2]=rs.getObject(3);
               datos[3]=rs.getObject(4);
               datos[4]=rs.getObject(5);
               
               nuevaTarjeta.setNombre(String.valueOf(datos[0]));
               nuevaTarjeta.setNum_tarjeta(String.valueOf(datos[1]));
               nuevaTarjeta.setFecha_vencimiento(String.valueOf(datos[2]));
               nuevaTarjeta.setNumeros_seguridad(Integer.valueOf(String.valueOf(datos[3])));
               nuevaTarjeta.setId_cliente(Integer.valueOf(String.valueOf(datos[4])));
               listaTarjetas.add(nuevaTarjeta);
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
           return listaTarjetas;
    }
    public void mostrarTarjetas(ArrayList<Tarjeta> realizarConsulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


