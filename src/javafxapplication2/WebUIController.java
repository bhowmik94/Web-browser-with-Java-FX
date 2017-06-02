
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;

public class WebUIController implements Initializable {

    @FXML
    TextField txtURL;
    @FXML
    WebView webView;
    private WebEngine webEngine;
    
    WebHistory history;

    @FXML
    private void goAction(ActionEvent evt) {
        String link = txtURL.getText();
        if(link.startsWith("http://")) 
        {
            webEngine.load(link);
        }
        else if(link.endsWith("com")){
            webEngine.load("http://" + link);
        }
        else{
            webEngine.load("https://www.google.com/search?q=" + link);
        }
    }
    
    @FXML
     private void backAction(ActionEvent evt) {
         history = webEngine.getHistory();
         int sizeHistory = history.getEntries().size();
      if(sizeHistory>1)       {


          Entry entry = history.getEntries().get(sizeHistory-2); 

         webEngine.load(entry.getUrl());
        }
    }
     
     @FXML
    private void forwardAction(ActionEvent evt) {
        int sizeHistory = history.getEntries().size();
      if(sizeHistory>1)       {


          Entry entry = history.getEntries().get(sizeHistory-2);
          System.out.println("URL hist.: " + entry.getUrl());
         webEngine.load(entry.getUrl());
        }
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
        webEngine = webView.getEngine();
        webEngine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                txtURL.setText(newValue);
            }
        });
    }catch(Exception e)
    {
        System.out.println("Error");
    }
        
        
//    container.setBackground(new Background(new BackgroundImage(new Image("/res/img.jpg"), null, null, null, null)));
        
        
    }
    
    @FXML AnchorPane container;
}