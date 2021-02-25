/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.FacturaOperacionOperacion;
import objetoDAO.CRUD;
import objetoDAO.FacturaOPeracionOperacionDAO;
import objetoDAO.FacturaOperacionDAO;

/**
 *
 * @author igorr
 */
public class ControladorFacturaOperacion implements CRUD{

    FacturaOperacionDAO miFacturaOperacionDAO = new FacturaOperacionDAO();
    FacturaOPeracionOperacionDAO miFacturaOPeracionOperacionDAO=
            new FacturaOPeracionOperacionDAO();
    DefaultTableModel miModelo = new DefaultTableModel();

    public void guardaOperacionFatura(int factura_id, int id_operacion, int cantidad) {
        Object[] o = new Object[3];
        o[0] = factura_id;
        o[1] = id_operacion;
        o[2] = cantidad;
        miFacturaOperacionDAO.guardar(o);
    }
    
    public DefaultTableModel dameRegistroDeOperacionRealizadas(JTable tablaOperaciones,
            int id_factua){
        List <FacturaOperacionOperacion>miLista=
                miFacturaOPeracionOperacionDAO.dameTodoPorIdFactura(id_factua);
        hazmeModeloTabla(miLista, tablaOperaciones);
        return miModelo;
    }

    private void hazmeModeloTabla(List<FacturaOperacionOperacion> miLista, JTable tablaOperaciones) {
        miModelo = (DefaultTableModel) tablaOperaciones.getModel();
        Object[] o = new Object[5];
        for (int i = 0; i < miLista.size(); i++) {
            o[0] = miLista.get(i).getId_operacion();
            o[1] = miLista.get(i).getNombre_operacion();
            o[2] = miLista.get(i).getCantidad();
            o[3] = miLista.get(i).getPrecio();
            o[4] = miLista.get(i).getCantidad()*(miLista.get(i).getPrecio());

            miModelo.addRow(o);
        }
    }

    @Override
    public List dameTodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int guardar(Object[] o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
    miFacturaOperacionDAO.eliminar(id);
    
    }
  

    public void limpiarTabla() {
        for (int i = 0; i < miModelo.getRowCount(); i++) {
            miModelo.removeRow(i);
            i = i - 1;
        }
    }

}
