/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Maxter
 */
public class Hebergement {
    private int id_hebergement;
    private String adresse_hebergement;
    private String description;
    private String type_hebergement;
    private int prix_hebergement;
    private int disponibilite;

    public Hebergement() {
    }

    public Hebergement(String adresse_hebergement, String description, String type_hebergement, int prix_hebergement, int disponibilite) {
        this.adresse_hebergement = adresse_hebergement;
        this.description = description;
        this.type_hebergement = type_hebergement;
        this.prix_hebergement = prix_hebergement;
        this.disponibilite = disponibilite;
    }

    public Hebergement(int id_hebergement, String adresse_hebergement, String description, String type_hebergement, int prix_hebergement, int disponibilite) {
        this.id_hebergement = id_hebergement;
        this.adresse_hebergement = adresse_hebergement;
        this.description = description;
        this.type_hebergement = type_hebergement;
        this.prix_hebergement = prix_hebergement;
        this.disponibilite = disponibilite;
    }

    public Hebergement(int id_hebergement, String adresse_hebergement, String type_hebergement, int prix_hebergement, int disponibilite) {
        this.id_hebergement = id_hebergement;
        this.adresse_hebergement = adresse_hebergement;
        this.type_hebergement = type_hebergement;
        this.prix_hebergement = prix_hebergement;
        this.disponibilite = disponibilite;
    }

    public int getId_hebergement() {
        return id_hebergement;
    }

    public void setId_hebergement(int id_hebergement) {
        this.id_hebergement = id_hebergement;
    }

    public String getAdresse_hebergement() {
        return adresse_hebergement;
    }

    public void setAdresse_hebergement(String adresse_hebergement) {
        this.adresse_hebergement = adresse_hebergement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_hebergement() {
        return type_hebergement;
    }

    public void setType_hebergement(String type_hebergement) {
        this.type_hebergement = type_hebergement;
    }

    public int getPrix_hebergement() {
        return prix_hebergement;
    }

    public void setPrix_hebergement(int prix_hebergement) {
        this.prix_hebergement = prix_hebergement;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public String toString() {
        return "Hebergement{" + "id_hebergement=" + id_hebergement + ", adresse_hebergement=" + adresse_hebergement + ", description=" + description + ", type_hebergement=" + type_hebergement + ", prix_hebergement=" + prix_hebergement + ", disponibilite=" + disponibilite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id_hebergement;
        return hash;
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
        final Hebergement other = (Hebergement) obj;
        if (this.id_hebergement != other.id_hebergement) {
            return false;
        }
        return true;
    }

    
}
