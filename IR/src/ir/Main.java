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
        JFrameSegmentacion frame = new JFrameSegmentacion("wp",imagen);
    }
    
}
