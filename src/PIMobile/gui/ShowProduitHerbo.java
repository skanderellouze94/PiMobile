/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.gui;

import PIMobile.Entite.ProduitHerbo;
import PIMobile.Service.ServiceProduit;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

/**
 *
 * @author elbrh
 */
public class ShowProduitHerbo {

    int id;
    Form f;

    public ShowProduitHerbo(int id) {
        
        
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c.setWidth(Display.getInstance().getDisplayWidth());
        ServiceProduit sp = new ServiceProduit();
        ProduitHerbo pr = sp.showProduitHerboo(id);
        int deviceWidth = Display.getInstance().getDisplayWidth()/2;
        Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        URLImage imgsv = URLImage.createToStorage(encImage,
                 "http://localhost/PiSymfony/web/uploads/images/products/" + pr.getImage(),
                "http://localhost/PiSymfony/web/uploads/images/products/" + pr.getImage()
                , URLImage.RESIZE_SCALE_TO_FILL);
                ImageViewer imgvb = new ImageViewer(imgsv);
        Label nom = new Label("Nom : " + pr.getNom());
        Label desc = new Label("Description : " + pr.getDescription());
        Label prix = new Label("Prix : " + pr.getPrix());
        Label bio = new Label("Bio : " + pr.getBio());
        Label Categorie = new Label("Categorie : " + pr.getCategorie());
        c.add(imgvb);
        c.add(nom);
        c.add(desc);
        c.add(prix);
        c.add(bio);
        c.add(Categorie);
         f = new Form(pr.getNom(), new BoxLayout(BoxLayout.Y_AXIS));
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToRightBar("Back", FontImage.MATERIAL_ARROW_BACK, g->
            {
            ProductList a = new ProductList();
                a.getF().show();
            });

        c.getAllStyles().setBorder(Border.createUnderlineBorder(3));
        Button btn3 = new Button("Add To Cart");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Cart.setProduct(p);
                Dialog d = new Dialog("Quantite");
                TextField txt = new TextField();
                txt.setConstraint(TextField.NUMERIC);
                txt.setText(Basket.getQuantite(pr) + "");
                d.add(txt);
                d.dispose();
                Button ok = new Button("Ok");
                Button close = new Button("Close");
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Basket b = new Basket();
                        b.addToBasket(pr, Integer.parseInt(txt.getText()));
                        d.dispose();
                        System.out.println(txt.getText());
                    }
                });
                close.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        d.dispose();
                    }
                });
                d.add(ok);
                d.add(close);
                d.showDialog();
            }
        });
       
        f.add(c);
        f.add(btn3);

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
