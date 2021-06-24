/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.image.BufferedImage;

/**
 *
 * @author Leonel
 */
public class Repartidor {
    private int id_repartidor;
    private String nombre_completo;
    private String contrasena;
    private String username;
    private String telefono;
    private String direccion;
    private String email;
    private String vehiculo;
    private BufferedImage foto;
    
    public Repartidor(){
        
    }
    /**
     * 
     * @param id_repartidor
     * @param nombre_completo
     * @param contrasena
     * @param username
     * @param telefono
     * @param direccion
     * @param email
     * @param vehiculo
     * @param foto 
     */
    public Repartidor(int id_repartidor,String nombre_completo,String contrasena,String username,String telefono,String direccion,String email,String vehiculo,BufferedImage foto){
        this.id_repartidor=id_repartidor;
        this.nombre_completo=nombre_completo;
        this.username=username;
        this.contrasena=contrasena;
        this.telefono=telefono;
        this.direccion=direccion;
        this.email=email;
        this.vehiculo=vehiculo;
        this.foto=foto;
    }

    public int getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(int id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public BufferedImage getFoto() {
        return foto;
    }

    public void setFoto(BufferedImage foto) {
        this.foto = foto;
    }

    

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
