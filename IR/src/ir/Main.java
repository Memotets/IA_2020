/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.Espacial.FiltrosEspaciales;
import ir.FFT.Filtros.FiltroPasaAltas;
import ir.FFT.Filtros.FiltroPasaBajas;
import ir.FFT.Gestor;
import ir.FFT.NumeroComplejo;
import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.Dimension;
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
        io = FiltrosEspaciales.generarGris(io);
        JFrameImage jfi = new JFrameImage(io);
        
        Gestor gio = new Gestor(ImageManager.toBufferedImage(io));
        BufferedImage frec =gio.obtenerImagenFrecuencias(true);
        Image freQ = ImageManager.toImage(frec);
        JFrameImage jfF = new JFrameImage(freQ);
        
        FiltroPasaAltas fpa= new FiltroPasaAltas(35, new Dimension(Escala,Escala));
        fpa.crearFiltro();
        NumeroComplejo [][] filtro = fpa.getFiltroEspacial();
        JFrameImage  frameFil = new JFrameImage(fpa.getImagen());
        gio.aplicarFiltro(filtro);
        
        BufferedImage imagenEspacial = gio.obtenerImagenEspacial();
        Image finale = ImageManager.toImage(imagenEspacial);
        JFrameImage  frame = new  JFrameImage (finale);
        
        
        //--intento de conseguir el expectro filtrado
        
        Gestor gTry = new Gestor(ImageManager.toBufferedImage(finale));
        BufferedImage fTry =gTry.obtenerImagenFrecuencias(true);
        Image FQTry = ImageManager.toImage(fTry);
        JFrameImage JFTry = new JFrameImage(FQTry);
        
        Random ran= new Random();
        int aux = ran.nextInt();
        //guardar imagenes
        ImageManager.GuardarImagen(io, "original"+aux);
        ImageManager.GuardarImagen(freQ, "espectro"+aux);
        ImageManager.GuardarImagen(finale, "Imagen filtrada"+aux);
        ImageManager.GuardarImagen(FQTry, "espectro filtrado"+aux);
        System.out.println("Listo");
    }
    
}
