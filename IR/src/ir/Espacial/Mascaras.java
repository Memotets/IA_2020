/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.Espacial;

import ir.GUI.RawView.ImageManager;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author memotets89
 */
public class Mascaras {
    public static int[][] RobertX = {
            {0,0,0},
            {0,0,1},
            {0,-1,0}
        };
        
    public static int[][] RobertY ={
            {-1,0,0},
            {0,1,0},
            {0,0,0}
        };
    public static int[][] PrewittX = {
            {-1,0,1},
            {-1,0,1},
            {-1,0,1}
        };
        
    public static int[][] PrewittY ={
            {-1,-1,-1},
            {0,0,0},
            {1,1,1}
        };
    public static int[][] SobelX = {
            {-1,0,1},
            {-2,0,2},
            {-1,0,1}
        };
        
    public static int[][] SobelY ={
            {-1,-2,-1},
            {0,0,0},
            {1,2,1}
        };
    public static int[][] KirschX = {
            {-3,-3,5},
            {-3,0,5},
            {-3,-3,5}
        };
        
    public static int[][] KirschY ={
            {5,5,5},
            {-3,0,-3},
            {-3,-3,-3}
        };
    
    public static Image Robert(Image io){
        Image i = FiltrosEspaciales.generarGris(io);
        Image ci1 = Suavisado.convolucion(i, RobertX, 1, 0);
        Image ci2 = Suavisado.convolucion(i, RobertY, 1, 0);
        
        BufferedImage GX = ImageManager.toBufferedImage(ci1);
        BufferedImage GY = ImageManager.toBufferedImage(ci2);
        int alto = GX.getHeight();
        int ancho = GX.getWidth();
        BufferedImage buffer = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        for(int x=0; x<ancho;x++) for(int y=0; y<alto;y++) buffer.setRGB(x, y, (GX.getRGB(x, y)+GY.getRGB(x, y)));
        return ImageManager.toImage(buffer);      
    }
    
    public static Image Prewitt(Image io){
        Image i = FiltrosEspaciales.generarGris(io);
        Image ci1 = Suavisado.convolucion(i, PrewittX, 1, 0);
        Image ci2 = Suavisado.convolucion(i, PrewittY, 1, 0);
        
        BufferedImage GX = ImageManager.toBufferedImage(ci1);
        BufferedImage GY = ImageManager.toBufferedImage(ci2);
        int alto = GX.getHeight();
        int ancho = GX.getWidth();
        BufferedImage buffer = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        for(int x=0; x<ancho;x++) for(int y=0; y<alto;y++) buffer.setRGB(x, y, (GX.getRGB(x, y)+GY.getRGB(x, y)));
        return ImageManager.toImage(buffer);      
    }
    
    public static Image Sobel(Image io){
        Image i = FiltrosEspaciales.generarGris(io);
        Image ci1 = Suavisado.convolucion(i, SobelX, 1, 0);
        Image ci2 = Suavisado.convolucion(i, SobelY, 1, 0);
        
        BufferedImage GX = ImageManager.toBufferedImage(ci1);
        BufferedImage GY = ImageManager.toBufferedImage(ci2);
        int alto = GX.getHeight();
        int ancho = GX.getWidth();
        BufferedImage buffer = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        for(int x=0; x<ancho;x++) for(int y=0; y<alto;y++) buffer.setRGB(x, y, (GX.getRGB(x, y)+GY.getRGB(x, y)));
        return ImageManager.toImage(buffer);      
    }
    
    public static Image Kirsch(Image io){
        Image i = FiltrosEspaciales.generarGris(io);
        Image ci1 = Suavisado.convolucion(i, KirschX, 1, 0);
        Image ci2 = Suavisado.convolucion(i, KirschY, 1, 0);
        
        BufferedImage GX = ImageManager.toBufferedImage(ci1);
        BufferedImage GY = ImageManager.toBufferedImage(ci2);
        int alto = GX.getHeight();
        int ancho = GX.getWidth();
        BufferedImage buffer = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
        for(int x=0; x<ancho;x++) for(int y=0; y<alto;y++) buffer.setRGB(x, y, (GX.getRGB(x, y)+GY.getRGB(x, y)));
        return ImageManager.toImage(buffer);      
    }
}
