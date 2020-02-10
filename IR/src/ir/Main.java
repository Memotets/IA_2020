/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.Herramientas.ImageManager;
//import ir.Herramientas.DrawOnBuffered;
import ir.Herramientas.JFrameImage;
import ir.SegmentoRGB.FiltrosEspaciales;
import ir.SegmentoRGB.Histogramas;
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
        Image imagen = ImageManager.openImage();
        JFrameImage wop   = new JFrameImage(imagen);
        JFrameImage wop2 = new JFrameImage( FiltrosEspaciales.generarGris(imagen));
        JFrameImage wop3 = new JFrameImage( FiltrosEspaciales.generarNegativo(imagen));
        Histogramas prueba  = new Histogramas(wop.getImagen());
        Histogramas prueba2= new Histogramas(wop2.getImagen());
        Histogramas prueba3= new Histogramas(wop3.getImagen());
        prueba.Graph();
        prueba.GraphGrey();
        prueba2.Graph();
        prueba3.Graph();
//        DrawOnBuffered.Circulo(imagen,100);
//        
         
    }
    
}
