/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.Espacial;

import static ir.Espacial.FiltrosEspaciales.val;
import ir.GUI.RawView.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Suavisado {
    public static Image mix (Image io, double x){
        return 
                InyectarRuidoBlanco(
                        InyectarRuidoNegro(io, x/2),
                        x/2);
    }
    public static Image InyectarRuidoBlanco(Image io, double x){
        BufferedImage bfi = ImageManager.toBufferedImage(io);
        double max = bfi.getHeight()* bfi.getWidth();
        int total = (int) (max*x/100);
        int white = Color.WHITE.getRGB();
        
        Random h = new Random();
        Random w = new Random();
            
        while (total!=0){
            int n1 = w.nextInt(bfi.getWidth());
            int n2 = h.nextInt(bfi.getHeight());
            bfi.setRGB(n1, n2, white);
            total--;
        }      
        return ImageManager.toImage(bfi); 
    }
    public static Image InyectarRuidoNegro(Image io, double x){
        BufferedImage bfi = ImageManager.toBufferedImage(io);
        double max = bfi.getHeight()* bfi.getWidth();
        int total = (int) (max*x/100);
        int white = Color.BLACK.getRGB();
        
        Random h = new Random();
        Random w = new Random();
            
        while (total!=0){
            int n1 = w.nextInt(bfi.getWidth());
            int n2 = h.nextInt(bfi.getHeight());
            bfi.setRGB(n1, n2, white);
            total--;
        }      
        return ImageManager.toImage(bfi); 
    }
    public static Image suavizar(Image io,int[][] mascara){

        BufferedImage bi = ImageManager.toBufferedImage(io);
        BufferedImage bnuevo = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        // recorres el buffer
        for(int x=0; x < bi.getWidth();x++){
            for(int y=0; y < bi.getHeight();y++){
            int rgb = calcularNuevoTono(x,y,bi,mascara);
            bnuevo.setRGB(x, y, rgb);
            }
        }
        return ImageManager.toImage(bnuevo);
    }

    private static int calcularNuevoTono(int x, int y, BufferedImage bi, int[][] mascara) {
        

        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        int k = 0;
        for(int i = 0 , r = x -1; i<mascara.length;i++, r++){
            for(int j = 0, c = y -1; j < mascara[0].length;j++, c++){
                if(mascara[i][j]!=0){
                    try {
                        int rgb = bi.getRGB(r, c);
                        k++;
                        color = new Color(rgb);
                        auxR+= color.getRed();
                        auxG+= color.getGreen();
                        auxB+= color.getBlue();
                        
                    } catch (Exception e) {
                        // nada de nada 
                    }
                }
            }
        }
        if(k!=0){
        auxR/=k;
        auxG/=k;
        auxB/=k;}
        color = new Color(auxR,auxG,auxB);
        return color.getRGB();
    }
    
    public static Image convolucion(Image io,int[][] mascara,int d, int o){

        BufferedImage bi = ImageManager.toBufferedImage(io);
        BufferedImage bnuevo = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        // recorres el buffer
        for(int x=0; x < bi.getWidth();x++){
            for(int y=0; y < bi.getHeight();y++){
            int rgb = tonoConvolucion(x,y,bi,mascara,d,o);
            bnuevo.setRGB(x, y, rgb);
            }
        }
        return ImageManager.toImage(bnuevo);
    }
    private static int tonoConvolucion(int x, int y, BufferedImage bi, int[][] mascara, int divisor, int offset) {
        

        int auxR = 0, auxG = 0, auxB = 0;
        Color color = null;
        for(int i = 0 , r = x -1; i<mascara[0].length;i++, r++){
            for(int j = 0, c = y -1; j < mascara[0].length;j++, c++){
                    try {
                        int rgb = bi.getRGB(r, c);
                        color = new Color(rgb);
                        auxR+= color.getRed()*mascara[i][j];
                        auxG+= color.getGreen()*mascara[i][j];
                        auxB+= color.getBlue()*mascara[i][j];
                        
                    } catch (Exception e) {
                        // nada de nada 
                    }
                }
            }
        auxR/=divisor;
        auxG/=divisor;
        auxB/=divisor;
        color = new Color(val(auxR+offset),val(auxG+offset),val(auxB+offset));
        return color.getRGB();
    }
    
}
