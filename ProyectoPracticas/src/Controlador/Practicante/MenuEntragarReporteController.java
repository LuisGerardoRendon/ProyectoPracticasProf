/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Practicante;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MenuEntragarReporteController implements Initializable {

    @FXML
    private TableView<?> tablaReportes;
    @FXML
    private TableColumn<?, ?> columnsNombreReporte;
    @FXML
    private TableColumn<?, ?> columanFechaCarga;
    @FXML
    private TableColumn<?, ?> columnaHorasCubiertas;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void subirNuevoReporte(ActionEvent event) {
    }

    @FXML
    private void regresar(ActionEvent event) {
    }
    
}
