package Modelo;

import java.util.Objects;

/**
 *
 * @author Daniel Pale
 */
public class ProfesorVO {
    private String idProfesor;
    private String constrasenia;
    private String usuario;

    public ProfesorVO(String idProfesor, String constrasenia, String usuario) {
        this.idProfesor = idProfesor;
        this.constrasenia = constrasenia;
        this.usuario = usuario;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ProfesorVO other = (ProfesorVO) obj;
        if (!Objects.equals(this.idProfesor, other.idProfesor)) {
            return false;
        }
        if (!Objects.equals(this.constrasenia, other.constrasenia)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfesorVO{" + "idProfesor=" + idProfesor + ", constrasenia=" + constrasenia + ", usuario=" + usuario + '}';
    }
}
