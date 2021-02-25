/*
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
import modelos.Operacion;
import utiles.Conexion;

/**
 *
 * @author igorr
 */
public class OperacionDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List dameTodo() {
        List<Operacion> miLista = new ArrayList<>();
        String sql = "select * from operacion;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Operacion o = new Operacion();
                o.setId_operacion(rs.getInt(1));
                o.setNombre_operacion(rs.getString(2));
                o.setPrecio(rs.getFloat(3));
                miLista.add(o);
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
        String sql = "update operacion set nombre_operacion=?,precio=? where id_operacion=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
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
        String sql = "insert into operacion values(null,?,?)";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return respuesta;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from operacion where id_operacion=?";
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

}
