/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Coordinador;

import Modelo.AsignacionVO;
import Modelo.Asignacion_DAO_Implements;
import Modelo.EstudianteVO;
import Modelo.ProyectoVO;
import Modelo.SolicitudVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableView<ProyectoVO> tablaSolicitudes;
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
    private TableColumn<ProyectoVO, String> columnaNombreProyectoSolicitado;
    @FXML
    private TableColumn<ProyectoVO, Integer> columnaCupoProyectoSolicitado;

    private ObservableList<ProyectoVO> proyectos;
    private ObservableList<ProyectoVO> proyectosSolicitados;
    private ObservableList<EstudianteVO> estudiantes;

    Asignacion_DAO_Implements asignacionDAOImp;

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
        estudiantes = FXCollections.observableArrayList();
        estudiantes = e.obtenerEstudiantes();

        this.columnaNombreEstudiantes.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.columnaMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));

        this.tablaEstudiantes.setItems(estudiantes);

    }

    @FXML
    private void mostrarSolicitudes(ActionEvent event) {
        EstudianteVO e = this.tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (e != null) {
            proyectosSolicitados = e.obtenerProyectosSolicitados();

            this.columnaNombreProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.columnaCupoProyectoSolicitado.setCellValueFactory(new PropertyValueFactory("capacidadEstudiantes"));

            this.tablaSolicitudes.setItems(proyectosSolicitados);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("No se ha seleccionado un estudiante");
            alert.showAndWait();
        }
    }

    @FXML
    private void asignar(ActionEvent event) {
        EstudianteVO e = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
        ProyectoVO pS = this.tablaSolicitudes.getSelectionModel().getSelectedItem();
        ProyectoVO p = this.tablaProyectos.getSelectionModel().getSelectedItem();

        //Datos de la asignacion
        boolean creado = false;
        String periodo = "2020";
        String nrcCurso = "85103";
        float progreso = 0;
        String matriculaProfesor = "1234";

        if (e != null && ((pS != null && p == null) || (pS == null && p != null))) {
            if (pS != null) {
                AsignacionVO a = new AsignacionVO(periodo, nrcCurso, progreso, pS.getIdProyecto(), matriculaProfesor, e.getMatricula());
                creado = asignacionDAOImp.create(a);
            } else {
                AsignacionVO a = new AsignacionVO(periodo, nrcCurso, progreso, p.getIdProyecto(), matriculaProfesor, e.getMatricula());
                creado = asignacionDAOImp.create(a);
            }
            if (creado == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CREADO");
                alert.setHeaderText(null);
                alert.setContentText("La asignación se realizó correctamente");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("No se ha podido asignar proyecto a estudiante");
                alert.showAndWait();
            }
        } else {
            if (pS != null && p != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("No se pueden seleccionar dos proyectos");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("No se ha seleccionado un estudiante o proyecto");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void seleccionarEstudiante(MouseEvent event) {
        EstudianteVO e = this.tablaEstudiantes.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void seleccionarProyectoSolicitado(MouseEvent event) {
        ProyectoVO p = this.tablaSolicitudes.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void seleccionarProyecto(MouseEvent event) {
        ProyectoVO p = this.tablaProyectos.getSelectionModel().getSelectedItem();
    }

    public String getPeriodo(String matricula) {
        String periodo = "";
        SolicitudVO s = new SolicitudVO();

        return periodo;
    }

}
