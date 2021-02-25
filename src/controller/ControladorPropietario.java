/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Propietario;
import objetoDAO.PropietarioDAO;
import vista.iAddAuto;

/**
 *
 * @author igorr
 */
public class ControladorPropietario {

    DefaultTableModel miModelo = new DefaultTableModel();

    PropietarioDAO p = new PropietarioDAO();

    public int guardaUsuario(String nombre, String primerApellido, String SegundoApellido, String DNI, int numero) {
        int resultado = 0;
        Object[] o = new Object[5];
        o[0] = nombre;
        o[1] = primerApellido;
        o[2] = SegundoApellido;
        o[3] = DNI;
        o[4] = numero;
        resultado = p.guardar(o);

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "has registrador un nuevo propietario");
            int id_propietario = p.dameIdpropietarioRegistrado(DNI, numero);
            iAddAuto aa = new iAddAuto(id_propietario);
            aa.setVisible(true);
            return 1;
        } else {
            JOptionPane.showMessageDialog(null, "repite, por favor!! algo ha ido mal!!!");
            return -1;
        }

    }

    public DefaultTableModel dameTablaUsuarios(JTable tablaPropietario) {
        List<Propietario> miLista = p.dameTodo();
        miModelo = (DefaultTableModel) tablaPropietario.getModel();
        Object[] o = new Object[6];
        for (int i = 0; i < miLista.size(); i++) {
            o[0] = miLista.get(i).getId_propietario();
            o[1] = miLista.get(i).getNombre();
            o[2] = miLista.get(i).getPrimer_apellido();
            o[3] = miLista.get(i).getSegundo_apellido();
            o[4] = miLista.get(i).getDni();
            o[5] = miLista.get(i).getNumero();

            miModelo.addRow(o);
        }

        return miModelo;
    }

    public void actualizarPropietario(String nombre, String primerApellido,
            String SegundoApellido, String DNI, int numero, int id_propietario) {
        Object[] o = new Object[6];
        o[0] = nombre;
        o[1] = primerApellido;
        o[2] = SegundoApellido;
        o[3] = DNI;
        o[4] = numero;
        o[5] = id_propietario;
        p.actualizar(o);
    }

    public void limpiarTabla() {
        for (int i = 0; i < miModelo.getRowCount(); i++) {
            miModelo.removeRow(i);
            i = i - 1;
        }
    }

    public void borramePropietario(int id_propietario) {
        p.eliminar(id_propietario);
    }

    public DefaultTableModel muestrameResultadoBusquedaDNI(JTable tablaPropietario,String DNI) {
        List<Propietario> miLista = p.damePropietarioPorDNI(DNI);
        miModelo = (DefaultTableModel) tablaPropietario.getModel();
        Object[] o = new Object[6];
        for (int i = 0; i < miLista.size(); i++) {
            o[0] = miLista.get(i).getId_propietario();
            o[1] = miLista.get(i).getNombre();
            o[2] = miLista.get(i).getPrimer_apellido();
            o[3] = miLista.get(i).getSegundo_apellido();
            o[4] = miLista.get(i).getDni();
            o[5] = miLista.get(i).getNumero();

            miModelo.addRow(o);
        }

        return miModelo;
    }
    public DefaultTableModel muestrameResultadoBusquedaTelefono(JTable tablaPropietario,String telefono) {
        int tel=Integer.parseInt(telefono);
        List<Propietario> miLista = p.damePropietarioPorTelefono(tel);
        miModelo = (DefaultTableModel) tablaPropietario.getModel();
        Object[] o = new Object[6];
        for (int i = 0; i < miLista.size(); i++) {
            o[0] = miLista.get(i).getId_propietario();
            o[1] = miLista.get(i).getNombre();
            o[2] = miLista.get(i).getPrimer_apellido();
            o[3] = miLista.get(i).getSegundo_apellido();
            o[4] = miLista.get(i).getDni();
            o[5] = miLista.get(i).getNumero();

            miModelo.addRow(o);
        }

        return miModelo;
    }

    public List damePropietarioPorId(int id_propietario) {
        List<Propietario>miLista=p.damePropietarioPorId(id_propietario);
        return miLista;
    }
}
