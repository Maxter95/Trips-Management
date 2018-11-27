/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connection.MyConection;
import entite.reservation_hebergement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Maxter
 */
public class reservation_h {
     private Statement ste;
    Connection cnx;

    public reservation_h() {
        cnx = MyConection.getInstance().getConection();
    }
        
 public void ajoutereservation(reservation_hebergement r) throws SQLException {
     //ste.executeUpdate(req);
        String req = "INSERT INTO `reservation_hebergement` ( `idUtilisateurs`, `idHebergement`, `nom_utilisateur_h` ,`nbr_nuit_h` ) "
                + "VALUES (?,?,?,?)";
        
        PreparedStatement pre = cnx.prepareStatement(req);
        pre.setInt(1, r.getIdUtilisateurs());
        pre.setInt(2, r.getIdHebergement());
        pre.setString(3, r.getNom_utilisateur_h());
        pre.setInt(4, r.getNbr_nuit_h());  
        
        pre.executeUpdate();
        
    }
    
}
