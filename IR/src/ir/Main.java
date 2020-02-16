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
        Histogramas nuevo = new Histogramas(imagen);
        nuevo.Graph();
        JFrameImage wop3   = new JFrameImage(FiltrosEspaciales.fondol(imagen, 30,220));
        nuevo = new Histogramas(wop3.getImagen());
        nuevo.Graph(); 
    }
    
}
