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
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
    }    

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void cargarReporte(ActionEvent event) {
    }
    
}
