/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.FFT.Filtros;

import ir.FFT.NumeroComplejo;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author memotets89
 */
public class FiltroSelectivo extends FiltroFrecuencia{
    
     private Image imagen;
     private Dimension dim;
     private int radio;
     private int [][] points;

    public FiltroSelectivo(int radio, Dimension dim, int filtro[][]) {
        super((int)dim.getWidth(),(int) dim.getHeight());
        this.points = filtro;
        this.radio = radio;
        this.dim = dim;
        this.imagen = null;
    }

    @Override
    public void crearFiltro() {
        int tamanoImagen = (int)dim.getWidth(); 
        for(int i=0; i < tamanoImagen;i++){
                for(int j=0; j < tamanoImagen;j++){
                    getFiltroEspacial()[i][j] = new NumeroComplejo(1, 1);
                }
         }//filtro vacio
                
         for (int[] point : this.points) {
             int x = point[0];
             int y = point[1];
             int x_ = tamanoImagen-x;
             int y_ = tamanoImagen-y;
             for(int i=0; i < tamanoImagen;i++){
                 for(int j=0; j < tamanoImagen;j++){
                     int u = -1*x+i;
                     int v = y-j;
                     
                     int u_= -1*x_+i;
                     int v_ = y_-j;
                     
                     double r = Math.sqrt(Math.pow(u,2)+Math.pow(v, 2));
                     double r_ = Math.sqrt(Math.pow(u_,2)+Math.pow(v_, 2));
                     // verificamos con respecto al  radio
                     if(r<=this.radio){
                         // asignamos el valor al filtro
                         getFiltroEspacial()[i][j] = new NumeroComplejo(0, 0);
                     }
                     if(r_<=this.radio){
                         // asignamos el valor al filtro
                         getFiltroEspacial()[i][j] = new NumeroComplejo(0, 0);
                     }
                 }
             }
         }
         this.imagen = FiltroFrecuencia.toImageDeComplejo(super.getFiltroEspacial());
    }
    
    public Image getImagen() {
        return imagen;
    }
    
    
}
