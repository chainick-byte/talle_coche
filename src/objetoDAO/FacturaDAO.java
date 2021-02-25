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
import modelos.Factura;
import utiles.Conexion;

/**
 *
 * @author igorr
 */
public class FacturaDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List dameTodo() {
        List<Factura> miLista = new ArrayList<>();
        String sql = "select * from factura";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();
                f.setId_factura(rs.getInt(1));
                f.setFecha_emision(rs.getDate(2));
                f.setAuto_id(rs.getInt(3));
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
        System.out.println("no tiene ningun sentido actualizar factura");
        return 1;
    }

    @Override
    public int guardar(Object[] o) {
        int respuesta = 0;
        String sql = "insert into factura values(null,NOW(),?)";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, o[0]);
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return respuesta;
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from factura where id_factura=?";
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

    public int dameIdFactura(int id_auto) {
        int id_factura = 0;
        String sql = "select * from factura where auto_id=? order by fecha_emision DESC limit 1";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id_auto);
            rs = ps.executeQuery();
            if (rs.next()) {
                Factura f = new Factura();
                id_factura = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());

        }
        return id_factura;
    }
}
