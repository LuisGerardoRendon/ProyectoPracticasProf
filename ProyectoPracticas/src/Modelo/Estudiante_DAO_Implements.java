/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Estudiante_DAO_Implements implements Estudiante_DAO {

    @Override
    public ObservableList<ReporteVO> recuperarReportes(String periodo, String matricula) {
        String sql = crearSQLRecuperarReportes(periodo, matricula);
        ObservableList<ReporteVO> reportesRecuperados = FXCollections.observableArrayList();
        Connection con = null;
        Statement stm = null;
        ConexionBD cc = new ConexionBD();
        ResultSet rs = null;
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int numero = rs.getInt("numero");
                int horasReportadas = rs.getInt("horasReportadas");
                String fechaCarga = rs.getString("fechaCarga");
                ReporteVO reporteRecuperado = new ReporteVO(numero, horasReportadas, fechaCarga);
                reportesRecuperados.add(reporteRecuperado);
            }

            con.close();
            stm.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN EJECUTAR CONSULTA:  ");
            e.printStackTrace();

        }
        return reportesRecuperados;

    }

    public String crearSQLRecuperarReportes(String periodo, String matricula) {
        String sql = "SELECT Reporte.numero,Reporte.horasReportadas,"
                + "Reporte.fechaCarga, Reporte.Estado,Reporte.reporte,"
                + " Reporte.fechaInicio, Reporte.fechaFin";
        sql += " FROM Estudiante INNER JOIN Asignacion on Estudiante.matricula "
                + "= Asignacion.matriculaEstudiante";
        sql += " INNER JOIN Expediente on Asignacion.idAsignacion = "
                + "Expediente.idAsignacion ";
        sql += " INNER JOIN Reporte on Expediente.idExpediente = "
                + "Reporte.idExpediente ";
        sql += " WHERE Asignacion.preriodo = " + "'" + periodo + "'";
        sql += " AND Asignacion.matriculaEstudiante =" + "'" + matricula + "';";
        System.out.println(sql);
        return sql;
    }
    public String crearSQLRecuperarProyecto(String periodo, String matricula){
        String sql;
        sql = "SELECT Proyecto.nombre, Proyecto.descripcion, ";
        sql+= "Proyecto.capacidadEstudiantes, Proyecto.numEstudiantesAsignados, ";
        sql+= "Proyecto.status, Proyecto.idOrganizacion, Proyecto.idEncargadoProyecto,";
        sql+= " Proyecto.idProyecto";
        sql+= " FROM Estudiante INNER JOIN Asignacion on Estudiante.matricula  = "
                + "Asignacion.matriculaEstudiante";
        sql+= " INNER JOIN Proyecto on Asignacion.idProyecto = "
                + "Proyecto.idProyecto";
        sql+= " WHERE Asignacion.preriodo = '" + periodo + "'";
        sql+= " AND Asignacion.matriculaEstudiante = '"+matricula+"';";
        System.out.println(sql);
        return sql;
    }

    @Override
    public ProyectoVO recuperarProyecto(String periodo, String matricula) {
        String sql = crearSQLRecuperarProyecto(periodo, matricula);
        ProyectoVO proyectoRecuperado = new ProyectoVO();
        Connection con = null;
        Statement stm = null;
        ConexionBD cc = new ConexionBD();
        ResultSet rs = null;
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if(rs.next()){
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int capacidadEstudiantes = rs.getInt("capacidadEstudiantes");
                int numEstudiantesAsignados = rs.getInt("numEstudiantesAsignados");
                String idProyecto = rs.getInt("idProyecto")+"";
                String status = rs.getString("status");
                String idOrganizacion = rs.getInt("idOrganizacion")+"";
                String idEncargadoProyecto = rs.getInt("idEncargadoProyecto")+"";
                
                //(String idProyecto, String nombre, String descripcion, int capacidadEstudiantes, int numEstudiantesAsignados, boolean status, String idOrganizacion, String idEncargadoProyecto)
                //proyectoRecuperado = new ProyectoVO(nombre,descripcion,capacidadEstudiantes,numEstudiantesAsignados,status,idOrganizacion,idEncargadoProyecto);
                
                
            }
            

            con.close();
            stm.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN EJECUTAR CONSULTA:  ");
            e.printStackTrace();

        }
        return proyectoRecuperado;
    }
    
    @Override
    public ObservableList<EstudianteVO> recuperaNombreMatricula(){
       Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT matricula, nombre FROM estudiante WHERE status='Sin asignar'";

        ObservableList<EstudianteVO> obs = FXCollections.observableArrayList();

        try {
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String matricula = rs.getString("matricula");
                String nombre = rs.getString("nombre");
                EstudianteVO e = new EstudianteVO(matricula, nombre);
                obs.add(e);
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
