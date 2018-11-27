/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyagefx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author HD_EXECUTION
 */
public class FXML0Controller implements Initializable {


    @FXML
    private AnchorPane splashpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplashScreen().start();
    }    
    
    class SplashScreen extends Thread
    {
        @Override
        public void run()
        {
            try {
                Thread.sleep(2000);
                  Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                     Parent root;
                try {
                     root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("govoyage");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        
                  
                         splashpane.getScene().getWindow().hide();
                } catch (IOException ex) {
                    Logger.getLogger(FXML0Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                                    }
                });
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(FXML0Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}