/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import javafx.scene.control.Alert;

//ESTA CLASE SIRVE PARA MANDAR MENSAJES A LA PANTALLA

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Alerta {

    public void AlertaLoginNoEncontrado() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("USUARIO O CONTRASENIA NO ENCONTRADO");
        alerta.setContentText("Usuario no encontrado, por favor, registrate o vuelve a intentarlo");
        alerta.showAndWait();
    }
    public void AlertaException(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("EXCEPTION");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public void AlertaErrorBaseDeDatos(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("ERROR CON LA BASE DE DATOS");
        alerta.setContentText("Error al conectar con la base de datos : " + mensaje);
    }
    public void  AlertaUsuarioRegistradoExitosamente(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Usuario Registrado");
        alerta.setContentText("El usuario ha sido registrado exitosamente");
        alerta.showAndWait();
    }
    public void AlertaUsuarioNoElegido(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("TIPO DE USUARIO NO ELEGIDO");
        alerta.setContentText("Por Favor, elija un tipo de usuario");
        alerta.showAndWait();
    }
    public void alertaInformacion(String texto){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("INFORMACION");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }
    
    public void alertaArchivoNoElegido(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("ARCHIVO NO ELEGIDO");
        alerta.setContentText("Por favor selecciona un archivo");
        alerta.showAndWait();
    }
    
    public void alertaExtencionDeArchivoInvalida(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("EXTECCION DE ARCHIVO INVALIDA");
        alerta.setContentText("Solo se permiten archivos .docx y .pdf");
        alerta.showAndWait();
    }
    
    public void alertaCamposIncompletosReporte(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("DATOS INCOMPLETOS DEL REPORTE");
        alerta.setContentText("Por favor llena todos los campos requeridos");
        alerta.showAndWait();
    }
    
    public void alertaFechaInicio(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("FORMATO FECHA INICIO INVALIDO");
        alerta.setContentText("Por favor ingresa un formato de fecha valido");
        alerta.showAndWait();
    }
    
    public void alertaFechaFin(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("FORMATO FECHA FIN INVALIDO");
        alerta.setContentText("Por favor ingresa un formato de fecha valido");
        alerta.showAndWait();
    }
    
    public void alertaFormatoHoras(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("FORMATO DE HORAS INCORRECTO");
        alerta.setContentText("Por favor ingresa un formato de horas valido");
        alerta.showAndWait();
    }

}


