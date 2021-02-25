/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import objetoDAO.FacturaDAO;

/**
 *
 * @author igorr
 */
public class ControladorFactura {

    

    FacturaDAO miFacturaDAO = new FacturaDAO();

    public void guardaFactura(int id_auto) {
        Object[] o = new Object[1];
        o[0] = id_auto;
        miFacturaDAO.guardar(o);

    }

    public int dameIdFactura(int id_auto) {
        int id_factura = miFacturaDAO.dameIdFactura(id_auto);
        return id_factura;
    }
    
   

}
