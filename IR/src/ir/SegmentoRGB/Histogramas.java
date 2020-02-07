/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.SegmentoRGB;
import ir.Graficar.Grafica;
import ir.Herramientas.ImageManager;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import org.jfree.chart.plot.XYPlot;
/**
 *
 * @author memotets89
 */
public class Histogramas {

    double R[],G[],B[],Grey[];

    public Histogramas(Image in) {
        this.R = new double[256];
        this.G = new double[256];
        this.B = new double[256];
        this.Grey = new double[256];
        
        this.RecolectarColores(in);
        this.Graph();
        this.GraphGrey();
    }
    
    private void RecolectarColores( Image in){
        BufferedImage ni = ImageManager.toBufferedImage(in);
        for (int i =0; i< in.getWidth(null); i++){
            for (int j=0; j<in.getHeight(null);j++){
                int color = ni.getRGB(i, j);
                Color seg =  new Color(color);
                R[seg.getRed()] ++;
                G[seg.getGreen()]++;
                B[seg.getBlue()]++;
                Grey[(seg.getBlue()+seg.getGreen()+seg.getRed())/3]++;
            }
        }
    }
    
    private void Graph(){
           Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(R, "Rojo");
           graph.agregarSerie(B, "Azul");
           graph.agregarSerie(G, "Verde");
           
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
           plot.getRenderer().setSeriesPaint(1, new Color(Color.BLUE.getRGB()));
           plot.getRenderer().setSeriesPaint(2, new Color(Color.GREEN.getRGB()));
           graph.muestraGrafica();
//           plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
    }
    
    private void GraphGrey(){
           Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de grises");
           graph.agregarSerie(Grey, "Gris");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.DARK_GRAY.getRGB()));
           graph.muestraGrafica();
    }
    
    private void GraphRed(){
           Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(R, "Rojo");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
           graph.muestraGrafica();
    }
    private void GraphBlue(){
           Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(B, "Azul");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.BLUE.getRGB()));
           graph.muestraGrafica();
    }
    private void GraphGreen(){
           Grafica graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(G, "Verde");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.GREEN.getRGB()));
           graph.muestraGrafica();
    }
    
    
}
