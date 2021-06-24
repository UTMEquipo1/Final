/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Vendedor.persisitencia.EditarP;
import static Vendedor.persisitencia.EditarP.idvende;
import Vendedor.persisitencia.EditarV;
import Vendedor.persisitencia.Inventario;
import static Vendedor.persisitencia.Inventario.idvende;
import Vendedor.persisitencia.RenderImagen;
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
public class Vendedor {
    public static String Nombrev;
    public static Integer Idvendedor;
    public static String Contrasena;
    public static String Telefono;
    public static String Direccion;
    public static String Email;
    public static String Tipo_negocio;
    public static String Nombre_negocio;
    public static ArrayList<Producto> tablainventario=  new ArrayList();
    /**
     * 
     * @return 
     */
    public static String getNombrev() {
        return Nombrev;
    }

    public Vendedor() {
    }
    public Vendedor(String nombre, String contrasena,String Telefono,String Direccion,String Email, String Tipo_negocio, String Nombre_negocio,ArrayList<Producto> Tabla) {
        this.Nombrev=nombre;
        this.Idvendedor=(int) Math.floor(Math.random()*(99999-2+1)+2);
        this.Contrasena=contrasena;
        this.Telefono=Telefono;
        this.Direccion=Direccion;
        this.Email=Email;
        this.Tipo_negocio=Tipo_negocio;
        this.Nombre_negocio=Nombre_negocio;
        this.tablainventario= Tabla;
    }
    /**
     * 
     * @param Nombrev 
     */
    public static void setNombrev(String Nombrev) {
        Vendedor.Nombrev = Nombrev;
    }

    public static Integer getIdvendedor() {
        return Idvendedor;
    }

    public static void setIdvendedor(Integer Idvendedor) {
        Vendedor.Idvendedor = Idvendedor;
    }

    public static String getContrasena() {
        return Contrasena;
    }

    public static void setContrasena(String Contrasena) {
        Vendedor.Contrasena = Contrasena;
    }

    public static String getTelefono() {
        return Telefono;
    }

    public static void setTelefono(String Telefono) {
        Vendedor.Telefono = Telefono;
    }

    public static String getDireccion() {
        return Direccion;
    }

    public static void setDireccion(String Direccion) {
        Vendedor.Direccion = Direccion;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        Vendedor.Email = Email;
    }

    public static String getTipo_negocio() {
        return Tipo_negocio;
    }

    public static void setTipo_negocio(String Tipo_negocio) {
        Vendedor.Tipo_negocio = Tipo_negocio;
    }

    public static String getNombre_negocio() {
        return Nombre_negocio;
    }

    public static void setNombre_negocio(String Nombre_negocio) {
        Vendedor.Nombre_negocio = Nombre_negocio;
    }

    public static ArrayList<Producto> getTablainventario() {
        return tablainventario;
    }

    public static void setTablainventario(ArrayList<Producto> tablainventario) {
        Vendedor.tablainventario = tablainventario;
    }
    /**
     * 
     * @throws SQLException 
     */
    public void EditarPerfil(String nom, String Dir,String User, String contra, String tel,String email, String tipo, String nego ,String ruta){
        String DB="XcRj6qcf4U";
        String URL="jdbc:mysql://remotemysql.com:3306/XcRj6qcf4U";
        String USER="XcRj6qcf4U";
        String PASS="p3SRSqI4Za";
        PreparedStatement pps = null;
        Statement st = null;
        
        Connection con = null;
        FileInputStream fi= null;
        
        
        try{
            File file = new File(ruta);
            fi= new FileInputStream(file);
            
            con = DriverManager.getConnection(URL,USER,PASS);
            pps = con.prepareStatement("UPDATE Vendedor SET Nombre_completo='"+nom+"',Contrasena='"+contra+"',Username='"+User+"',Telefono='"+tel+"',Direccion='"+Dir+"',Email='"+email+"',Tipo_negocio='"+tipo+"',Nombre_negocio='"+nego+"',Imagenv='"+fi+"'WHERE ID_Vendedor='"+Idvendedor+"'");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Actualizados");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EditarV.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Selecciona una imagen");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditarP.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
    }
    
    
    
}
