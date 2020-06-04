package Modelo;

/**
 *
 * @author Daniel Pale
 */
public class EstudianteVO {
  private String matricula;
  private String contrasenia;
  private String nombre;
  private String correoElectronico;
  private boolean status;

    public EstudianteVO(String matricula, String contrasenia, String nombre, String correoElectronico, boolean status) {
        this.matricula = matricula;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EstudianteVO{" + "matricula=" + matricula + ", contrasenia=" + contrasenia + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + ", status=" + status + '}';
    }
}
