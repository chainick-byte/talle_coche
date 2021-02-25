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
import modelos.FacturaOperacionOperacion;
import utiles.Conexion;

/**
 *
 * @author igorr
 */
public class FacturaOPeracionOperacionDAO {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    public List dameTodoPorIdFactura(int id_factura) {
        List<FacturaOperacionOperacion> miLista = new ArrayList<>();
        String sql = "select fo.id_factura_operacion,o.nombre_operacion, "
                + "fo.cantidad,o.precio from factura_operacion as fo,operacion as o,"
                + "factura as f where f.id_factura=fo.factura_id and "
                + "fo.operacion=o.id_operacion and f.id_factura=?;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_factura);
            rs = ps.executeQuery();
            while (rs.next()) {
                FacturaOperacionOperacion foo = new FacturaOperacionOperacion();
                foo.setId_operacion(rs.getInt(1));
                foo.setNombre_operacion(rs.getString(2));
                foo.setCantidad(rs.getInt(3));
                foo.setPrecio(rs.getFloat(4));
                miLista.add(foo);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    public void eleminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
