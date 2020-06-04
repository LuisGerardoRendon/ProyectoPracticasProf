/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import javafx.scene.control.Alert;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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

}


