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
import modelos.FacturaOperacion;
import utiles.Conexion;

/**
 *
 * @author igorr
 */
public class FacturaOperacionDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List dameTodo() {
        List<FacturaOperacion> miLista = new ArrayList<>();
        String sql = "select * from factura_operacion;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                FacturaOperacion f = new FacturaOperacion();
                f.setId_factura_operacion(rs.getInt(1));
                f.setOperacion_id(rs.getInt(2));
                f.setCantidad(rs.getInt(3));
                miLista.add(f);
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
        String sql = "update factura_operacion set cantidad=? where factura_id=? and operacion=?";
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
        String sql = "insert into  factura_operacion values(null, ?, ?, ?)";
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
    public void eliminar(int id) {
        String sql = "delete from factura_operacion where id_factura_operacion=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id);
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage()
            );
        }
    }

}
