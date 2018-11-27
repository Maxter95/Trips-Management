/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





package services;


import connection.MyConection;
import entite.Hebergement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxter
 */
public class Crudes {
     private Statement ste;
    Connection cnx;

    public Crudes() {
        cnx = MyConection.getInstance().getConection();
    }

    public void ajouterHebergement(Hebergement P) {
        String requette = "INSERT INTO hebergement (id_hebergement,disponibilite,adresse_hebergement,description,type_hebergement,prix_hebergement) values ('" + P.getId_hebergement() + "','" + P.getDisponibilite() + "','"+P.getAdresse_hebergement() + "','"+P.getDescription() + "','"+P.getType_hebergement() +"','"+P.getPrix_hebergement() +"')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requette);
            System.out.println("GG Again!!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

//    public void supprimerHebergement(int id_hebergement)throws SQLException {
//        String requette = "DELETE FROM hebergement where ('" + id_hebergement + "'=id_hebergement)";
//        try {
//            Statement st = cnx.createStatement();
//            st.executeUpdate(requette);
//            System.out.println("ok!!");
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
    public void supprimerHebergement(int id_hebergement) throws SQLException {
        String sql = "DELETE FROM hebergement WHERE id_hebergement=?";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt(1, id_hebergement);
        statement.executeUpdate();
    }

//    public void modifierHebergement(Hebergement P) {
//        String requette = "UPDATE hebergement set adresse_hebergement=?,description=?,type_hebergement=?,prix_hebergement=?,disponibilite=? where id_hebergement=?";
//
//        try {
//            PreparedStatement pst = cnx.prepareStatement(requette);
//     
//            pst.setString(1, P.getAdresse_hebergement());
//            pst.setString(2, P.getDescription());
//            pst.setString(3, P.getType_hebergement());
//            pst.setInt(4, P.getPrix_hebergement());
//            pst.setInt(5, P.getDisponibilite());
//            pst.setInt(6, P.getId_hebergement());
//            
//            pst.executeUpdate();
//            System.out.println("okkkkk!!!!!");
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }

//    }

   //**************
  public void update( int id_hebergement,String adresse_hebergement, String type_hebergement, String description,  int prix_hebergement,  int disponibilite) {
// id_hebergement,
        String sql;
 sql = "UPDATE hebergement SET  adresse_hebergement='" + adresse_hebergement+ "',type_hebergement='" + type_hebergement +"',description='" + description +"',prix_hebergement='" + prix_hebergement +"',disponibilite='" + disponibilite + "'where id_hebergement='"+id_hebergement+"'";
       //     id_hebergement='" + id_hebergement + "',

        try {
            ste = cnx.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
        try {
            ste.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       }



    //***********
     
//    public List<Hebergement> searchByAdresse(String adresse) {
//        String req = "SELECT * FROM hebergement WHERE adresse like '"+adresse+"%'";
//        //System.out.println(req);
//        List<Hebergement> hebergementList = new ArrayList();
//        try {
//            PreparedStatement ps = cnx.prepareStatement(req);
//            //ps.setString(1, adresse);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Hebergement c = new Hebergement(rs.getInt(1), rs.getString(2), rs.getString(3), 
//                        rs.getString(4), rs.getInt(5), rs.getInt(6));
//                hebergementList.add(c);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Crudes.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return hebergementList;
//    }
    public List<Hebergement> displayAll() {
List<Hebergement> maListe = new ArrayList();
        try {
            
            Statement st = cnx.createStatement();
            String requette = "SELECT * from hebergement ";
            ResultSet rs = st.executeQuery(requette);
            
            while (rs.next()) {
                Hebergement P=new Hebergement();
                P.setId_hebergement(rs.getInt(1));
                P.setDisponibilite(rs.getInt(2));
                P.setAdresse_hebergement(rs.getString(3));
                P.setDescription(rs.getString(4));
                P.setType_hebergement(rs.getString(5));
                 P.setPrix_hebergement(rs.getInt(6));
                
                maListe.add(P);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());  
        }

        return maListe;
    }
    
}
