/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import ir.Espacial.FiltrosEspaciales;
import ir.Espacial.Histogramas;
import ir.Espacial.UmbralizacionAutomatica;
import ir.GUI.Menu;
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
       // Menu prueba = new Menu("Hola mundo");
        Image imagen = ImageManager.openImage();
        Image w1 = FiltrosEspaciales.generarGris(imagen);
        Histogramas h = new Histogramas(w1);
        h.GraphGrey();
        
        Image w2 = FiltrosEspaciales.eculizarImagen(w1);
        h = new Histogramas(w2);
        h.GraphGrey();
        JFrameImage wop = new JFrameImage(w1);
        JFrameImage wop2 = new JFrameImage(w2);
        
//        Image io = FiltrosEspaciales.toBin(imagen);
//        Image io2 = FiltrosEspaciales.toBin(
//                imagen,UmbralizacionAutomatica.metodoOtsu(
//                   h.getGrey()
//                )
//        );
//        
//        JFrameImage wop = new JFrameImage(imagen);
//        JFrameImage wop2 = new JFrameImage(io);
//        JFrameImage wop3 = new JFrameImage(io2);
     //  JFrameSegmentacion frame = new JFrameSegmentacion("wp",io);
    }
    
}
