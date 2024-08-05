
package inicio.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {
     @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void handleLoginButtonAction(ActionEvent event) throws IOException {
        verificarCasillas();
        imprimirConsola();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void verificarCasillas(){
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
            showAlert("Error en el login", "Ingresa un usuario y contraseña valido.");
        }else{
            try {
                realizarAccion();
            } catch (Exception e) {
                showAlert("Error al logearse", "Ocurrio un error al cargar la scena");
            }
        }
    }
    
    public void realizarAccion() throws IOException{
        Stage stage = (Stage)loginButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    
    public void showAlert(String title,String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    public void imprimirConsola(){
        String usuario = usernameField.getText();
        String contra = passwordField.getText();
        System.out.println("Usuario: "+ usuario + "\nContraseña:" + contra );
    }
    
}
