/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Liseners.Buttons;


import ir.GUI.Views.IntImage;
import ir.GUI.Views.SliderView;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author memotets89
 */
public class Effect implements ActionListener{
    private IntImage inicio;
    private int mode;
    
    public Effect(IntImage x, int mode){
        this.inicio = x;
        this.mode = mode;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Image imagen = this.inicio.getInit();
        SliderView wop = new SliderView(imagen,this.mode);
        this.inicio.dispose();
    }
    
}
