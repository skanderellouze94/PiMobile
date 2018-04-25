/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.gui;

import PIMobile.Entite.Produit;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author elbrh
 */
public class Basket {

    private Form current;
    private Resources theme;
    Container all;
    Form f2 = new Form(BoxLayout.y());
    float total = 0;
    static Map<Produit,Integer> produits ;
    
    public void addToBasket(Produit p , int q){
        if (produits == null  ){
            produits = new HashMap<>();
            produits.put(p, q);
        System.out.println(produits.size());
        }else {
            if(produits.containsKey(p)){
                 produits.remove(p);
                 produits.put(p, q); 
             }
            else{
               produits.put(p, q); 
            }
           
        System.out.println(produits.size());
        }
        
    }
    
    
    public static int getQuantite(Produit p){
        int q= 1 ;
        if(produits != null && produits.containsKey(p) ){
            q= produits.get(p);
        }       
            return q ;
    }
    

    public Form getF(){
        return current;
    }
    
}
