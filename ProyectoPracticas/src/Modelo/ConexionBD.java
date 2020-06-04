/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ALDO
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

public class ConexionBD {
    public String driver = "com.mysql.jdbc.Driver";
    public String database = "PractiLis";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    public String username = "root";
    public String password = "LesCactus27";

    public Connection conectarMySQL() {
        Connection conn = null;
        try {
            System.out.println("EL URL ES: " + url);
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-6", "root", "123456");
            System.out.println("Se establecio la conexion con la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("ERROR BASE DE DATOS");
            alerta.setContentText("ERROR AL CONECTAR CON LA BASE DE DATOS" + e.getMessage());
            alerta.showAndWait();
        }
        return conn;
    }
    
}
