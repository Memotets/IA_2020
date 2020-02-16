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
    public static Image fondol(Image io, int umbral1, int umbral2){
          //en caso de que tenga un mal orden los umbrales
          if (umbral1 < umbral2 ){
               int aux = umbral1;
               umbral1=umbral2;
               umbral2=aux;
          }
                
                
        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
                
                if (prom>umbral1){
                    bi.setRGB(i, j, Color.WHITE.getRGB());
                }
                if (prom <umbral2){
                    bi.setRGB(i, j, Color.WHITE.getRGB());
                }
            }
        }
        return ImageManager.toImage(bi);
    }
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

        public static Image generarLuz(Image io, int light){
        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                color = new Color(
                        val(color.getRed()+light),
                        val(color.getGreen()+light),
                        val(color.getBlue()+light)
                );
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
    public static Image generarInfrarojo(Image io, int red){
        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int g = color.getGreen();
                int aux = color.getRed()+red;
                int aux2 = color.getBlue()-red;          
                color = new Color(val(aux),g,val(aux2));
                bi.setRGB(i, j, color.getRGB());
            }
        }
        return ImageManager.toImage(bi);
    }     
    
    public static int val(int x){
        if (x > 255) return 255;
        else if (x<0) return 0;
        else return x;
    } 
    
    
    
}
