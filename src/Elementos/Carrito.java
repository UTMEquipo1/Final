/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.ArrayList;

/**
 * Clase que guarda la información del carrito. Su función es ligar la compra con los productos que se compraron.
 * @author Leonel
 */
public class Carrito {
    private int id_carrito;
    private int id_compra;
    private ArrayList<Producto> listaProductos;
    
    public Carrito(){
        
    }
    
    public Carrito(int id_carrito,int id_compra,ArrayList<Producto> listaProductos){
        this.id_carrito=id_carrito;
        this.id_compra=id_compra;
        this.listaProductos=listaProductos;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
}
