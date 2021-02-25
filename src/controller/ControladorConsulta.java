/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Consulta;
import objetoDAO.ConsultaDAO;

/**
 *
 * @author igorr
 */
public class ControladorConsulta {

    DefaultTableModel miModelo = new DefaultTableModel();
    ConsultaDAO miConsulta = new ConsultaDAO();
    Consulta a = new Consulta();

    public void guardarConsulta(int id_propietario, String matricula, String descripcion_averia,
            String modelo, int anno) {
        int resultado = 0;
        Object[] o = new Object[5];
        o[0] = id_propietario;
        o[1] = matricula;
        o[2] = descripcion_averia;
        o[3] = modelo;
        o[4] = anno;
        try {
            resultado = miConsulta.guardar(o);
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "se ha registrado vehiculo");
            } else {
                JOptionPane.showMessageDialog(null, "algo ha ido mal!!");
            }
        } catch (HeadlessException e) {
            System.out.println(e.getMessage());
        }

    }

    public void actualizarConsulta(int id_propietario, String matricula,
            String descripcion_averia, String modelo, int anno, int id_auto) {
        Object[] o = new Object[6];
        o[0] = id_propietario;
        o[1] = matricula;
        o[2] = descripcion_averia;
        o[3] = modelo;
        o[4] = anno;
        o[5] = id_auto;
        miConsulta.actualizar(o);
    }

    public DefaultTableModel dameTablaAutoDePropietario(JTable tablaConsulta, int id_propietario) {
        List<Consulta> miLista = miConsulta.dameAutoPorId(id_propietario);
        hazmeModeloTabla(miLista, tablaConsulta);

        return miModelo;
    }

    public void hazmeModeloTabla(List<Consulta> miLista, JTable tablaConsulta) {
        miModelo = (DefaultTableModel) tablaConsulta.getModel();
        Object[] o = new Object[6];
        for (int i = 0; i < miLista.size(); i++) {
            o[0] = miLista.get(i).getId_auto();
            o[1] = miLista.get(i).getMatricula();
            o[2] = miLista.get(i).getDescripcion_averia();
            o[3] = miLista.get(i).getModelo();
            o[4] = miLista.get(i).getAnno();
            o[5] = miLista.get(i).isEstado();
            miModelo.addRow(o);
        }
    }

    public void borrameConsulta(int id_auto) {
        miConsulta.eliminar(id_auto);
    }

    public void limpiarTabla() {
        for (int i = 0; i < miModelo.getRowCount(); i++) {
            miModelo.removeRow(i);
            i = i - 1;
        }
    }

    public DefaultTableModel buscarPorAnno(JTable tablaConsulta, int anno, int propietario_id) {
        List<Consulta> miLista = miConsulta.damePorAnno(anno, propietario_id);
        hazmeModeloTabla(miLista, tablaConsulta);
        return miModelo;
    }

    public DefaultTableModel buscarPorModelo(JTable tablaConsulta, String modelo, int propietario_id) {
        List<Consulta> miLista = miConsulta.damePorModelo(modelo, propietario_id);
        hazmeModeloTabla(miLista, tablaConsulta);
        return miModelo;
    }

    public DefaultTableModel buscarPorMatricula(JTable tablaConsulta, String marca, int propietario_id) {
        List<Consulta> miLista = miConsulta.damePorMatricula(marca, propietario_id);
        hazmeModeloTabla(miLista, tablaConsulta);
        return miModelo;
    }

    public List<Consulta> dameConsultaPorId(int id_auto) {
        List<Consulta> miLista = miConsulta.dameCochePorId(id_auto);
        return miLista;
    }

    public void finalizarConsulta(int id_auto) {

        miConsulta.actualizarEstado(id_auto);
    }

}
