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
    public static Image Contraste(Image io, int min, int max){
          if (max < min ){
               int aux = max;
               max=min;
               min=aux;
          }

        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
         for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int r  = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                if (max!=min){
                    int nr = val((int) ((255/(max-min))*(r-min)));
                    int ng = val((int) ((255/(max-min))*(g-min)));
                    int nb = val((int) ((255/(max-min))*(b-min)));

                    bi.setRGB(i, j, new Color(nr,ng,nb).getRGB());
                }else{
                    int nr = val((int) ((255)*(r-min)));
                    int ng = val((int) ((255)*(g-min)));
                    int nb = val((int) ((255)*(b-min)));

                    bi.setRGB(i, j, new Color(nr,ng,nb).getRGB());
                }
            }
        }
        return ImageManager.toImage(bi);
    }
    
        public static Image Contraste(Histogramas h, Image imagen){

        BufferedImage bi = ImageManager.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-h.getMinR())*(255/h.getMaxR()-h.getMinR());
            int g = (color.getGreen()-h.getMinG())*(255/h.getMaxG()-h.getMinG());
            int b = (color.getBlue()-h.getMinB())*(255/h.getMaxB()-h.getMinB());
             color = new Color(val(r),
             val(g),
             val(b));
             bi.setRGB(x,y,color.getRGB());
        }
        return ImageManager.toImage(bi);
    }

        
    public static Image Ln(Image io){
        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int r  = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
             //((255/(max-min))*(r-min))
                int nr = val(flog(r));
                int ng = val(flog(g));
                int nb = val(flog(b));

                bi.setRGB(i, j, new Color(nr,ng,nb).getRGB());
            }
        }            
            return ImageManager.toImage(bi);
    }
    
        public static Image LnAlpha(Image io,int x){
        Image a = FiltrosEspaciales.generarLuz(io, x);
        BufferedImage bi = ImageManager.toBufferedImage(a);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int r  = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
             //((255/(max-min))*(r-min))
                int nr = val(Glog(r));
                int ng = val(Glog(g));
                int nb = val(Glog(b));

                bi.setRGB(i, j, new Color(nr,ng,nb).getRGB());
            }
        }            
            return ImageManager.toImage(bi);
    }
    
    public static Image Xp(Image io, double z){
        BufferedImage bi = ImageManager.toBufferedImage(io);
        Color color;
        for (int i=0; i< bi.getWidth(); i++ ){
            for (int j = 0 ; j<bi.getHeight(); j++){
                color = new Color(bi.getRGB(i,j));
                int r  = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
             //((255/(max-min))*(r-min))
                int nr = val(fxp(z,r));
                int ng = val(fxp(z,g));
                int nb = val(fxp(z,b));

                bi.setRGB(i, j, new Color(nr,ng,nb).getRGB());
            }
        }            
            return ImageManager.toImage(bi);
    }
    
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
                
                if (prom>umbral1 || prom <umbral2){
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

    private static int flog(int r) {
        return (int) ((255*Math.log(1+r))/Math.log(256));
    }
    private static int Glog(int r) {
        return  (int) ((255*loTao(1+r))/ loTao(256));
    }
    private static double loTao(int x)
    {
        return (int) (Math.log(x) / Math.log(1.12358) + 1e-10);
    }

    private static int fxp(double z,int r) {
        return (int) (Math.pow((1+z),r)/z);
    }

    
    
    
}
