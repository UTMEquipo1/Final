/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;


import Frame.AnadirTarjeta;
import Vendedor.persisitencia.AnadirV2;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonel
 */
public class Tarjeta {
    private String nombre;
    private String num_tarjeta;
    private String fecha_vencimiento;
    private int numeros_seguridad;
    private int id_cliente;
    
    public Tarjeta(){
        
    }
    
    public Tarjeta(int id_cliente,String nombre,String num_tarjeta,String fecha_vencimiento,int numeros_seguridad){
        this.nombre=nombre;
        this.num_tarjeta=num_tarjeta;
        this.fecha_vencimiento=fecha_vencimiento;
        this.numeros_seguridad=numeros_seguridad;
        this.id_cliente=id_cliente;
    }

    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getNumeros_seguridad() {
        return numeros_seguridad;
    }

    public void setNumeros_seguridad(int numeros_seguridad) {
        this.numeros_seguridad = numeros_seguridad;
    }
    
    public void AnadirTarjeta(int id_cliente,String nombre,String num_tarjeta,String fecha_vencimiento,int numeros_seguridad){
        String DB="XcRj6qcf4U";
        String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
        String USER="XcRj6qcf4U";
        String PASS="p3SRSqI4Za";
        
        PreparedStatement pps = null;
        Statement st = null;
        
        Connection con = null;
        
       try {            
            con = DriverManager.getConnection(URL,USER,PASS);
            pps = con.prepareStatement("INSERT INTO Tarjeta VALUES(?,?,?,?,?)");
            pps.setString(1, nombre);
            pps.setString(2,num_tarjeta);
            pps.setString(3,fecha_vencimiento);
            pps.setInt(4, numeros_seguridad);
            pps.setInt(5,id_cliente);
            
            pps.executeUpdate();
                       
        }catch (SQLException ex) {
            Logger.getLogger(AnadirTarjeta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al guardar");
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
                Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
        
    }

    public void EliminarTarjeta(int id_cliente)throws SQLException{
        Connection con = null;
        PreparedStatement pps = null;
        String DB="XcRj6qcf4U";
        String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
        String USER="XcRj6qcf4U";
        String PASS="p3SRSqI4Za";

        String sql = "DELETE FROM Tarjeta WHERE id_cliente="+id_cliente;
        
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();    
        con = DriverManager.getConnection(URL,USER,PASS);
        pps = con.prepareStatement(sql);
        pps.executeUpdate();
        
        }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pps != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, sqle);
            }
        
        }
        
        
    }
    
}
