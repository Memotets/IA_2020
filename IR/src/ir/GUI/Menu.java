/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI;

import ir.GUI.Liseners.ButtonListener;
import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author memotets89
 */
public class Menu extends JFrame{
    Image img;
   
    public Menu (String title){
       this.setTitle(title);
        int ancho = 200;
        int alto = 100;
        //this.img = ImageManager.toBufferedImage(imagen).getScaledInstance(ancho,alto, BufferedImage.TYPE_INT_BGR);
        this.setSize(ancho, alto);
        intComponets();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrameImage.DISPOSE_ON_CLOSE);

   }

    private void intComponets() {
        this.setLayout(new BorderLayout());
        Button openImage = new Button();
        openImage.setName("Open Image");
        openImage.setLabel("Open Image");
        ButtonListener al = new ButtonListener(this);
        openImage.addActionListener(al);
        this.add(openImage, BorderLayout.CENTER);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
