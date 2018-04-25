/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.gui;

import PIMobile.Entite.Produit;
import PIMobile.Service.ServiceProduit;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author elbrh
 */
public class ProductList extends SideMenuBaseForm {

    Form f;
    Resources theme;

    public ProductList() {
        theme = UIManager.initFirstTheme("/theme");
        f = new Form("Shop", BoxLayout.y());
        ServiceProduit sp = new ServiceProduit();
        ArrayList<Produit> p = sp.getProducts();
        Container ctnlistProduct = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        super.setupSideMenu(f);
        for (Produit pr : p) {
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
            Container c = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label label = new Label();
            System.out.println(pr.getImage());
            int deviceWidth = Display.getInstance().getDisplayWidth() / 4;
            Image placeholder = Image.createImage(deviceWidth, deviceWidth); //square image set to 10% of screen width
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            label.setIcon(URLImage.createToStorage(encImage,
                    
                    "Large_" + "http://localhost/PiSymfony/web/uploads/images/products/" + pr.getImage()
                    + "", "http://localhost/PiSymfony/web/uploads/images/products/" + pr.getImage()
                    + "", URLImage.RESIZE_SCALE_TO_FILL));
            c.add(label);
            Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            cnt.getAllStyles().setPaddingLeft(2);
            cnt.add(pr.getNom());
            cnt.add(pr.getPrix() + "DT");
            c.add(cnt);
            Button show = new Button("Details");
            show.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ShowProduitHerbo sh = new ShowProduitHerbo(pr.getId());
                    sh.getF().show();
                    System.out.println(pr.getId());
                }
            } );            
            Container cnt1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            cnt1.add(show);
            cnt1.add(btn3);
            Container cc = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            cc.add(c);
            cc.add(cnt1);
            cc.getAllStyles().setBorder(Border.createGrooveBorder(2));
            ctnlistProduct.add(cc);
        }
        f.add(ctnlistProduct);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
