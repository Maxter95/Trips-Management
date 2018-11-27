/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyagefx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import services.Crudes;
import entite.Hebergement;
import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Maxter
 */
public class FXMLDocumentController implements Initializable {
        @FXML
    private JFXButton btnAjouter;

    @FXML
    private JFXButton btnSupprimer;

    @FXML
    private JFXTextField txtAdresse;

    @FXML
    private JFXTextField txtDescription;
       public int error = 0 ;
     public String dateerror = "" ;
    @FXML
    private JFXTextField txtType;

    @FXML
    private JFXTextField txtPrix;

    @FXML
    private JFXTextField txtDisponibilite;

    @FXML
    private JFXButton btnAcceuil;
    
//    @FXML
//    private javafx.scene.control.Button btnAjouter;
//
//
//    @FXML
//    private javafx.scene.control.Button btnSupprimer;
//
//    @FXML
//    private javafx.scene.control.TextField txtAdresse;
//
//    @FXML
//    private javafx.scene.control.TextField txttype;
//
//    @FXML
//    private javafx.scene.control.TextField txtPrix;
//
//    @FXML
//    private javafx.scene.control.TextField txtNom;
//
//    @FXML
//    private javafx.scene.control.TextField txtNote;
//
//    @FXML
//    private javafx.scene.control.TextField txtVille;
//    @FXML
//    private JFXButton btnAcceuil;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    Crudes sh=new Crudes();
    @FXML
    private void ajouter(ActionEvent event) {
//*******

dateerror=" ";
        
         
       
           if( txtAdresse.getText().isEmpty() || 
                  txtDescription.getText().isEmpty() || 
                  txtType.getText().isEmpty() || 
                  txtPrix.getText().isEmpty() ||
                  txtDisponibilite.getText().isEmpty()  
                   )
         {
               
              dateerror="Please check the Fields";
               
            Alert alrt = new Alert(Alert.AlertType.ERROR);
            alrt.setTitle("Alert");
            alrt.setHeaderText("Input Error");
            alrt.setContentText(dateerror);
            alrt.showAndWait();
         }

           else if (Integer.parseInt(txtDisponibilite.getText())>1 ||Integer.parseInt(txtDisponibilite.getText())<0){
               dateerror="la valeur de  diponibilite doit etre comprise entre 1 si disponible et 0 sinon";
               
            Alert alrt = new Alert(Alert.AlertType.ERROR);
            alrt.setTitle("Alert");
            alrt.setHeaderText("Input Error");
            alrt.setContentText(dateerror);
            alrt.showAndWait();
               
           }
//******
//         else if ((txtDisponibilite.getText()).length() != 0){
//             try {
//
//                int i = Integer.parseInt(txtDisponibilite.getText());
//
//            } catch (Exception e) {
//
//                dateerror += "Le nombre candidat doit etre un entier\n";
//
//            }
//               dateerror="la valeur de  diponibilite doit etre comprise entre 1 si disponible et 0 sinon";
//               
//            Alert alrt = new Alert(Alert.AlertType.ERROR);
//            alrt.setTitle("Alert");
//            alrt.setHeaderText("Input Error");
//            alrt.setContentText(dateerror);
//            alrt.showAndWait();
//               
//           }
        
        
           else{
        
       Hebergement heb = new Hebergement( (txtAdresse.getText()), (txtDescription.getText()), (txtType.getText()), Integer.parseInt(txtPrix.getText()),Integer.parseInt(txtDisponibilite.getText()));
        
            sh.ajouterHebergement(heb);
             clear();
             
           // List<Hebergement> list = sh.afficher();//chargina liste bech n3abeha fi able view 

           //ObservableList<Hebergement> items = FXCollections.observableArrayList(list);//bech n3abiwha baaed fi tabview //bech nhot fih les objets taa liste 

           // tabView.setItems(items);

       Notifications notification11 = Notifications.create()
                    .title("felicitation")
                    .text("ajout termineé avec succée")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);

            notification11.darkStyle();
            notification11.showWarning();
    }}
    @FXML
    private void acceuil(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }
     private void clear() {
        txtAdresse.setText("");
        txtDescription.setText("");
        txtType.setText("");
        txtPrix.setText("");
        txtDisponibilite.setText("");
        
        
         }

     
}

