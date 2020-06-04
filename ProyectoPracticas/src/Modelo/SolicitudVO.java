package Modelo;

import java.util.Objects;

/**
 *
 * @author Daniel Pale
 */
public class SolicitudVO {
    private String periodo;
    private String fecha;
    private String idProyecto;
    private String matricula;

    public SolicitudVO(String periodo, String fecha, String idProyecto, String matricula) {
        this.periodo = periodo;
        this.fecha = fecha;
        this.idProyecto = idProyecto;
        this.matricula = matricula;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SolicitudVO other = (SolicitudVO) obj;
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.idProyecto, other.idProyecto)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SolicitudVO{" + "periodo=" + periodo + ", fecha=" + fecha + ", idProyecto=" + idProyecto + ", matricula=" + matricula + '}';
    }
}
