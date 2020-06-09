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
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


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
    
    ReporteVO reporte;
    
    Reporte_DAO_Implements reporte_DAO = new Reporte_DAO_Implements();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarReporte();
        
    }    

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void subirReporte(ActionEvent event) throws SQLException, FileNotFoundException {
        this.reporte_DAO.create(reporte);
        this.reporte_DAO.insertarArchivo(reporte);
    }
    
    public void crearReporte(ReporteVO r){
        reporte=r;
    }
    
    public void cargarReporte(){
        File file=reporte.getReporte();
        this.labelSetNombreArchivo.setText(file.getName());
        
    }
}
