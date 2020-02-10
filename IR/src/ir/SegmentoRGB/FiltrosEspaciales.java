/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.SegmentoRGB;

import ir.Herramientas.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author memotets89
 */
public class FiltrosEspaciales {
    
    public static Image generarGris(Image io){
        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
                color = new Color(prom,prom,prom);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }
   
    public static Image generarNegativo(Image io){
        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int r = 255-color.getRed();
                int g =  255-color.getGreen();
                int b = 255-color.getBlue();
                color = new Color(r,g,b);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    } 
    
    
    
    
    
    
}
