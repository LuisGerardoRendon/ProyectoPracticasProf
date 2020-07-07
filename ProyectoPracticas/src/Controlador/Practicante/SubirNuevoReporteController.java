/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Practicante;

import Modelo.Alerta;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
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
    private TextField txtFieldHorasReportas;
    @FXML
    private DatePicker datePickerFechaInicio;
    @FXML
    private DatePicker datePickerFechaFin;
  
    @FXML
    private Button botonCancelar;
    @FXML
    private Button botonCargarReporte;

    
    
    @FXML
    private Button botonImportarArchivo;

    private Desktop desktop = Desktop.getDesktop();

    Reporte_DAO_Implements reporteDAO = new Reporte_DAO_Implements();

    public int horasReportadas=0;

    public String fechaInicio;

    public String fechaFin;

    public File archivo;
    
    Alerta alerta=new Alerta();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        dummies();
    }

    void dummies(){
        txtFieldHorasReportas.setText("10");
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void cargarReporte(ActionEvent event) {
        
        try {
            if(validarFormulario() && validarArchivo()){
                
                horasReportadas = Integer.parseInt(txtFieldHorasReportas.getText());
                fechaInicio = datePickerFechaInicio.getValue().toString();
                fechaFin= datePickerFechaFin.getValue().toString();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Practicante/ReporteCargado_.fxml"));
                
                ReporteCargado_Controller controladorReporteCargado = new ReporteCargado_Controller(horasReportadas,
                fechaInicio, fechaFin, archivo);
                loader.setController(controladorReporteCargado);
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


            

        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            
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
        archivo = fileChooser.showOpenDialog(stage);

    }
    
    public boolean validarArchivo(){
        boolean archivoValido=true;
        
        if(archivo==null){
           archivoValido=false;
           alerta.alertaArchivoNoElegido();
        }else{
            if(!validarExtencionArchivo()){
                archivoValido=false;
            }
        }
        
        
        return archivoValido;
    }
    
    public boolean validarExtencionArchivo(){
        boolean extencionValida=true;
        
        String extencion="";
        String nombre=archivo.getName();
        
        int lastIndexOf= nombre.lastIndexOf(".");
        if(lastIndexOf== -1){
            extencion="";
        }
        extencion=nombre.substring(lastIndexOf);
        System.out.println(extencion);
        
        if(!extencion.equals(".docx") && !extencion.equals(".pdf")){
           extencionValida=false;
           alerta.alertaExtencionDeArchivoInvalida();
        }
        
        return extencionValida;
        
    }
    
    public boolean validarFormulario(){
            boolean formularioValido=true;
            boolean camposLlenos=validarCamposLlenos();
            boolean formatoDatos=true;
            
            if(camposLlenos){
               formatoDatos=validarFormatoDatos();
            }
            
            if(!camposLlenos || !formatoDatos){
                formularioValido=false;
            }
            
            return formularioValido;
    }
    
    public boolean validarCamposLlenos(){
        boolean camposLlenos=true;
        String horas=txtFieldHorasReportas.getText();
        
        if(horas.isEmpty() || datePickerFechaFin.getValue()==null || datePickerFechaFin.getValue()==null){
            camposLlenos=false;
            alerta.alertaCamposIncompletosReporte();
        }    
        return camposLlenos;
    }
    
    public boolean validarFormatoDatos(){
        boolean formatoCorrecto=true;
        
        if(!validarHoras() || !validarFechaInicio() || !validarFechaFin()){
            formatoCorrecto=false;
        }
       
        return formatoCorrecto;
    }
    
    public boolean validarHoras(){
        boolean horasValidas=true;
        String horasReportadas=txtFieldHorasReportas.getText();
        if(! horasReportadas.matches("^-?[0-9]+$")){
            horasValidas=false;
            alerta.alertaFormatoHoras();
        }
        return horasValidas;
    }
    
    public boolean validarFechaInicio(){
        boolean fechaInicioValida=true;
        if(! datePickerFechaInicio.getValue().toString().matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            fechaInicioValida=false;
            alerta.alertaFechaInicio();
        }
        return fechaInicioValida;
    }
    
    public boolean validarFechaFin(){
        boolean fechaFinValida=true;
        if(! datePickerFechaFin.getValue().toString().matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            fechaFinValida=false;
            alerta.alertaFechaFin();
        }
        
        return fechaFinValida;
    }
    
    
    
    @FXML
    private void seleccionarFechaInicio(ActionEvent event) {
    }

    @FXML
    private void seleccionarFechaFin(ActionEvent event) {
    }
    
}
