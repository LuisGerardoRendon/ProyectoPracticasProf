/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author ALDO
 */
public class AsignacionVO {
  private int idAsignacion;
  private String preriodo;
  private String nrcCurso;
  private float progreso;
  private int idProyecto;
  private String matriculaProfesor;
  private String matriculaEstudiante;

    public AsignacionVO(int idAsignacion, String preriodo, String nrcCurso, float progreso, int idProyecto, String matriculaProfesor, String matriculaEstudiante) {
        this.idAsignacion = idAsignacion;
        this.preriodo = preriodo;
        this.nrcCurso = nrcCurso;
        this.progreso = progreso;
        this.idProyecto = idProyecto;
        this.matriculaProfesor = matriculaProfesor;
        this.matriculaEstudiante = matriculaEstudiante;
    }
    
     public AsignacionVO( String preriodo, String nrcCurso, float progreso, int idProyecto, String matriculaProfesor, String matriculaEstudiante) {
   
        this.preriodo = preriodo;
        this.nrcCurso = nrcCurso;
        this.progreso = progreso;
        this.idProyecto = idProyecto;
        this.matriculaProfesor = matriculaProfesor;
        this.matriculaEstudiante = matriculaEstudiante;
        this.idAsignacion =0;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
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
        final AsignacionVO other = (AsignacionVO) obj;
        if (this.idAsignacion != other.idAsignacion) {
            return false;
        }
        if (Float.floatToIntBits(this.progreso) != Float.floatToIntBits(other.progreso)) {
            return false;
        }
        if (this.idProyecto != other.idProyecto) {
            return false;
        }
        if (!Objects.equals(this.preriodo, other.preriodo)) {
            return false;
        }
        if (!Objects.equals(this.nrcCurso, other.nrcCurso)) {
            return false;
        }
        if (!Objects.equals(this.matriculaProfesor, other.matriculaProfesor)) {
            return false;
        }
        if (!Objects.equals(this.matriculaEstudiante, other.matriculaEstudiante)) {
            return false;
        }
        return true;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public String getPreriodo() {
        return preriodo;
    }

    public String getNrcCurso() {
        return nrcCurso;
    }

    public float getProgreso() {
        return progreso;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public String getMatriculaProfesor() {
        return matriculaProfesor;
    }

    public String getMatriculaEstudiante() {
        return matriculaEstudiante;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public void setPreriodo(String preriodo) {
        this.preriodo = preriodo;
    }

    public void setNrcCurso(String nrcCurso) {
        this.nrcCurso = nrcCurso;
    }

    public void setProgreso(float progreso) {
        this.progreso = progreso;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public void setMatriculaProfesor(String matriculaProfesor) {
        this.matriculaProfesor = matriculaProfesor;
    }

    public void setMatriculaEstudiante(String matriculaEstudiante) {
        this.matriculaEstudiante = matriculaEstudiante;
    }
    
 
}
