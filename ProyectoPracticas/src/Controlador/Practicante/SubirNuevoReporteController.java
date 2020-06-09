/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Practicante;

import Modelo.ReporteVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Modelo.Reporte_DAO_Implements;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ALDO
 */
public class SubirNuevoReporteController implements Initializable {

    @FXML
    private TextField txtFieldNumero;
    @FXML
    private TextField txtFieldHorasReportas;
    @FXML
    private TextField txtFieldFechaCarga;
    @FXML
    private TextField txtFieldFechaInicio;
    @FXML
    private TextField txtFieldFechaFin;
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonCargarReporte;
    
    @FXML
    private Button botonImportarArchivo;
    
    private Desktop desktop = Desktop.getDesktop();
    
    Reporte_DAO_Implements reporteDAO= new Reporte_DAO_Implements();
    
    public File archivo;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        crearReporte(archivo);
      
    }    

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void cargarReporte(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Practicante/ReporteCargado_.fxml"));
            Parent root = loader.load();
            ReporteCargado_Controller controladorReporteCargado= loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
        }
        
       
    }
    
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                SubirNuevoReporteController.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }

    @FXML
    private void importarArchivo(ActionEvent event) {
        
        Stage stage = (Stage) this.botonImportarArchivo.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file  = fileChooser.showOpenDialog(stage);
        archivo=file;
        
    }
    
    
    public  ReporteVO crearReporte(File file){
       
        int numero= Integer.parseInt(txtFieldNumero.getText());
        int horasReportadas = Integer.parseInt(txtFieldHorasReportas.getText());
        String fechaCarga =txtFieldFechaCarga.getText();
        String estado="Entregado";
  
        String fechaInicio=txtFieldFechaInicio.getText();
        String fechaFin= txtFieldFechaFin.getText();
        
        ReporteVO reporte = new ReporteVO(numero, horasReportadas,fechaCarga,estado,file,fechaInicio,fechaFin);
        return reporte;
    }
    
    public void mandarDatos(){
       
    }
    
   
  
   
  
    
    
    
    
}
