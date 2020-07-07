package Modelo;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Pale
 */
public class EstudianteVO {

    private String matricula;
    private String contrasenia;
    private String nombre;
    private String correoElectronico;
    private String status;

    public EstudianteVO(String matricula, String contrasenia, String nombre, String correoElectronico, String status) { // Se cambio el status a string
        this.matricula = matricula;                                                                                     // porque puede ser Asignado, Sin Asignar, Aprobado
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.status = status;
    }

    public EstudianteVO() {
        this.matricula = "null";                                                                                     // porque puede ser Asignado, Sin Asignar, Aprobado
        this.contrasenia = "null";
        this.nombre = "null";
        this.correoElectronico = "null";
        this.status = "null";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ObservableList<EstudianteVO> obtenerEstudiantes() {
        Estudiante_DAO_Implements estudianteDAOImp = new Estudiante_DAO_Implements();
        ObservableList<EstudianteVO> obs = FXCollections.observableArrayList();
        obs = estudianteDAOImp.recuperarEstudiante();
        return obs;
    }

    public ObservableList<ProyectoVO> obtenerProyectosSolicitados() {
        Estudiante_DAO_Implements estudianteDAOImp = new Estudiante_DAO_Implements();
        ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();
        obs = estudianteDAOImp.recuperarProyectosSeleccionado(matricula);
        return obs;
    }

    public ObservableList<SolicitudVO> obtenerSolicitudes() {
        Estudiante_DAO_Implements estudianteDAOImp = new Estudiante_DAO_Implements();
        ObservableList<SolicitudVO> obs = FXCollections.observableArrayList();
        obs = estudianteDAOImp.recuperarSolicitudes(matricula);
        return obs;
    }

    @Override

    public String toString() {
        return "EstudianteVO{" + "matricula=" + matricula + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final EstudianteVO other = (EstudianteVO) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        return true;
    }
}
