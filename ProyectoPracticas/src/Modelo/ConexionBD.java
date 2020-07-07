
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class ConexionBD {
    public String driver="com.mysql.jdbc.Driver";
    public String database="practilis";
    public String hostname="localhost";
    public String port="3306";
    public String url="jdbc:mysql://"+hostname+":"+port+"/"+database+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//(useSLL)Cancela el modo seguro para conectar a la base de datos
    public String username="root";
    public String password="Mysqlpale08";
    
    public Connection conectarMySQL(){
        Connection conn=null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException | SQLException e){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("ERROR BASE DE DATOS");
            alerta.setContentText("ERROR AL CONECTAR CON LA BASE DE DATOS " + e.getMessage());
            alerta.showAndWait();
        }
        return conn;
    }
}
