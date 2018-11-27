/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Maxter
 */
public class reservation_hebergement {
  private int   idUtilisateurs	;
  private int idHebergement;
  private int nbr_nuit_h;
  private String nom_utilisateur_h;

    public int getIdUtilisateurs() {
        return idUtilisateurs;
    }

    public void setIdUtilisateurs(int idUtilisateurs) {
        this.idUtilisateurs = idUtilisateurs;
    }

    public int getIdHebergement() {
        return idHebergement;
    }

    public void setIdHebergement(int idHebergement) {
        this.idHebergement = idHebergement;
    }

   

    public String getNom_utilisateur_h() {
        return nom_utilisateur_h;
    }

    public void setNom_utilisateur_h(String nom_utilisateur_h) {
        this.nom_utilisateur_h = nom_utilisateur_h;
    }

    public reservation_hebergement() {
    }

    public int getNbr_nuit_h() {
        return nbr_nuit_h;
    }

    public void setNbr_nuit_h(int nbr_nuit_h) {
        this.nbr_nuit_h = nbr_nuit_h;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public reservation_hebergement(int idUtilisateurs, int idHebergement, int nbr_nuit_h, String nom_utilisateur_h) {
        this.idUtilisateurs = idUtilisateurs;
        this.idHebergement = idHebergement;
        this.nbr_nuit_h = nbr_nuit_h;
        this.nom_utilisateur_h = nom_utilisateur_h;
    }

    @Override
    public String toString() {
        return "reservation_hebergement{" + "idUtilisateurs=" + idUtilisateurs + ", idHebergement=" + idHebergement + ", nbr_nuit_h=" + nbr_nuit_h + ", nom_utilisateur_h=" + nom_utilisateur_h + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final reservation_hebergement other = (reservation_hebergement) obj;
        if (this.idUtilisateurs != other.idUtilisateurs) {
            return false;
        }
        return true;
    }

  
  
    
}
