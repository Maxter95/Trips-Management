/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyagefx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import connection.MyConection;
import services.Crudes;
import entite.Hebergement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Maxter
 */
public class RechercheController implements Initializable {

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
    private JFXButton acce;
    @FXML
    private JFXTextField recherche;
    private ObservableList<Hebergement> list1;
      @FXML
       public void LoadDataFromDatabase() {
        try {
            tab1.setVisible(true);
            Connection con = MyConection.getInstance().getConection();
            list1 = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM hebergement ");
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         LoadDataFromDatabase();
           
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
    }    
    

