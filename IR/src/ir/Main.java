/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.Herramientas.ImageManager;
import ir.Herramientas.JFrameImage;
import ir.SegmentoRGB.FiltrosEspaciales;
import ir.SegmentoRGB.Histogramas;
import ir.SegmentoRGB.UmbralizacionAutomatica;
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
        Histogramas h = new Histogramas(imagen);
        Image io = FiltrosEspaciales.toBin(imagen);
        Image io2 = FiltrosEspaciales.toBin(
                imagen,UmbralizacionAutomatica.metodoOtsu(
                   h.getGrey()
                )
        );
        
        JFrameImage wop = new JFrameImage(imagen);
        JFrameImage wop2 = new JFrameImage(io);
        JFrameImage wop3 = new JFrameImage(io2);
     //  JFrameSegmentacion frame = new JFrameSegmentacion("wp",io);
    }
    
}
