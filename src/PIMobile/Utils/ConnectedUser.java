/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Utils;

import PIMobile.Entite.Utilisateur;

/**
 *
 * @author elbrh
 */
public class ConnectedUser {
    
    static Utilisateur u ;
    
    public static void setUser(Utilisateur u){
        ConnectedUser.u = u ;
    }
    
    public static Utilisateur getUser(){
        return u ;
    }
    
    
    
}
