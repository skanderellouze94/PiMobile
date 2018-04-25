/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.gui;

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author elbrh
 */
public class SideMenuBaseForm extends Form {

    public void setupSideMenu(Form f) {
        f.getToolbar().addMaterialCommandToSideMenu("  Home", FontImage.MATERIAL_DASHBOARD, e -> new ProductList().getF().show());
        // getToolbar().addMaterialCommandToSideMenu("  My Shops", FontImage.MATERIAL_TRENDING_UP,  e -> new MyBoutique1(res).show());
        f.getToolbar().addMaterialCommandToSideMenu("  Cart", FontImage.MATERIAL_TRENDING_UP, e -> new Basket().getF().show());

    }

}
