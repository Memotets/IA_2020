/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir;

import ir.FFT.Filtros.*;

import ir.FFT.Gestor;
import ir.FFT.NumeroComplejo;
import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author memotets89
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //Menu prueba = new Menu("Hola mundo");
        int [][]  puntos;
        Image io = ImageManager.openImage();
        //generar imagen escalada en grises
        int Escala = 512;
        io = ImageManager.toBufferedImage(io).getScaledInstance(Escala, Escala, BufferedImage.TYPE_INT_BGR);
        //io = FiltrosEspaciales.generarGris(io);
        JFrameImage jfi = new JFrameImage(io);
//
        Gestor gio = new Gestor(ImageManager.toBufferedImage(io));
        BufferedImage frec = gio.obtenerImagenFrecuencias(true);
        Image freQ = ImageManager.toImage(frec);
        JFrameImage jfF = new JFrameImage(freQ, true);
        
        do{
            System.err.println("Waiting...");
            sleep(1000);
        }while(jfF.getLista().size()<3);
        puntos = convertIntegers(jfF.getLista());
        //FiltroPasaAltas fpa = new FiltroPasaAltas(100, new Dimension(Escala,Escala)); 
        FiltroSelectivo fpa = new FiltroSelectivo(10, new Dimension(Escala, Escala), puntos);
        fpa.crearFiltro();
        NumeroComplejo[][] filtro = fpa.getFiltroEspacial();
        JFrameImage frameFil = new JFrameImage(fpa.getImagen());

        gio.aplicarFiltro(filtro);
        Image finale = ImageManager.toImage(gio.obtenerImagenEspacial());
        JFrameImage frame = new JFrameImage(finale);
//        
        Image FQTry = ImageManager.toImage(gio.obtenerImagenFrecuencias(true));
        JFrameImage wop = new JFrameImage(FQTry);

        Random ran = new Random();
        int aux = ran.nextInt();
        //guardar imagenes
        ImageManager.GuardarImagen(io, "original"+aux);
        ImageManager.GuardarImagen(freQ, "espectro"+aux);
        ImageManager.GuardarImagen(fpa.getImagen(), "Filtro"+aux);
        ImageManager.GuardarImagen(finale, "Imagen filtrada"+aux);
        ImageManager.GuardarImagen(FQTry, "espectro filtrado"+aux);
        System.out.println("Listo");
    }

    public static int[][] convertIntegers(ArrayList<Integer[]> integers)
{
    int[][] ret = new int[integers.size()][integers.get(0).length];
    for (int i=0; i < ret.length; i++)
    {
        ret[i] =  toPrimitive(integers.get(i));
    }
    return ret;
}
    public static int[] toPrimitive(Integer[] IntegerArray) {

	int[] result = new int[IntegerArray.length];
	for (int i = 0; i < IntegerArray.length; i++) {
		result[i] = IntegerArray[i].intValue();
	}
	return result;
}
}
