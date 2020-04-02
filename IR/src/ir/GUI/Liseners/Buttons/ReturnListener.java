/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Liseners.Buttons;

import ir.GUI.Menu;
import ir.GUI.RawView.ImageManager;
import ir.GUI.Views.IntImage;
import ir.GUI.Views.SliderView;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author memotets89
 */
public class ReturnListener implements ActionListener{
    private SliderView inicio;
    boolean addFiller;
    
    public ReturnListener(SliderView x, boolean n){
        this.inicio = x;
        this.addFiller =n;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Image imagen;
        if (addFiller) imagen = this.inicio.getResult();
        else imagen = this.inicio.getImg();
        
        IntImage wop = new IntImage(imagen);
        this.inicio.dispose();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
