/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.RawView;

import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author memotets89
 */
public class DrawOnBuffered{
    
    public static void Circulo ( Image imagen, int radioPixel){
         BufferedImage ni = ImageManager.toBufferedImage(imagen);
         int centroImagen[] = {imagen.getWidth(null)/2,imagen.getHeight(null)/2};
         
         for (int i =0; i < 360; i++){
             int x = (int)(radioPixel*Math.cos((i*2*Math.PI)/360)+centroImagen[0]); // x en polares 
             int y = (int)(radioPixel*Math.sin((i*2*Math.PI)/360)+centroImagen[1]); // y en polares
             
             ni.setRGB(x, y, Color.BLACK.getRGB());
             ni.setRGB(x-1, y, Color.BLACK.getRGB());
             ni.setRGB(x-1, y-1, Color.BLACK.getRGB());
             ni.setRGB(x, y-1, Color.BLACK.getRGB());
             ni.setRGB(x+1, y-1, Color.BLACK.getRGB());
             ni.setRGB(x+1, y, Color.BLACK.getRGB());
             ni.setRGB(x+1, y+1, Color.BLACK.getRGB());
             ni.setRGB(x, y+1, Color.BLACK.getRGB());
             ni.setRGB(x-1, y+1, Color.BLACK.getRGB());
         }
         
         JFrameImage wop = new JFrameImage(ImageManager.toBufferedImage(ni));
         wop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
//    public static void DrawBat(Image imagen){
//        BufferedImage ni = ImageManager.toBufferedImage(imagen);
//         int centroImagen[] = {imagen.getWidth(null)/2,imagen.getHeight(null)/2};
//         
//         
//    }
    
}
