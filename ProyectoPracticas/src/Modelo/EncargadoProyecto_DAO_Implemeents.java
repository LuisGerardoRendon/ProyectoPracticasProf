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

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EncargadoProyecto_DAO_Implemeents implements EncargadoProyecto_DAO {

    @Override
    public EncargadoProyectoVO recuperarEncargadoProyecto(ProyectoVO proyectoVO) {
        String idProyecto = proyectoVO.getIdProyecto();
        String sql = "SELECT * FROM EncargadoProyecto WHERE idEncargadoProyecto = "
                + proyectoVO.getIdEncargadoProyecto();
        EncargadoProyectoVO encargadoProyectoRecuperdo = new EncargadoProyectoVO();
        Connection con = null;
        Statement stm = null;
        modelo.ConexionBD cc = new modelo.ConexionBD();
        ResultSet rs = null;
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            rs.next();
            int idEncargado = rs.getInt("idEncargadoProyecto");
            String nombre = rs.getString("nombre");
            String cargo = rs.getString("cargo");
            String correoElectronico = rs.getString("correoElectronico");
            encargadoProyectoRecuperdo = new EncargadoProyectoVO(idEncargado + "",
                    nombre, cargo, correoElectronico);
            con.close();
            stm.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN EJECUTAR CONSULTA:  ");
            e.printStackTrace();

        }
        return encargadoProyectoRecuperdo;
    }

    @Override
    public boolean registrarEncargadoProyecto(EncargadoProyectoVO encargado) {
        boolean registrado = false;
        String nombre = encargado.getNombre();
        String cargo = encargado.getCargo();
        String correoElectronico = encargado.getCorreoElectronico();
        String sql = "INSERT INTO EncargadoProyecto VALUES (";
        sql += "'" + nombre + "',";
        sql += "'" + cargo + "',";
        sql += "'" + correoElectronico + "',";
        sql += "null);";

        Statement stm = null;
        Connection con = null;
        ConexionBD cc = new modelo.ConexionBD();
        try {
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            registrado = true;
            con.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Error, Clase EncargadoProyecto_DAO_Implements"
                    + ", metodo create");
            e.printStackTrace();
        }
        return registrado;

    }

}
