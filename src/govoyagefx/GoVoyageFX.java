///////*
////// * To change this license header, choose License Headers in Project Properties.
////// * To change this template file, choose Tools | Templates
////// * and open the template in the editor.
////// */
//////package govoyagefx;
//////
//////import connection.MyConection;
//////import crudes.Crudes;
//////import hebergement.Hebergement;
//////import java.io.IOException;
//////import java.util.List;
//////import javafx.application.Application;
//////import static javafx.application.Application.launch;
//////import javafx.fxml.FXMLLoader;
//////import javafx.scene.Parent;
//////import javafx.scene.Scene;
//////import javafx.stage.Stage;
//////import javafx.stage.StageStyle;
//////
///////**
////// *
////// * @author Maxter
////// */
//////public class GoVoyageFX extends Application {
//////    
//////    @Override
//////    public void start(Stage primaryStage) throws IOException {
//////        
//////        Parent root = FXMLLoader.load(getClass().getResource("FXML0.fxml"));
//////        
//////        Scene scene = new Scene(root);
//////        Stage stage = new Stage();
//////        stage.setScene(scene);
//////        stage.show();
//////        
//////    }
//////
//////    /**
//////     * @param args the command line arguments
//////     */
//////    public static void main(String[] args) {
//////        launch(args);
//////        
//////          MyConection myConection = MyConection.getInstance();
//////        MyConection myConection2 = MyConection.getInstance();
//////        Hebergement h = new Hebergement ("fd","sdf","fqsd","fsd","fqsd",0);
//////    }
//////    
//////}