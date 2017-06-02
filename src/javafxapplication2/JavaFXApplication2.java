
package javafxapplication2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFXApplication2 extends Application {

    @Override
    public void start(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("TabPane.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(JavaFXApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Sourav's Web Browser");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}