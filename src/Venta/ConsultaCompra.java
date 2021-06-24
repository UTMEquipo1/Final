/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Venta;

import Elementos.Compra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonel
 */
public class ConsultaCompra {
    private final String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U?useSSL=false";
    private final String USER="XcRj6qcf4U";
    private final String PASS="p3SRSqI4Za";
    
    public ConsultaCompra(){
        
    }
    
    public void subirCompra(Compra compra){
        String sql = "INSERT INTO Compra VALUES(?,?,?,?,?)";
        PreparedStatement pps = null;
        Statement st = null;
        Connection con = null;
        
        try{
            con = DriverManager.getConnection(URL,USER,PASS);
            pps = con.prepareStatement(sql);
            int id=(int) Math.floor(Math.random()*(99999-2+1)+2);
            pps.setInt(1, id);
            pps.setFloat(2, compra.getMonto_total());
            pps.setString(3, compra.getDireccion());
            pps.setInt(4,0);
            pps.setInt(5, compra.getId_cliente());
           
            
            pps.executeUpdate();
            
            sql="DELETE FROM Productocompra WHERE id_carrito ='"+compra.getId_cliente()+"'";
            pps = con.prepareStatement(sql);
            pps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(ConsultaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
                Logger.getLogger(ConsultaCarrito.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
    }
}
