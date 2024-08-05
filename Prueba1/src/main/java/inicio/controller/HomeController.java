package inicio.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * Controlador para la vista principal (Home).
 */
public class HomeController implements Initializable {

    @FXML
    private BorderPane borderpane;
    
    @FXML
    private AnchorPane anchorpane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización del controlador
    }  
    
    @FXML
    private void inicio(MouseEvent event) {
        borderpane.setCenter(anchorpane);
    }

    @FXML
    private void productos(MouseEvent event) throws IOException {
        cargarMenu("productos");
    }

    @FXML
    private void vendedores(MouseEvent event) throws IOException {
        cargarMenu("vendedores");
    }

    @FXML
    private void realizarVenta(MouseEvent event) throws IOException {
        cargarMenu("realizarVenta");
    }

    /**
     * Método que maneja el evento de clic en el botón "SALIR".
     * Cierra la ventana actual y abre una nueva ventana con la pantalla de login.
     */
    @FXML
    private void salir(MouseEvent event) throws IOException {
        // Cargar el archivo FXML del login
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        
        // Obtener la ventana actual (Stage) y cerrarla
        Stage stage = (Stage) borderpane.getScene().getWindow();
        stage.close();
        
        // Crear una nueva ventana para la pantalla de login
        Stage loginStage = new Stage();
        loginStage.setScene(new Scene(root));
        
        // No se usa StageStyle.UNDECORATED para que los botones de acción se vean
        //loginStage.initStyle(StageStyle.UNDECORATED); // Opcional: sin bordes de ventana
        
        loginStage.show();
    }
    
    /**
     * Método auxiliar para cargar una vista en la región central del BorderPane.
     * @param pagina El nombre del archivo FXML a cargar (sin la extensión).
     */
    private void cargarMenu(String pagina) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + pagina + ".fxml"));
        borderpane.setCenter(root);
    }
}
