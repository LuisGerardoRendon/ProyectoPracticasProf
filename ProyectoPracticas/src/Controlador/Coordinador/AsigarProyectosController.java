/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Coordinador;

import Modelo.EstudianteVO;
import Modelo.ProyectoDAO_Implements;
import Modelo.ProyectoVO;
import Modelo.SolicitudVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AsigarProyectosController implements Initializable {

    @FXML
    private TableView<EstudianteVO> tablaEstudiantes;
    @FXML
    private Button botonMostrarSolicitudes;
    @FXML
    private Button botonAsignar;
    @FXML
    private TableView<SolicitudVO> tablaSolicitudes;
    @FXML
    private TableView<ProyectoVO> tablaProyectos;
    @FXML
    private TableColumn<EstudianteVO, String> columnaNombreEstudiantes;
    @FXML
    private TableColumn<EstudianteVO, String> columnaMatricula;
    @FXML
    private TableColumn<ProyectoVO, String> columnaNombreProyecto;
    @FXML
    private TableColumn<ProyectoVO, Integer> columnaCupoProyecto;
    @FXML
    private TableColumn<ProyectoVO, String> columnaNombreProyectoAsinado;
    @FXML
    private TableColumn<ProyectoVO, Integer> ColumnaCupoProyectoAsignado;

    private ObservableList<ProyectoVO> proyectos;
    private ObservableList<EstudianteVO> estudiantes;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //LLena tabla de proyectos
        ProyectoVO p = new ProyectoVO();
        proyectos = FXCollections.observableArrayList();
        proyectos = p.obtenerProyectos();

        this.columnaNombreProyecto.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.columnaCupoProyecto.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));

        this.tablaProyectos.setItems(proyectos);

        //Llena tabla de estudiantes
        EstudianteVO e = new EstudianteVO();
        estudiantes=FXCollections.observableArrayList();
        estudiantes=e.obtenerEstudiantes();
        
        this.columnaNombreEstudiantes.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.columnaMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        
        this.tablaEstudiantes.setItems(estudiantes);

    }

    @FXML
    private void mostrarSolicitudes(ActionEvent event) {
        
    }

    @FXML
    private void asignar(ActionEvent event) {
    }

}
