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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ALDO
 */
public class Reporte_DAO_Implements {
     
   
      
                
   public boolean create(ReporteVO reporte){
        boolean created =false;
        try{
            
            Connection con=null;
            ConexionBD cc=new ConexionBD();
            con=cc.conectarMySQL();
            
            String sql = "INSERT INTO reporte (numero,horasReportadas, fechaCarga, estado, reporte, "
                        + "fechaInicio, fechaFin, idExpediente) VALUES (?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, 0);
            ps.setInt(2, reporte.getHorasReportadas());
            ps.setString(3, reporte.getFechaCarga());
            ps.setString(4, reporte.getEstado());
            FileInputStream archivo = new FileInputStream(reporte.getReporte());
            ps.setBlob(5, archivo);
            ps.setString(6, reporte.getFechaInicio());
            ps.setString(7, reporte.getFechaFin());
            ps.setInt(8,1);
            
            ps.executeUpdate();
            created=true;
            con.close();
        }catch(SQLException e){
            System.out.println("Error al agregar el  reporte, clase Reporte_DAO_imp");
            e.printStackTrace();
        }catch(FileNotFoundException ex) {
            ex.printStackTrace();
            }
        return created;
    }
    
    public boolean insertarArchivo(ReporteVO reporte) throws SQLException, FileNotFoundException{
        boolean insertado=false;
        try{
            File archivo=reporte.getReporte();
            System.out.println(archivo.getName());
            Statement stm=null;
            Connection con=null;
            PreparedStatement myStmt=null;
            ConexionBD cc=new ConexionBD();
            FileInputStream input=null;
            con=cc.conectarMySQL();
            
            String sql= "UPDATE Reporte SET reporte=? WHERE numero='"
                    + reporte.getNumero()+"'";
            
            myStmt = con.prepareStatement(sql);
            input = new FileInputStream(archivo);
            myStmt.setBinaryStream(1,input,(int)archivo.length());
            myStmt.executeUpdate();
            insertado=true;
            
        }catch(SQLException e){
            System.out.println("Error al insertar el archivo");
            e.printStackTrace();
        }
        
        return insertado;
    }
}


