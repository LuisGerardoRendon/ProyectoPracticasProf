/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Practicante;

import Modelo.ReporteVO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Modelo.Reporte_DAO_Implements;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SubirReporte_Controller implements Initializable {

    @FXML
    private TableView<ReporteVO> tablaReportes;
    @FXML
    private TableColumn<ReporteVO, Integer> columnaHorasCubiertas;
    @FXML
    private Button botonSubirNuevoReporte;
    @FXML
    private Button botonRegresar;
    @FXML
    private Label labelNombreProyecto;
    @FXML
    private Label labelFechaIicio;
    @FXML
    private Label labelTotalHoras;
    @FXML
    private Label labelSetNombreProyecto;
    @FXML
    private Label labelSetFechaInicio;
    @FXML
    private Label labelSetTotalHoras;
    @FXML
    private TableColumn<ReporteVO, Integer> columnaNumeroReporte;
    @FXML
    private TableColumn<ReporteVO, Integer> columnaFechaCarga;
    
    
    ObservableList<ReporteVO> reportes = FXCollections.observableArrayList();
    Reporte_DAO_Implements reporte_DAO = new Reporte_DAO_Implements();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.columnaNumeroReporte.setCellValueFactory(new PropertyValueFactory("numero"));
        this.columnaFechaCarga.setCellValueFactory(new PropertyValueFactory("fechaCarga"));
        this.columnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));

                
        reportes = reporte_DAO.recuperarReportes();
        tablaReportes.setItems(reportes);
    }    

    @FXML
    private void subirNuevoReporte(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Practicante/SubirNuevoReporte.fxml"));
            Parent root = loader.load();
            SubirNuevoReporteController controladorSubirNuevoReporte= loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
        }
    }

    @FXML
    private void regresar(ActionEvent event) {
    }
    
}
