/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Liseners.Buttons;

import ir.GUI.Menu;
import ir.GUI.Views.IntImage;
import ir.GUI.RawView.ImageManager;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

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
        Image img = ImageManager.openImage();
        int ancho = img.getWidth(null)/2;
        int alto = img.getHeight(null)/2;
        Image imagen= ImageManager.toBufferedImage(img).getScaledInstance(ancho,alto, BufferedImage.TYPE_INT_BGR);
        
        IntImage wop = new IntImage(imagen);
        this.inicio.dispose();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
