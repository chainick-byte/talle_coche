/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;


/**
 *
 * @author igorr
 */
public class Factura {
    
    private int id_factura;
    private Date fecha_emision;
    private int auto_id;

    public Factura() {
    }

    public Factura(int id_factura, Date fecha_emision, int auto_id) {
        this.id_factura = id_factura;
        this.fecha_emision = fecha_emision;
        this.auto_id = auto_id;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }
    
    
    
}
