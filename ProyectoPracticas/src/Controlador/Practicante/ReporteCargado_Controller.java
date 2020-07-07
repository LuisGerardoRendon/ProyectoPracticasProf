/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Practicante;

import Modelo.ReporteVO;
import Modelo.Reporte_DAO_Implements;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */


public class ReporteCargado_Controller implements Initializable {

    @FXML
    private Label labelReporteCargado;
    @FXML
    private Label labelNombreArchivo;
    @FXML
    private Label labelSetNombreArchivo;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonSubirReporte;
 
    
    public int horasReportadas;
    
    public String fechaCarga;
    
    public String fechaInicio;
    
    public String estado="Concluido";
    
    public String fechaFin;
    
    public File archivo;
    
    ReporteVO reporte;
    
    
    
    
    Reporte_DAO_Implements reporte_DAO = new Reporte_DAO_Implements();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        inicializarFechaDeCarga();
        cargarReporte();
        crearReporte();
        
            
    }    
     
    public ReporteCargado_Controller(int horasReportadas, String fechaInicio,
            String fechaFin, File archivo) {
        
        this.horasReportadas = horasReportadas;
        this.fechaInicio= fechaInicio;
        this.fechaFin= fechaFin;
        this.archivo= archivo;
         
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void subirReporte(ActionEvent event) throws SQLException, FileNotFoundException, IOException {
        
        
        
        boolean creado=this.reporte_DAO.create(reporte);
        //boolean insertado=this.reporte_DAO.insertarArchivo(reporte);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Practicante/ReporteSubidoExito.fxml"));
        ReporteSubidoExitoController controladorReporteExito = new ReporteSubidoExitoController();
        loader.setController(controladorReporteExito);
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
        
        Node source = (Node) event.getSource();
        Stage stagee = (Stage) source.getScene().getWindow();
        stagee.close();
       
    }
    
    public void crearReporte(){
        reporte= new ReporteVO(horasReportadas,fechaCarga,estado,archivo,fechaInicio, fechaFin);
    }
    
    public void cargarReporte(){
        System.out.println("");
        this.labelSetNombreArchivo.setText(archivo.getName()); 
    }
     
    public void inicializarFechaDeCarga(){
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha = dateFormat.format(date);
        fechaCarga=fecha;
        
    }

       
}
