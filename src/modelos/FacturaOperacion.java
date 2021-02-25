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
public class FacturaOperacion {
    private int id_factura_operacion;
    private int operacion_id;
    private int cantidad;

    public FacturaOperacion() {
    }

    public FacturaOperacion(int id_factura_operacion,  int operacion_id, int cantidad) {
        this.id_factura_operacion = id_factura_operacion;
        this.operacion_id = operacion_id;
        this.cantidad = cantidad;
    }

    public int getId_factura_operacion() {
        return id_factura_operacion;
    }

    public void setId_factura_operacion(int id_factura_operacion) {
        this.id_factura_operacion = id_factura_operacion;
    }


    public int getOperacion_id() {
        return operacion_id;
    }

    public void setOperacion_id(int operacion_id) {
        this.operacion_id = operacion_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
