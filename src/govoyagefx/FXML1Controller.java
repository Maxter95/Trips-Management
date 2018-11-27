/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyagefx;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Maxter
 */
public class FXML1Controller implements Initializable {

    @FXML
    private AnchorPane proilePANE;
    
public static AnchorPane rootS;
    @FXML
    private JFXHamburger menuBTN;

    @FXML
    private ImageView imageLogo;

    @FXML
    private JFXDrawer menu;

    @FXML
    private TitledPane gr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         rootS = proilePANE;
         
         
         translationLogo();
          try {
            VBox box = FXMLLoader.load(getClass().getResource("/govoyagefx/Vboxx.fxml"));
            menu.setSidePane(box);
        } catch (IOException ex) {
          
        }
                  HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(menuBTN);
        transition.setRate(-1);
        menuBTN.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(menu.isShown())
            {
                menu.close();
            }else
                menu.open();
        });
        // TODO
        
    }   
     public void translationLogo()
    {
          FadeTransition lettreTransin = new FadeTransition(Duration.seconds(2), imageLogo);
            lettreTransin.setFromValue(0);
            lettreTransin.setToValue(1);
            lettreTransin.setCycleCount(1);
            lettreTransin.play();
            
            FadeTransition lettreTransOut = new FadeTransition(Duration.seconds(2), imageLogo);
            lettreTransOut.setFromValue(1);
            lettreTransOut.setToValue(0);
            lettreTransOut.setCycleCount(1);
            
            lettreTransin.setOnFinished((e)->{
                lettreTransOut.play();
            });
            
            lettreTransOut.setOnFinished((e)->{
                lettreTransin.play();
            });
    }
    
     @FXML
   private void exitMenu() {

          if(menu.isShown())
            {
                menu.close();
            }
        }
    
       @FXML
   private void startMenu() {

          
                menu.open();
            
        }
   
}
