/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendedor.persisitencia;

/**
 *
 * @author willm
 */
public class ImagenAlmacen {
    private int imagen_id;
    private String titulo;
    private byte [] imagen;

    public int getImagen_id() {
        return imagen_id;
    }

    public void setImagen_id(int imagen_id) {
        this.imagen_id = imagen_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}
