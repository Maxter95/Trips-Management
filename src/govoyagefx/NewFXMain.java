/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyagefx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Maxter
 */
public class NewFXMain extends Application {
    
    @Override
  public void start (Stage primaryStage) throws IOException{
      

        Parent root =FXMLLoader.load(getClass().getResource("FXML0.fxml"));
                primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void acceuil(Stage stage) throws Exception {
       
       
        Parent root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
       
        Scene scene = new Scene(root);
        
        
        stage.setScene(scene);
        
        stage.show();}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
