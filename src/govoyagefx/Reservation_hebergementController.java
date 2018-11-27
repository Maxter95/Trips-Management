/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package govoyagefx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import connection.MyConection;
import entite.Hebergement;
import entite.reservation_hebergement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.Crudes;
import services.reservation_h;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;    
/**
 * FXML Controller class
 *
 * @author Maxter
 */
public class Reservation_hebergementController implements Initializable {

    /**
     * Initializes the controller class.
     */ @FXML
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
    private JFXButton btnacc;
 @FXML
    private JFXTextField txtIDU;
@FXML
    private JFXButton btnRes;
    @FXML
    private JFXTextField txtNOM;

    @FXML
    private JFXTextField txtNBN;

    @FXML
    private JFXTextField txtIDH;
    @FXML
    private TableColumn<Hebergement, Integer> tcDisponiblite;
   @FXML
    private JFXTextField recherche;
    private ObservableList<Hebergement> list1;
      @FXML
  
    public void LoadDataFromDatabase() {
        int ko=1;
        try {
            tab1.setVisible(true);
            Connection con = MyConection.getInstance().getConection();
            list1 = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM hebergement where disponibilite='"+ko+"'  ORDER BY prix_hebergement ASC");
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
            tab1.setOnMouseClicked( event -> {  
                
           /*   tab1.setOnMouseClicked( event -> {  
           
        Crudes s1 = new Crudes();
        Hebergement p = tab1.getSelectionModel().getSelectedItem();
        
       
        txtAdresse.setText(p.getAdresse_hebergement());
        txtDescription.setText(p.getDescription());
        txtType.setText(String.valueOf(p.getType_hebergement()));
         txtPrix.setText(String.valueOf(p.getPrix_hebergement()));
        
         txtDisponibilite.setText(String.valueOf(p.getDisponibilite()));
         });*/
        Crudes s1 = new Crudes();
        Hebergement p = tab1.getSelectionModel().getSelectedItem();
        
        txtIDH.setText(String.valueOf(p.getId_hebergement()));
            });
             recherche.textProperty().addListener(new ChangeListener<String>(){
             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 filter(oldValue,newValue);
              
             }
        
    }); 
 }
    reservation_h res=new reservation_h();
    @FXML
    void reserver_button(ActionEvent event) throws SQLException, ClassNotFoundException {
      Statement ste;
    Connection cnx;

 
        cnx = MyConection.getInstance().getConection();
        
        reservation_hebergement srp=new reservation_hebergement( Integer.parseInt(txtIDU.getText()), Integer.parseInt(txtIDH.getText()),Integer.parseInt(txtNBN.getText()), (txtNOM.getText()) );
        res.ajoutereservation(srp);
        System.out.println("ok bb");
        Hebergement p = tab1.getSelectionModel().getSelectedItem();
       int idv=0;
       int k;
       int kk;
       k=p.getId_hebergement();
       kk=Integer.parseInt(txtIDU.getText());
//        idv = p.getDisponibilite();
//        int nbr=Integer.parseInt(txtNBN.getText());
      // req="  UPDATE params set value="10.70.19.6" where name="ldap_server";
        System.out.println(k);
      String sql;
sql = "UPDATE hebergement SET  disponibilite='" +idv+ "'    where id_hebergement='"+k+"'   ";
 try {
            ste = cnx.prepareStatement(sql);
                        ste.execute(sql);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
       

//res.update(p.setDisponibilite(0));
  tab1.refresh();
LoadDataFromDatabase();   

//********************mail******************
String sql2;
Statement st = cnx.createStatement(); 
String a = null;
 sql2= "select 	* from utilisateurs where idUtilisateurs='"+kk+"' "   ; 
 ResultSet rs = st.executeQuery(sql2);
while (rs.next()) {
 a=rs.getString(4);
}
        System.out.println(a);
try{String host ="smtp.gmail.com" ;
            String user = "mahmoudbeher.chebil@esprit.tn";
            String pass = "chichatoffah";
            String to = a;
            String from = "mahmoudbeher.chebil@esprit.tn";
            String subject = "felicitation reservation términé ";
            String messageText = "reservation terminer";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println("no");
        
    }}
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
    

