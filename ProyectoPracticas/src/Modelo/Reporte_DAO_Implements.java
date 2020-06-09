/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static java.awt.JobAttributes.DestinationType.FILE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ALDO
 */
public class Reporte_DAO_Implements {
    
    public boolean create(ReporteVO reporte){
        
        boolean created =false;
        Statement stm=null;
        Connection con=null;
        String sql="INSERT INTO reporte (numero,horasReportadas,fechaCarga,estado,fechaInicio,"
                + "fechaFin, idExpediente) VALUES (NULL, '"+ reporte.getNumero() +
                "','" + reporte.getHorasReportadas() + 
                "','" + reporte.getFechaCarga() + 
                "','" + reporte.getEstado() + 
                "','" + reporte.getFechaInicio() + 
                "','" + reporte.getFechaFin() + 
                 "','1'" + ")";
        ConexionBaseDatos cc=new ConexionBaseDatos();
        try{
            con=cc.conectarMySQL();
            stm=con.createStatement();
            stm.execute(sql);
            created=true;
            stm.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error al agregar el  reporte, clase Reporte_DAO_imp");
            e.printStackTrace();
        }
        return created;
    }
    
    public boolean insertarArchivo(ReporteVO reporte) throws SQLException, FileNotFoundException{
        boolean insertado=false;
        try{
            
            Statement stm=null;
            Connection con=null;
            PreparedStatement myStmt=null;
            ConexionBaseDatos cc=new ConexionBaseDatos();
            FileInputStream input=null;

            String sql= "UPDATE Reporte SET reporte WHERE numero='"
                    + reporte.getNumero()+"'";

            myStmt = con.prepareStatement(sql);

            File archivo=reporte.getReporte();
            input = new FileInputStream(archivo);
            myStmt.setBinaryStream(1,input);

            myStmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al insertar el archivo");
            e.printStackTrace();
        }
        
        return insertado;
    }
}


