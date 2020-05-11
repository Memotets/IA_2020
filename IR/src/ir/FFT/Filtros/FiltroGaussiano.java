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
public class FiltroGaussiano extends FiltroFrecuencia{
     private int orden;
    private int radio;
    private Dimension dim;
    private Image imagen;
    private boolean pasaAltas;
    public FiltroGaussiano(int r, Dimension dim, boolean pasaAltas) {
        super(dim.width,dim.height);
        this.radio = r;
        this.dim = dim;
        this.pasaAltas = pasaAltas;
        
        this.imagen = null;
    }
    
    @Override
    public void crearFiltro() {
        int tamanoImagen = (int)dim.getWidth();
        int center = (tamanoImagen/2);
        double valor;
        for(int i=0; i < tamanoImagen;i++){
            for(int j=0; j < tamanoImagen;j++){            
                int u = i-center;
                int v = j-center;
                double DistanceC = Math.pow(u,2)+Math.pow(v, 2);
                if(!this.pasaAltas) valor = Math.exp(-DistanceC/(2*radio*radio)); //Gauss
                else valor = 1-Math.exp(- DistanceC/(2*radio*radio));

                getFiltroEspacial()[i][j] = new NumeroComplejo(valor,1);
               
            //double valor = Math.exp(-Math.pow(Distance, 2)/Math.pow(radio, 2));
                     
            }
        }    
        this.imagen = FiltroFrecuencia.toImageDeComplejo(super.getFiltroEspacial());
    }
    public void modificarFiltro(int orden, int radio){
      this.orden = orden;
      this.radio = radio;
      crearFiltro();
    }

    /**
     * @return the imagen
     */
    public Image getImagen() {
        return imagen;
    }
}
