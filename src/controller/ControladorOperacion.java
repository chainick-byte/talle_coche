/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Operacion;
import objetoDAO.OperacionDAO;

/**
 *
 * @author igorr
 */
public class ControladorOperacion {

    OperacionDAO miOperacionDAO = new OperacionDAO();
    DefaultTableModel miModelo = new DefaultTableModel();

    public DefaultTableModel dameTodasOperaciones(JTable tablaTodasOperaciones) {
        List<Operacion> miLIsta = miOperacionDAO.dameTodo();
        hazmeModeloTabla(miLIsta, tablaTodasOperaciones);
        return miModelo;
    }

    public void hazmeModeloTabla(List<Operacion> miLista, JTable tablaConsulta) {
        miModelo = (DefaultTableModel) tablaConsulta.getModel();
        Object[] o = new Object[6];
        for (int i = 0; i < miLista.size(); i++) {
            o[0] = miLista.get(i).getId_operacion();
            o[1] = miLista.get(i).getNombre_operacion();
            o[2] = miLista.get(i).getPrecio();

            miModelo.addRow(o);
        }
    }

    public void gurdarNuevaOperacion(String descripcion_operacion, float precio) {

        Object[] o = new Object[5];
        o[0] = descripcion_operacion;
        o[1] = precio;
        miOperacionDAO.guardar(o);
    }

    public void limpiarTabla() {
        for (int i = 0; i < miModelo.getRowCount(); i++) {
            miModelo.removeRow(i);
            i = i - 1;
        }
    }

    public void eliminar(int id_operacion) {
        miOperacionDAO.eliminar(id_operacion);
    }

    public void actualizaOperacion(String nombre_operacion, float precio, int id_operacion) {
        Object[] o = new Object[3];
        o[0]=nombre_operacion;
        o[1]=precio;
        o[2]=id_operacion;
        miOperacionDAO.actualizar(o);

    }
}
