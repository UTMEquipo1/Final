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
public class Compra {
    private int id_compra;
    private float monto_total;
    private String direccion;
    private int id_repartidor;
    private int id_cliente;
    
    public Compra(){
        
    }
    
    public Compra(int id_compra,float monto_total,String direccion,int id_repartidor){
        this.id_compra=id_compra;
        this.monto_total=monto_total;
        this.direccion=direccion;
        this.id_repartidor=id_repartidor;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(float monto_total) {
        this.monto_total = monto_total;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(int id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void consultaDireccion(){
        
    }
}
