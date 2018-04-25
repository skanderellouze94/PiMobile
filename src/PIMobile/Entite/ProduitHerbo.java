/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Entite;

import Utils.CategorieProduitHerbo;
/**
 *
 * @author elbrh
 */
public class ProduitHerbo extends Produit {
    
    private boolean bio  ; 
    private String marque ;
    private CategorieProduitHerbo categorie ;

   

    
    /******************* Constructor *****************************************/
    
     public ProduitHerbo() {
         super();
    }
    
    
    
 
    
    /////*********** Getter & Setter ***********///////
    
    
    public boolean getBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie.name();
    }

    public void setCategorie(CategorieProduitHerbo categorie) {
        this.categorie = categorie;
    }


    /************ toString ***************///
    
    
    @Override
    public String toString() {
        return  super.toString() + "Produit_herbo{" + "bio=" + bio + ", marque=" + marque + ", categorie=" + categorie.name() + "}";
    }
    
    
    
    
    
    
    
    
}
