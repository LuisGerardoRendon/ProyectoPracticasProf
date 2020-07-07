/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Practicante;

import Modelo.EstudianteVO;
import Modelo.Estudiante_DAO_Implements;
import Modelo.ProyectoVO;
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
import javafx.scene.Node;

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

    public EstudianteVO estudianteUsuario = new EstudianteVO("ZS180121",
            "123456", "Aldo Ulises Colorado Díaz", "aldocoloradocd@gmail.com", "inscrito");
    Estudiante_DAO_Implements estudiante_DAO = new Estudiante_DAO_Implements();
    ObservableList<ReporteVO> reportesRecuperados
            = this.estudiante_DAO.recuperarReportes("2020-2021",
                    this.estudianteUsuario.getMatricula());
    ProyectoVO proyectoRescatado = this.estudiante_DAO.recuperarProyecto("2020-2021", this.estudianteUsuario.getMatricula());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.columnaNumeroReporte.setCellValueFactory(new PropertyValueFactory("numero"));
        this.columnaFechaCarga.setCellValueFactory(new PropertyValueFactory("fechaCarga"));
        this.columnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
        this.tablaReportes.setItems(reportesRecuperados);

        setNombreProyecto();
        calcularHoras();

    }

    public void setNombreProyecto() {
        String nombreProyectoRecuperado = proyectoRescatado.getNombre();
        this.labelSetNombreProyecto.setText(nombreProyectoRecuperado);
    }

    public void calcularHoras() {
        int suma = 0;
        for (ReporteVO tab : reportesRecuperados) {
            suma += tab.getHorasReportadas();
        }
        this.labelSetTotalHoras.setText(suma + "");
    }

    @FXML
    private void subirNuevoReporte(ActionEvent event) {
        
        

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Practicante/SubirNuevoReporte.fxml"));
            Parent root = loader.load();
            SubirNuevoReporteController controladorSubirNuevoReporte = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        Node source = (Node) event.getSource();
        Stage stagee = (Stage) source.getScene().getWindow();
        stagee.close();
        
    }

    @FXML
    private void regresar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
