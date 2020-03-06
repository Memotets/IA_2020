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
    private Integer minR,maxR;
    private Integer minG,maxG;
    private Integer minB,maxB;
    Grafica graph;

    public Grafica getGraph() {
        return graph;
    }

    public void setGraph(Grafica graph) {
        this.graph = graph;
    }

    public Histogramas(Image in) {
        this.R = new double[256];
        this.G = new double[256];
        this.B = new double[256];
        this.Grey = new double[256];

        this.RecolectarColores(in);
        calcularMinimosYMaximos();  
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
    
    public void Graph(boolean grafico){
           this.graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(R, "Rojo");
           graph.agregarSerie(B, "Azul");
           graph.agregarSerie(G, "Verde");
           
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
           plot.getRenderer().setSeriesPaint(1, new Color(Color.BLUE.getRGB()));
           plot.getRenderer().setSeriesPaint(2, new Color(Color.GREEN.getRGB()));
           if (grafico) graph.muestraGrafica();
    }
    public void GraphGrey(){
           this.graph = new Grafica("Magnitud","Frecuencia","Histograma de grises");
           graph.agregarSerie(Grey, "Gris");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.DARK_GRAY.getRGB()));
          graph.muestraGrafica();
    }
    public void GraphRed(){
           this.graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(R, "Rojo");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
           graph.muestraGrafica();
    }
    public void GraphBlue(){
           this.graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(B, "Azul");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.BLUE.getRGB()));
           graph.muestraGrafica();
    }
    public void GraphGreen(){
           this.graph = new Grafica("Magnitud","Frecuencia","Histograma de imagen");
           graph.agregarSerie(G, "Verde");
           graph.crearGrafica();
           XYPlot plot = graph.getGrafica().getXYPlot();
           plot.getRenderer().setSeriesPaint(0, new Color(Color.GREEN.getRGB()));
           graph.muestraGrafica();
    }
    private void calcularMinimosYMaximos(){
    this.minR = -1;
    this.minG = -1;
    this.minB = -1;
    this.maxR = 256;
    this.maxG = 256;
    this.maxB = 256;

    for(int t1 = 0, t2= R.length-1; minR==-1 || maxR==256 ;t1++,t2--){
        if(R[t1]!=0 && minR ==-1){
            minR = t1;
        }
        if(R[t2]!=0 && maxR==256){
            maxR = t2;
        }
       
    }

    for(int t1 = 0, t2= G.length-1; minG==-1 || maxG==256 ;t1++,t2--){
        if(G[t1]!=0 && minG ==-1){
            minG = t1;
        }
        if(G[t2]!=0 && maxG==256){
            maxG = t2;
        }
       
    }

    for(int t1 = 0, t2= B.length-1; minB==-1 || maxB==256 ;t1++,t2--){
        if(B[t1]!=0 && minB ==-1){
            minB = t1;
        }
        if(B[t2]!=0 && maxB==256){
            maxB = t2;
        }
       
    }
    
   System.out.println();

 }
    
    public double[] getHRed(){
        return this.R;
    }
    public double[] getHBlue(){
        return this.B;
    }
    public double[] getHGreen(){
        return this.G;
    }
    public double[] getGrey(){
        return this.Grey;
    }
    public int getMinR(){
        return this.minR;
    }
    public int getMaxR(){
        return this.maxR;
    }

    public int getMinG(){
        return this.minG;
    }
    public int getMaxG(){
        return this.maxG;
    }

    public int getMinB(){
        return this.minB;
    }
    public int getMaxB(){
        return this.maxB;
    }
    
}
