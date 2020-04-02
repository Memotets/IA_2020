/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.Espacial.FiltrosEspaciales;
import ir.Espacial.Mascaras;
import ir.Espacial.Suavisado;
import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.Image;



/**
 *
 * @author memotets89
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Menu prueba = new Menu("Hola mundo");
        
        Image io = ImageManager.openImage();
        //io = FiltrosEspaciales.generarGris(io);
        JFrameImage jfi = new JFrameImage(io);
        Image i1 = Mascaras.Robert(io);
        JFrameImage jf1 = new JFrameImage(i1);
        Image i2 = Mascaras.Prewitt(io);
        JFrameImage jf2 = new JFrameImage(i2);
        Image i3 = Mascaras.Sobel(io);
        JFrameImage jf3 = new JFrameImage(i3);
        Image i4 = Mascaras.Kirsch(io);
        JFrameImage jf4 = new JFrameImage(i4);
        
        ImageManager.GuardarImagen(i1, "Robert");
        ImageManager.GuardarImagen(i2, "Prewitt");
        ImageManager.GuardarImagen(i3, "Sobel");
        ImageManager.GuardarImagen(i4, "Kirsch");
        System.out.println("Listo");
    }
    
}
