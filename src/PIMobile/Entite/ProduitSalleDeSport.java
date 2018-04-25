/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Entite;

import Utils.TypeProduitSalleDeSport;

/**
 *
 * @author elbrh
 */
public class ProduitSalleDeSport extends Produit{
    
    private TypeProduitSalleDeSport type ;

    ////////////************ Constructor *****************//////////////

    public ProduitSalleDeSport() {
        super();
    }
    
    
    public ProduitSalleDeSport(TypeProduitSalleDeSport type, String nom, String description, String image, float prix) {
        super( nom, description, image, prix);
        this.type = type;
      // this.salle = salle ;
    }

    
    /////////*********** Getter & Setter **********************//////////////
    public String getType() {
        return type.toString();
    }

    public void setType(TypeProduitSalleDeSport type) {
        this.type = type;
    }

   
    
    
    
    
    
}
