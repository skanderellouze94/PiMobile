/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.Service;

import PIMobile.Entite.Produit;
import PIMobile.Entite.ProduitHerbo;
import Utils.CategorieProduitHerbo;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author elbrh
 */
public class ServiceProduit {
    
    public ArrayList<Produit> getProducts(){
         ArrayList<Produit> listProduit = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/produits/PrduitMobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println(tasks);
                    //System.out.println(tasks);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    for (Map<String, Object> obj : list) {
                        Produit produit = new Produit();
                      float id = Float.parseFloat(obj.get("idProduit").toString());        
                       produit.setId((int) id);
                        produit.setNom(obj.get("nom").toString());
                        produit.setPrix(Float.parseFloat(obj.get("prix").toString()));
                        produit.setDescription(obj.get("description").toString());
                        produit.setImage(obj.get("image").toString());
                        produit.setType(obj.get("type").toString());
                        listProduit.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduit;
    }
    
    public ProduitHerbo showProduitHerboo(int id){
        ProduitHerbo p = new ProduitHerbo();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/produits/"+id+"/showM");
        con.addResponseListener((NetworkEvent evt) -> {
           JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                Map<String, Object> list = (Map<String, Object>) tasks.get("idProduit");
                System.out.println(list);
                p.setId(id);                
                p.setNom(list.get("nom").toString());
                p.setPrix(Float.parseFloat(list.get("prix").toString()));
                p.setDescription(list.get("description").toString());
                p.setImage(list.get("image").toString());
                p.setType(list.get("type").toString());
                if("true".equals(tasks.get("bio").toString())){
                    p.setBio(true);
                }
                else{
                    p.setBio(false);
                }
                p.setCategorie(CategorieProduitHerbo.valueOf(tasks.get("categorie").toString()));
                
            }catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
       });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return p ;
        
    }
    
    
}
