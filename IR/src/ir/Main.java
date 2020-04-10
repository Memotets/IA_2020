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
        int mascaras[][][] = {
            {
                {0,-1,0},
                {-1,5,-1},
                {0,-1,0}
            },//Enfoque
            {
                {1,1,1},
                {1,1,1},
                {1,1,1}
            },//Desenfoque
            {
                {0,0,0},
                {-1,1,0},
                {0,0,0}
            },//Borde
            {
                {0,1,0},
                {1,-4,1},
                {0,1,0}
            },//Bordes
            {
                {-2,-1,0},
                {-1,1,1},
                {0,1,2}
            }//Repujado
        };
        for (int i =0; i<mascaras.length;i++){
            Image i1;
            if (i!=1) i1 = Suavisado.convolucion(io, mascaras[i], 1, 0);
            else i1 = Suavisado.convolucion(io, mascaras[i], 9, 0);
            ImageManager.GuardarImagen(i1, "Imagen_"+i);
        }
        System.out.println("Listo");
    }
    
}
