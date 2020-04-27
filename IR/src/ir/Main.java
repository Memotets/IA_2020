/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.Espacial.FiltrosEspaciales;
import ir.Espacial.Mascaras;
import ir.Espacial.Suavisado;
import ir.FFT.Gestor;
import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;



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
        //generar imagen escalada en grises
        int Escala = 512;
        io = ImageManager.toBufferedImage(io).getScaledInstance(Escala,Escala, BufferedImage.TYPE_INT_BGR);
        //io = FiltrosEspaciales.generarGris(io);
        
        JFrameImage jfi = new JFrameImage(io);
        
        Gestor gio = new Gestor(ImageManager.toBufferedImage(io));
        
        BufferedImage frec =gio.obtenerImagenFrecuencias(true);
        Image freQ = ImageManager.toImage(frec);
        JFrameImage jfF = new JFrameImage(freQ);
        
        Random ran= new Random();
        int aux = ran.nextInt();
        //guardar imagenes
        ImageManager.GuardarImagen(io, "original"+aux);
        ImageManager.GuardarImagen(freQ, "espectro"+aux);
        System.out.println("Listo");
    }
    
}
