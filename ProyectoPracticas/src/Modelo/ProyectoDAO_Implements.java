package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProyectoDAO_Implements implements ProyectoDAO {

    @Override
    public ObservableList<ProyectoVO> recuperaNombreCupo() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT nombre, capacidadEstudiantes,numEstudiantesAsignados FROM proyecto WHERE status='Sin asignar'";

        ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();

        try {
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String nombreProyecto = rs.getString("nombre");
                int cupo =(rs.getInt("capacidadEstudiantes"))-(rs.getInt("numEstudiantesAsignados"));
                ProyectoVO c = new ProyectoVO(nombreProyecto, cupo);
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
