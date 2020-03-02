/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.Herramientas.ImageManager;
//import ir.Herramientas.DrawOnBuffered;
import ir.Herramientas.JFrameImage;
import ir.Herramientas.JFrameSegmentacion;
import ir.SegmentoRGB.FiltrosEspaciales;
import static ir.SegmentoRGB.FiltrosEspaciales.Contraste;
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
        JFrameImage wop= new JFrameImage(imagen);
        Histogramas ha = new Histogramas(wop.getImagen());
        ha.Graph(true);
//        JFrameImage wop2 = new JFrameImage(FiltrosEspaciales.Contraste(ha, imagen));
//        ha = new Histogramas(wop2.getImagen());
//        ha.Graph(true);
        JFrameImage wop3 = new JFrameImage(FiltrosEspaciales.LnAlpha(imagen,-90));
        ha = new Histogramas(wop3.getImagen());
        ha.Graph(true);
      // JFrameSegmentacion frame = new JFrameSegmentacion("wp",imagen);
    }
    
}
