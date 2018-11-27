/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyagefx;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import connection.MyConection;
import services.Crudes;
import entite.Hebergement;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author Maxter
 */
public class FXMLModifSuppController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<Hebergement> tab1;
 
    @FXML
    private TableColumn<Hebergement, String> tcAdresse;

    @FXML
    private TableColumn<Hebergement, String> tcDescription;
   @FXML
    private TableColumn<Hebergement, Integer> tcID;
    @FXML
    private TableColumn<Hebergement, String> tcType;

    @FXML
    private TableColumn<Hebergement, Integer> tcPrix;

    @FXML
    private TableColumn<Hebergement, Integer> tcDisponiblite;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtDisponibilite;

    @FXML
    private JFXTextField recherche;
    @FXML
    private JFXTextField txtPrix;
  @FXML
    private JFXTextField txtID;
    @FXML
    private JFXTextField txtType;
  @FXML
    private JFXButton btnSupp;
  @FXML
    private JFXButton btnModif;
    @FXML
    private JFXButton btnacc;
    @FXML
    private JFXTextField txtAdresse;
    @FXML
    private ObservableList<Hebergement> list1;
      @FXML
  
    public void LoadDataFromDatabase() {
        try {
            tab1.setVisible(true);
            Connection con = MyConection.getInstance().getConection();
            list1 = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM hebergement ORDER BY prix_hebergement ASC");
            while (rs.next()) {
                list1.add(new Hebergement( rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5),  rs.getInt(6), rs.getInt(7)));
                tab1.setItems(list1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        tcID.setCellValueFactory(new PropertyValueFactory<>("id_hebergement"));
        tcAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse_hebergement"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("type_hebergement"));
        tcPrix.setCellValueFactory(new PropertyValueFactory<>("prix_hebergement"));
        tcDisponiblite.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));
        
    }
       @FXML
    void supp(javafx.event.ActionEvent event) {
        Crudes s = new Crudes();
        Hebergement p = tab1.getSelectionModel().getSelectedItem();
       list1.remove(p);
       try {
            s.supprimerHebergement(p.getId_hebergement());
        }
        catch (SQLException ex) {
           Logger.getLogger(FXMLModifSuppController.class.getName()).log(Level.SEVERE, null, ex);
        }
       clear();
       LoadDataFromDatabase();
       Notifications notification11 = Notifications.create()
                    .title("felicitation")
                    .text("suppression termineé avec succée")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);

            notification11.darkStyle();
            notification11.showWarning();
    }

    @FXML
    void modif(javafx.event.ActionEvent event) {
        Crudes s1 = new Crudes();
        Hebergement p = tab1.getSelectionModel().getSelectedItem();
       //Hebergement p2= new Hebergement(Integer.parseInt(tcID.getText()),tcAdresse.getText(), tcDescription.getText(), tcType.getText(), Integer.parseInt(tcPrix.getText()),Integer.parseInt(tcDisponiblite.getText()));
        s1.update(p.getId_hebergement(),txtAdresse.getText(),txtDescription.getText(),txtType.getText(),Integer.parseInt(txtPrix.getText()),Integer.parseInt(txtDisponibilite.getText()));
        // s1.update(p.getId_utilisateur(),login.getText(), mot_passe.getText(), nom.getText(), addresse.getText(), Integer.parseInt(telephone.getText()),
             //    email.getText(), Integer.parseInt(patente.getText()), role.getText());
             tab1.refresh();
             clear();
        LoadDataFromDatabase();
        Notifications notification11 = Notifications.create()
                    .title("felicitation")
                    .text("modification termineé avec succée")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);

            notification11.darkStyle();
            notification11.showWarning();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         LoadDataFromDatabase();
            tab1.setOnMouseClicked( event -> {  
           
        Crudes s1 = new Crudes();
        Hebergement p = tab1.getSelectionModel().getSelectedItem();
        
       
        txtAdresse.setText(p.getAdresse_hebergement());
        txtDescription.setText(p.getDescription());
        txtType.setText(String.valueOf(p.getType_hebergement()));
         txtPrix.setText(String.valueOf(p.getPrix_hebergement()));
        
         txtDisponibilite.setText(String.valueOf(p.getDisponibilite()));
         });
            recherche.textProperty().addListener(new ChangeListener<String>(){
             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 filter(oldValue,newValue);
              
             }
        
    }); 
 }
    @FXML
    public void filter(String oldValue,String newValue){
        if (newValue==null ||oldValue.length()==newValue.length()||oldValue==null){
            tab1.setItems(list1);
        }
        else{
            ObservableList<Hebergement> filter=FXCollections.observableArrayList();
            for(Hebergement h:list1){
                if (h.getAdresse_hebergement().contains(newValue) || h.getType_hebergement().contains(newValue) || h.getDescription().contains(newValue))
                filter.add(h);
            }
            tab1.setItems(filter);
        }
        
    }
    @FXML
    private void acceuil(javafx.event.ActionEvent event) throws IOException {
        
        
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
