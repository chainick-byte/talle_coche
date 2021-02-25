/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author igorr
 */
public class Consulta {
    
    private int id_auto;
    private int propietario_id;
    private String matricula;
    private String descripcion_averia;
    private String modelo;
    private int anno;
    private boolean estado;

    public Consulta() {
    }

    public Consulta(int id_auto, int propietario_id, String matricula, String descripcion_averia, String modelo, int anno,boolean estado) {
        this.id_auto = id_auto;
        this.propietario_id = propietario_id;
        this.matricula = matricula;
        this.descripcion_averia = descripcion_averia;
        this.modelo = modelo;
        this.anno = anno;
        this.estado=estado;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public int getPropietario_id() {
        return propietario_id;
    }

    public void setPropietario_id(int propietario_id) {
        this.propietario_id = propietario_id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion_averia() {
        return descripcion_averia;
    }

    public void setDescripcion_averia(String descripcion_averia) {
        this.descripcion_averia = descripcion_averia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
