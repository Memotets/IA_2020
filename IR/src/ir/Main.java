/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author memotets89
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image imagen = ImageManager.openImage();
        JFrameImage wop = new JFrameImage(imagen);
        BufferedImage ni = ImageManager.toBufferedImage(imagen);
        Color verde  = new Color(57,255,20);
        for (int i=0; i<100;i++){
            for (int j =0; j <100;j++){
                ni.setRGB(i,j, verde.getRGB());
            }
        }
        JFrameImage wop2 = new JFrameImage(ImageManager.toBufferedImage(ni));
    }
    
}
