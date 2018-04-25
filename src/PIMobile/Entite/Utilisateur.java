/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Entite;



/**
 *
 * @author user
 */
public class Utilisateur {
   private int id;
   private String nom;
   private String prenom;
   private String username;
   private String username_canonical;
   private String email;
   private String email_canonical;
   private String password;
   private String adresse;
   private String date_naissance;
   private int code_postal;
   private String sexe;
   private String roles;
   private int num_tel;
   private String photo_profil;
   private String pays;
   private String type_partenaire;
   private String specialite_partenaire;

   

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUsername() {
        return username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

  

    public String getPassword() {
        return password;
    }


    public int getCode_postal() {
        return code_postal;
    }

    public String getSexe() {
        return sexe;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public String getPhoto_profil() {
        return photo_profil;
    }

    public String getPays() {
        return pays;
    }

    public String getType_partenaire() {
        return type_partenaire;
    }

    public String getSpecialite_partenaire() {
        return specialite_partenaire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

 
 
    
    public Utilisateur() {
    }

  
    @Override
    public String toString() {
        return username;
    }
   
   
   
}
