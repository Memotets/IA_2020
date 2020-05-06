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
public class FiltroButterWorth extends FiltroFrecuencia{
    
    private int orden;
    private int radio;
    private Dimension dim;
    private Image imagen;

    public FiltroButterWorth(int n, int r, Dimension dim) {
        super(dim.width,dim.height);
        this.orden = n;
        this.radio = r;
        this.dim = dim;
        this.imagen = null;
    }
    
    @Override
    public void crearFiltro() {
        int tamanoImagen = (int)dim.getWidth();
        int center = (tamanoImagen/2);
        int n2 = 2*orden;
        for(int i=0; i < tamanoImagen;i++){
            for(int j=0; j < tamanoImagen;j++){            
                int u = i-center;
                int v = j-center;
                double Duv = Math.sqrt(Math.pow(u,2)+Math.pow(v, 2));
                double valor = 1/(1+(Math.pow(Duv/radio,2*orden))); // Bw
                //double valor = Math.exp(-Math.pow(Duv, 2)/Math.pow(radio, 2)); //Gauss
                getFiltroEspacial()[i][j] = new NumeroComplejo(valor,valor);
               
            //double valor = Math.exp(-Math.pow(Duv, 2)/Math.pow(radio, 2));
                     
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
