/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public String crearSQLRecuperarProyecto(String periodo, String matricula) {
        String sql;
        sql = "SELECT Proyecto.nombre, Proyecto.descripcion, ";
        sql += "Proyecto.capacidadEstudiantes, Proyecto.numEstudiantesAsignados, ";
        sql += "Proyecto.status, Proyecto.idOrganizacion, Proyecto.idEncargadoProyecto,";
        sql += " Proyecto.idProyecto";
        sql += " FROM Estudiante INNER JOIN Asignacion on Estudiante.matricula  = "
                + "Asignacion.matriculaEstudiante";
        sql += " INNER JOIN Proyecto on Asignacion.idProyecto = "
                + "Proyecto.idProyecto";
        sql += " WHERE Asignacion.preriodo = '" + periodo + "'";
        sql += " AND Asignacion.matriculaEstudiante = '" + matricula + "';";
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
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int capacidadEstudiantes = rs.getInt("capacidadEstudiantes");
                int numEstudiantesAsignados = rs.getInt("numEstudiantesAsignados");
                String idProyecto = rs.getInt("idProyecto") + "";
                String status = rs.getString("status");
                String idOrganizacion = rs.getInt("idOrganizacion") + "";
                String idEncargadoProyecto = rs.getInt("idEncargadoProyecto") + "";

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
    public ObservableList<EstudianteVO> recuperarEstudiante() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM estudiante WHERE status='Sin asignar'";

        ObservableList<EstudianteVO> obs = FXCollections.observableArrayList();

        try {
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String matricula = rs.getString("matricula");
                String contrasenia = rs.getString("contrasenia");
                String nombre = rs.getString("nombre");
                String correoElectronico = rs.getString("correoElectronico");
                String status = rs.getString("status");

                EstudianteVO e = new EstudianteVO(matricula, contrasenia, nombre, correoElectronico, status);
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

    @Override
    public ObservableList<ProyectoVO> recuperarProyectosSeleccionado(String matricula) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT p.nombre, p.descripcion, p.capacidadEstudiantes, p.numEstudiantesAsignados, p.idProyecto, p.status, p.idOrganizacion, p.idEncargadoProyecto FROM proyecto p INNER JOIN solicitud s ON s.idProyecto=p.idProyecto WHERE matricula= ?";

        ObservableList<ProyectoVO> obs = FXCollections.observableArrayList();

        try {
            con = new ConexionBD().conectarMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            rs = ps.executeQuery();
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
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo recuperarProyectosSeleccionado");
            e.printStackTrace();
        }
        return obs;
    }

    @Override
    public ObservableList<SolicitudVO> recuperarSolicitudes(String matricula) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM solicitud WHERE matricula=?";

        ObservableList<SolicitudVO> obs = FXCollections.observableArrayList();

        try {
            con = new ConexionBD().conectarMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            while (rs.next()) {
                String periodo = rs.getString("preriodo");
                String fecha = rs.getString("fecha");
                String idProyecto = rs.getInt("idProyecto") + "";
                String matriculaSolicitud = rs.getString("matricula");

                SolicitudVO s = new SolicitudVO(periodo, fecha, idProyecto, matriculaSolicitud);
                obs.add(s);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo ReadAll");
            e.printStackTrace();
        }
        return obs;
    }
    
   

}
