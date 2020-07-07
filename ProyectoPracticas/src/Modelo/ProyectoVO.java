package Modelo;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Pale
 */
public class ProyectoVO {

    private String idProyecto;
    private String nombre;
    private String descripcion;
    private int capacidadEstudiantes;
    private int numEstudiantesAsignados;
    private String status; //Se cambio status por que puede ser "Asignado", "Sin Asignar" y "Concluido".
    private int idOrganizacion;
    private int idEncargadoProyecto;

    public ProyectoVO(String nombre, String descripcion, int capacidadEstudiantes, int numEstudiantesAsignados, String idProyecto, String status, int idOrganizacion, int idEncargadoProyecto) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadEstudiantes = capacidadEstudiantes;
        this.numEstudiantesAsignados = numEstudiantesAsignados;
        this.status = status;
        this.idOrganizacion = idOrganizacion;
        this.idEncargadoProyecto = idEncargadoProyecto;
    }

    public ProyectoVO(String nombre, String descripcion, int capacidadEstudiantes, int numEstudiantesAsignados, String status, int idOrganizacion, int idEncargadoProyecto) {
        this.idProyecto = "";
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadEstudiantes = capacidadEstudiantes;
        this.numEstudiantesAsignados = numEstudiantesAsignados;
        this.status = status;
        this.idOrganizacion = idOrganizacion;
        this.idEncargadoProyecto = idEncargadoProyecto;
    }

    public ProyectoVO() {
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidadEstudiantes() {
        return capacidadEstudiantes;
    }

    public void setCapacidadEstudiantes(int capacidadEstudiantes) {
        this.capacidadEstudiantes = capacidadEstudiantes;
    }

    public int getNumEstudiantesAsignados() {
        return numEstudiantesAsignados;
    }

    public void setNumEstudiantesAsignados(int numEstudiantesAsignados) {
        this.numEstudiantesAsignados = numEstudiantesAsignados;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public int getIdEncargadoProyecto() {
        return idEncargadoProyecto;
    }

    public void setIdEncargadoProyecto(int idEncargadoProyecto) {
        this.idEncargadoProyecto = idEncargadoProyecto;
    }

    public ObservableList<ProyectoVO> obtenerProyectos() {
        ProyectoDAO_Implements proyectoDAOImp = new ProyectoDAO_Implements();
        ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();
        obs = proyectoDAOImp.recuperarProyecto();
        return obs;
    }

    @Override
    public String toString() {
        return "ProyectoVO{" + "idProyecto=" + idProyecto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", capacidadEstudiantes=" + capacidadEstudiantes + ", numEstudiantesAsignados=" + numEstudiantesAsignados + ", status=" + status + ", idOrganizacion=" + idOrganizacion + ", idEncargadoProyecto=" + idEncargadoProyecto + '}';
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
        final ProyectoVO other = (ProyectoVO) obj;
        if (!Objects.equals(this.idProyecto, other.idProyecto)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (this.capacidadEstudiantes != other.capacidadEstudiantes) {
            return false;
        }
        if (this.numEstudiantesAsignados != other.numEstudiantesAsignados) {
            return false;
        }
        if (!Objects.equals(this.idOrganizacion, other.idOrganizacion)) {
            return false;
        }
        if (!Objects.equals(this.idEncargadoProyecto, other.idEncargadoProyecto)) {
            return false;
        }
        return true;
    }
}
