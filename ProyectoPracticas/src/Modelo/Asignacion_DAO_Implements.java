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

/**
 *
 * @author Daniel Pale
 */
public class Asignacion_DAO_Implements implements Asignacion_DAO{
    @Override
    public boolean create(AsignacionVO asignacion){
        boolean created = false;
        int idProyecto = Integer.parseInt(asignacion.getIdProyecto());
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO asignacion VALUES (?,?,?,?,?,?,?)";
        
        try {
            con = new ConexionBD().conectarMySQL();
            ps = con.prepareStatement(sql);
            ps.setString(1, asignacion.getPreriodo());
            ps.setInt(2, asignacion.getIdAsignacion());
            ps.setString(3, asignacion.getNrcCurso());
            ps.setFloat(4, asignacion.getProgreso());
            ps.setInt(5, idProyecto);
            ps.setString(6, asignacion.getMatriculaProfesor());
            ps.setString(7, asignacion.getMatriculaEstudiante());
            rs = ps.executeQuery();
            created = true;
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar al estudiante, método registrar");
            e.printStackTrace();
        }
        return created; 
    }
}
