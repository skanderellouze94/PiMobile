/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Entite;

import Utils.TypeCommande;

/**
 *
 * @author elbrh
 */
public class Commande {
    
    private int id_commande;
    private Produit produit ;
    private Utilisateur id_user ;
    private int quantite;

    public  TypeCommande statu ; // 0 non pret , 1 pret 
    
    
    
    /******* Constructor ****/
    public Commande() {
        produit = new Produit();
        id_user = new  Utilisateur();
    }

    public Commande(Produit id_produit, Utilisateur id_user, int quantite) {
        this.produit = id_produit;
        this.id_user = id_user;
        this.quantite = quantite;
    }

    
    
    
    
     public int getId_commande() {    
        return id_commande;    
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    
    
    

    public String getStatu() {
        return statu.name();
    }

    /****** Getter & Setter *****/
    public void setStatu(TypeCommande statu) {
        this.statu = statu;
    }


    public Utilisateur getId_user() {
        return id_user;
    }

    public void setId_user(Utilisateur id_user) {
        this.id_user = id_user;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    


    
       /**
     * toString();
     */

    @Override
    public String toString() {
        return "Commande{" + "produit=" + produit.toString() + ", id_user=" + id_user + ", quantite=" + quantite + '}';
    }
    
}
