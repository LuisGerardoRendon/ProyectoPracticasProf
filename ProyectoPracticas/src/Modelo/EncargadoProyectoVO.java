/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Objects;

/**
 * 
 * @author Aldo
 */
public class EncargadoProyectoVO {
    private String idEncargadoProyecto;
    private String nombre, cargo, correoElectronico;

    public EncargadoProyectoVO() {
    }

    public EncargadoProyectoVO(String idEncargadoProyecto, String nombre, String cargo, String correoElectronico) {
        this.idEncargadoProyecto = idEncargadoProyecto;
        this.nombre = nombre;
        this.cargo = cargo;
        this.correoElectronico = correoElectronico;
    }

    public EncargadoProyectoVO(String nombre, String cargo, String correoElectronico) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.correoElectronico = correoElectronico;
    }

    public String getIdEncargadoProyecto() {
        return idEncargadoProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setIdEncargadoProyecto(String idEncargadoProyecto) {
        this.idEncargadoProyecto = idEncargadoProyecto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EncargadoProyectoVO other = (EncargadoProyectoVO) obj;
        if (!Objects.equals(this.idEncargadoProyecto, other.idEncargadoProyecto)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "EncargadoProyectoVO{" + "idEncargadoProyecto=" + idEncargadoProyecto + ", nombre=" + nombre + ", cargo=" + cargo + ", correoElectronico=" + correoElectronico + '}';
    }
}
