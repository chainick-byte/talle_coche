/*n 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Propietario;
import utiles.Conexion;

/**
 *
 * @author igorr
 */
public class PropietarioDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    public int dameIdpropietarioRegistrado(String dni, int numero) {
        int resultado = 0;
        String sql = "select p.id_propietario from propietario p where p.dni=? and p.telefono=?;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, dni);
            ps.setObject(2, numero);
            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = rs.getInt(1);
                System.out.println("==========>" + resultado);
            }
            conexion.close();
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public List dameTodo() {
        List<Propietario> miLista = new ArrayList<>();
        String sql = "SELECT * FROM propietario;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propietario p = new Propietario();
                p.setId_propietario(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrimer_apellido(rs.getString(3));
                p.setSegundo_apellido(rs.getString(4));
                p.setDni(rs.getString(5));
                p.setNumero(rs.getInt(6));
                miLista.add(p);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    @Override
    public int actualizar(Object[] o) {
        int respuesta = 0;
        String sql = "update propietario p set p.nombre=?,p.primer_apellido=?, "
                + "p.segundo_apellido=?,p.dni=?,p.telefono=? where p.id_propietario=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return respuesta;
    }

    @Override
    public int guardar(Object[] o) {
        int respuesta = 0;
        String sql = "insert into propietario values(emp_sequence_propietario.nextval,?,?,?,?,?)";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return respuesta;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from propietario p where p.id_propietario=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List damePropietarioPorDNI(String DNI) {
        List<Propietario> miLista = new ArrayList<>();
        String sql = "select * from  propietario p where p.dni=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, DNI);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propietario p = new Propietario();
                p.setId_propietario(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrimer_apellido(rs.getString(3));
                p.setSegundo_apellido(rs.getString(4));
                p.setDni(rs.getString(5));
                p.setNumero(rs.getInt(6));
                miLista.add(p);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    public List damePropietarioPorTelefono(int telefono) {
        List<Propietario> miLista = new ArrayList<>();
        String sql = " select * from propietario p where p.telefono = ?;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, telefono);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propietario p = new Propietario();
                p.setId_propietario(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrimer_apellido(rs.getString(3));
                p.setSegundo_apellido(rs.getString(4));
                p.setDni(rs.getString(5));
                p.setNumero(rs.getInt(6));
                miLista.add(p);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    public List<Propietario> damePropietarioPorId(int id_propietario) {
        List<Propietario>miLista=new ArrayList<>();
        String sql = "select *from propietario p where p.id_propietario=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id_propietario);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propietario p = new Propietario();
                p.setId_propietario(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrimer_apellido(rs.getString(3));
                p.setSegundo_apellido(rs.getString(4));
                p.setDni(rs.getString(5));
                p.setNumero(rs.getInt(6));
                miLista.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }
}
