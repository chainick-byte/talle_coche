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
import modelos.Consulta;
import utiles.Conexion;

/**
 *
 * @author igorr
 */
public class ConsultaDAO implements CRUD {

    Connection conexion;
    PreparedStatement ps;
    ResultSet rs;

    public List damePorAnno(int anno, int propietario_id) {
        List<Consulta> miLista = new ArrayList<>();
        String sql = "select * from consulta c where c.anno=? and c.propietario_id=(SELECT REF(p) FROM propietario p where p.id_propietario=?)";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, anno);
            ps.setObject(2, propietario_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setId_auto(rs.getInt(1));
                a.setPropietario_id(rs.getInt(2));
                a.setMatricula(rs.getString(3));
                a.setDescripcion_averia(rs.getString(4));
                a.setModelo(rs.getString(5));
                a.setAnno(rs.getInt(6));
                a.setEstado(rs.getBoolean(7));
                miLista.add(a);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    @Override
    public List dameTodo() {
        List<Consulta> miLista = new ArrayList<>();
        String sql = "SELECT  c.id_consulta,c.matricula,c.descripcion , c.modelo,c.anno, c.estado FROM consulta c ;";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setId_auto(rs.getInt(1));
                a.setPropietario_id(rs.getInt(2));
                a.setMatricula(rs.getString(3));
                a.setDescripcion_averia(rs.getString(4));
                a.setModelo(rs.getString(5));
                a.setAnno(rs.getInt(6));
                a.setEstado(rs.getBoolean(7));
                miLista.add(a);
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
        String sql = "update consulta c set c.propietario_id=?,  c.matricula=?,  c.modelo=?, c.anno=?,c.estado='n' where c.id_auto=?";
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
        String sql = "insert into consulta c values(seq_consulta.nextval,(select ref(p)from propietario p where p.id_propietario=?),?,?, ?,?);;";
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
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "delete from consulta c where c.id_auto=?";
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

    public List<Consulta> dameAutoPorId(int id_propietario) {
        List<Consulta> miLista = new ArrayList<>();
        String sql = "select c.id_auto,c.propietario.id_propietario, c.matricula,c.modelo,c.anno,c.estado from consulta c where c.propietario.id_propietario=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id_propietario);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setId_auto(rs.getInt(1));
                a.setPropietario_id(rs.getInt(2));
                a.setMatricula(rs.getString(3));
                a.setDescripcion_averia(rs.getString(4));
                a.setModelo(rs.getString(5));
                a.setAnno(rs.getInt(6));
                a.setEstado(rs.getBoolean(7));
                miLista.add(a);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    public List<Consulta> damePorMatricula(String matricula, int propietario_id) {
        List<Consulta> miLista = new ArrayList<>();
        String sql = "select * from consulta where matricula=? and propietario_id=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, matricula);
            ps.setObject(2, propietario_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setId_auto(rs.getInt(1));
                a.setPropietario_id(rs.getInt(2));
                a.setMatricula(rs.getString(3));
                a.setDescripcion_averia(rs.getString(4));
                a.setModelo(rs.getString(5));
                a.setAnno(rs.getInt(6));
                a.setEstado(rs.getBoolean(7));
                miLista.add(a);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    public List<Consulta> damePorModelo(String modelo, int propietario_id) {
        List<Consulta> miLista = new ArrayList<>();
        String sql = "select * from consulta where modelo=? and propietario_id=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, modelo);
            ps.setObject(2, propietario_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setId_auto(rs.getInt(1));
                a.setPropietario_id(rs.getInt(2));
                a.setMatricula(rs.getString(3));
                a.setDescripcion_averia(rs.getString(4));
                a.setModelo(rs.getString(5));
                a.setAnno(rs.getInt(6));
                a.setEstado(rs.getBoolean(7));
                miLista.add(a);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    public List<Consulta> dameCochePorId(int id_auto) {
        List<Consulta> miLista = new ArrayList<>();
        String sql = "select * from consulta where id_auto=?";
        try {
            conexion = new Conexion().getConexion();
            ps = conexion.prepareStatement(sql);
            ps.setObject(1, id_auto);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setId_auto(rs.getInt(1));
                a.setPropietario_id(rs.getInt(2));
                a.setMatricula(rs.getString(3));
                a.setDescripcion_averia(rs.getString(4));
                a.setModelo(rs.getString(5));
                a.setAnno(rs.getInt(6));
                a.setEstado(rs.getBoolean(7));
                miLista.add(a);
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    }

    public void actualizarEstado(int id_auto) {
        String sql = "update consulta c set estado='y' where c.id_auto=?";
        try {
            conexion=new Conexion().getConexion();
            ps=conexion.prepareStatement(sql);
            ps.setObject(1, id_auto);
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
