/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Liseners;

import ir.GUI.Menu;
import ir.GUI.Views.IntImage;
import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author memotets89
 */
public class ButtonListener implements ActionListener{
    private Menu inicio;
    
    public ButtonListener(Menu x){
        this.inicio = x;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Image imagen = ImageManager.openImage();
        IntImage wop = new IntImage(imagen);
        this.inicio.dispose();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
