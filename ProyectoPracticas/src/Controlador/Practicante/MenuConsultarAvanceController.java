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
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MenuConsultarAvanceController implements Initializable {

    @FXML
    private Label labelProgreso;
    @FXML
    private Button botonRegresar;
    @FXML
    private Label labelNombreProyecto;
    @FXML
    private Label labelSetNombreProyecto;
    @FXML
    private Label labelHorasRegistradas;
    @FXML
    private Label labelSetHorasRegistradas;
    @FXML
    private Label labelTotalHoras;
    @FXML
    private Label label200;
    @FXML
    private TableView<ReporteVO> tablaReportesEntregados;
    @FXML
    private TableColumn<?, ?> columnaNombreReporte;
    @FXML
    private TableColumn<?, ?> comlumnaFechaEntrega;
    @FXML
    private TableColumn<?, ?> ColumnaHorasCubiertas;
    @FXML
    private Label labelSetAvance;
    @FXML
    private Label labelAvance;
                                                      
    public EstudianteVO estudianteUsuario = new EstudianteVO("S180121878","123456","Victor Rendon", "vicren@gmail.com", "Asignado");
    Estudiante_DAO_Implements estudiante_DAO = new Estudiante_DAO_Implements();
    ObservableList<ReporteVO> reportesRecuperados = this.estudiante_DAO.recuperarReportes("2020-2021", this.estudianteUsuario.getMatricula());
    ProyectoVO proyectoRescatado = this.estudiante_DAO.recuperarProyecto("2020-2021", this.estudianteUsuario.getMatricula());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inicializarTabla();
    }    

    @FXML
    private void regresar(ActionEvent event) {
        
    }
    
    public void inicializarTabla(){
        //this.comlumnaCursos.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.ColumnaHorasCubiertas.setCellValueFactory(new PropertyValueFactory("horasReportadas"));
        this.columnaNombreReporte.setCellValueFactory(new PropertyValueFactory("numero"));
        this.comlumnaFechaEntrega.setCellValueFactory(new PropertyValueFactory("fechaCarga")); 
        this.tablaReportesEntregados.setItems(reportesRecuperados);
        calcularAvance();
        setNombreProyecto();
    }
    
    public void calcularAvance(){
        int suma = 0;
        //for(ListIterator<Tab> iterator = list.listIterator(); iterator.hasNext(); currentTab = iterator.next())
        for (ReporteVO tab: reportesRecuperados){
            suma+=tab.getHorasReportadas();
        }
        this.labelSetHorasRegistradas.setText(suma+"");
        float avance = (suma*100)/200;
        this.labelSetAvance.setText(avance+"%");
    }
    public void setNombreProyecto(){
        String nombreProyectoRecuperado = proyectoRescatado.getNombre();
        this.labelSetNombreProyecto.setText(nombreProyectoRecuperado);
    }
    
}
