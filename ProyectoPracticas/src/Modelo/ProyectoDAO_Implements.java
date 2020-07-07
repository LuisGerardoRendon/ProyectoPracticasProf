package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProyectoDAO_Implements implements ProyectoDAO {

    @Override
    public ObservableList<ProyectoVO> recuperarProyecto() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM proyecto WHERE status='Sin asignar'";

        ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();

        try {
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String nombreProyecto = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int capacidadEstudiantes = rs.getInt("capacidadEstudiantes");
                int numEstudiantesAsignados = rs.getInt("numEstudiantesAsignados");
                String idProyecto = rs.getInt("idProyecto") + "";
                String status = rs.getString("status");
                int idOrganizacion = rs.getInt("idOrganizacion");
                int idEncargadoProyecto = rs.getInt("idEncargadoProyecto");
                int cupo = (rs.getInt("capacidadEstudiantes")) - (rs.getInt("numEstudiantesAsignados"));
                
                ProyectoVO c = new ProyectoVO(nombreProyecto, descripcion, capacidadEstudiantes, numEstudiantesAsignados, idProyecto, status, idOrganizacion, idEncargadoProyecto);
                obs.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo ReadAll");
            e.printStackTrace();
        }
        return obs;
    }
}
