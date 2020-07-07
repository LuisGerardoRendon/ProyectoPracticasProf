/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Practicante;

import Controlador.Coordinador.AsigarProyectosController;
import Controlador.Coordinador.MenuPrincipalController;
import Modelo.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ALDO
 */
public class ReporteSubidoExitoController implements Initializable {

    @FXML
    private Button botonAceptar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public ReporteSubidoExitoController(){
    
    }
    
    @FXML
    private void aceptar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stagee = (Stage) source.getScene().getWindow();
        stagee.close();
    }
    
}
