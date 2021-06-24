/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author Leonel
 */
public class Cliente {
    private int id_cliente;
    private String nombre_completo;
    private String contrasena;
    private String username;
    private String telefono;
    private String direccion;
    private String email;
    
    public Cliente(){
        
    }
    
    public Cliente(int id_cliente,String nombre_completo,String contrasena,String username,String telefono,String direccion,String email){
        this.id_cliente=id_cliente;
        this.nombre_completo=nombre_completo;
        this.username=username;
        this.contrasena=contrasena;
        this.telefono=telefono;
        this.direccion=direccion;
        this.email=email;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
