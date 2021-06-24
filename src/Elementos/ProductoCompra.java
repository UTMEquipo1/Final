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
public class ProductoCompra {
    private String nombre_producto;
    private int id_carrito;
    private float precio;
    private float cantidad;
    private int id_productocompra;
    
    public ProductoCompra(){
        
    }
    public ProductoCompra(String nombre_producto,int id_carrito,float precio,float cantidad,int id_productocompra){
        this.nombre_producto=nombre_producto;
        this.id_carrito=id_carrito;
        this.precio=precio;
        this.cantidad=cantidad;
        this.id_productocompra=id_productocompra;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_productocompra() {
        return id_productocompra;
    }

    public void setId_productocompra(int id_productocompra) {
        this.id_productocompra = id_productocompra;
    }
}
