/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author Sourav
 */
public class TabPaneController implements Initializable{
    
    @FXML TabPane container;
    @FXML Tab initTab;
    
    

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
        Tab tab = new Tab();
        tab.setGraphic(new Button("+"));
        ((Button) tab.getGraphic()).setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                Tab t = new Tab("New tab");
                
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("WebUI.fxml"));
                    t.setContent(root);
                } catch (IOException ex) {
                    Logger.getLogger(TabPaneController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                container.getTabs().remove(tab);
                container.getTabs().addAll(t, tab);
            }
        });
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("WebUI.fxml"));
            initTab.setContent(root);
        } catch (IOException ex) {
            Logger.getLogger(TabPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        container.getTabs().add(tab);
    }
    
    
}
