/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author igorr
 */
public class Operacion {
    
    private int id_operacion;
    private String nombre_operacion;
    private float precio;

    public Operacion() {
    }

    public Operacion(int id_operacion, String nombre_operacion, float precio) {
        this.id_operacion = id_operacion;
        this.nombre_operacion = nombre_operacion;
        this.precio = precio;
    }

    public int getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public String getNombre_operacion() {
        return nombre_operacion;
    }

    public void setNombre_operacion(String nombre_operacion) {
        this.nombre_operacion = nombre_operacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }



}
