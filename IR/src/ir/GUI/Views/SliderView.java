/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Views;

import ir.Espacial.FiltrosEspaciales;
import ir.Espacial.Histogramas;
import ir.Espacial.Suavisado;
import ir.Espacial.UmbralizacionAutomatica;
import ir.GUI.Liseners.Buttons.ButtonListener;
import ir.GUI.Liseners.Buttons.ReturnListener;
import ir.GUI.Liseners.Slider.SlideChange;
import ir.GUI.RawView.JFrameImage;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import org.jfree.chart.ChartFrame;

/**
 *
 * @author memotets89
 */
public class SliderView extends JFrame{
    private JSlider u1,u2;
    private JLabel ILabel;
    private Image img, result;
    private Component wop;
    
    public SliderView(Image imagen, int i) {
        this.setTitle("Modificacion");
        this.img = imagen;
        intComponets(i);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrameImage.EXIT_ON_CLOSE);
    }

    private void intComponets(int i) {
        setLayout(new BorderLayout());
        this.ILabel = new JLabel(new ImageIcon(this.img));
        this.add(this.ILabel, BorderLayout.CENTER);
        
        this.u1 = new JSlider();
        this.u1.setMinorTickSpacing(1);
        this.u1.setMajorTickSpacing(15);
        this.u1.setMinimum(0);
        this.u1.setMaximum(255);
        this.u1.setValue(0);
        
        
        this.u2 = new JSlider();
        this.u2.setMinorTickSpacing(1);
        this.u2.setMajorTickSpacing(15);
        this.u2.setMinimum(0);
        this.u2.setMaximum(255);
        this.u2.setValue(255);
        
        this.result = this.img;
        InyectarGrafica(this.img);
        JPanel panel = new JPanel(new GridLayout(3,1));
        SlideChange cl =null;
        Histogramas graph =null;
        
        //implementar una forma de agregar mascara deseada
        int[][] mascara = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        switch(i){
                case 0:
                    this.result =  FiltrosEspaciales.generarGris(img);
                    this.ILabel.setIcon( new ImageIcon(this.result));
                    this.remove(wop);
                    this.InyectarGrafica(result);
                    break;
                case 1:
                    this.result = FiltrosEspaciales.generarNegativo(img);
                    this.ILabel.setIcon( new ImageIcon(this.result));
                    this.remove(wop);
                    this.InyectarGrafica(result);
                    break;
                case 2:
                    u1.setMinimum(-255);
                    cl = new SlideChange(this,1);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 3:
                    u1.setMinimum(-255);
                    cl = new SlideChange(this,2);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 4:
                    cl = new SlideChange(this,3);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 5:
                    cl = new SlideChange(this,4);
                    u1.addChangeListener(cl);
                    u2.addChangeListener(cl);
                    panel.add(u1);
                    panel.add(u2);
                case 6:
                    cl = new SlideChange(this,5);
                    u1.addChangeListener(cl);
                    u2.addChangeListener(cl);
                    panel.add(u1);
                    panel.add(u2);
                    break;
                case 7:
                    graph =new Histogramas(img);
                    this.result =  FiltrosEspaciales.Contraste(graph,img);
                    this.ILabel.setIcon( new ImageIcon(this.result));
                    this.remove(wop);
                    this.InyectarGrafica(result);
                    break;
                case 8:
                    this.result =  FiltrosEspaciales.Ln(img);
                    this.ILabel.setIcon( new ImageIcon(this.result));
                    this.remove(wop);
                    this.InyectarGrafica(result);
                    break;
                case 9:
                    u1.setMajorTickSpacing(10);
                    u1.setMaximum(100);
                    this.u1.setValue(100);
                    cl = new SlideChange(this,6);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 10:
                    cl = new SlideChange(this,7);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 11:
                    cl = new SlideChange(this,8);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 12:
                    cl = new SlideChange(this,9);
                    u1.addChangeListener(cl);
                    u2.addChangeListener(cl);
                    panel.add(u1);
                    panel.add(u2);
                    break;
                case 13:
                    graph =new Histogramas(img);
                    this.result =  FiltrosEspaciales.toBin(img,UmbralizacionAutomatica.metodoIterativo(graph.getGrey()));
                    this.ILabel.setIcon( new ImageIcon(this.result));
                    this.remove(wop);
                    this.InyectarGrafica(result);
                    break;
                case 14:
                    graph =new Histogramas(img);
                    this.result =  FiltrosEspaciales.toBinOtsu(img);
                    this.ILabel.setIcon( new ImageIcon(this.result));
                    this.remove(wop);
                    this.InyectarGrafica(result);
                    break;  
                case 15:
                    cl = new SlideChange(this,10);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 16:
                    cl = new SlideChange(this,11);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 17:
                    cl = new SlideChange(this,12);
                    u1.addChangeListener(cl);
                    panel.add(u1);
                    break;
                case 18:
                    this.result =  Suavisado.suavizar(img,mascara);
                    this.ILabel.setIcon( new ImageIcon(this.result));
                    this.remove(wop);
                    this.InyectarGrafica(result);
                    break;
                default:
                    break;
        }
    //    this.u2.addChangeListener(lis);
        this.u1.setPaintLabels(true);
        this.u1.setPaintTicks(true);
        this.u2.setPaintLabels(true);
        this.u2.setPaintTicks(true);
        JPanel menu = new JPanel(new GridLayout(1,2));
       
        
        JButton n = new JButton("Return");
        ReturnListener al = new ReturnListener(this,false);
        n.addActionListener(al);
        menu.add(n);
        
        JButton n2 = new JButton("Add Filter");
        ReturnListener ar = new ReturnListener(this,true);
        n2.addActionListener(ar);
        menu.add(n2);
        
        panel.add(menu);
        add(panel, BorderLayout.SOUTH);
        
        this.pack();
    }
    
    public void InyectarGrafica(Image img){
        Histogramas graph =new Histogramas(img);
        graph.Graph(false);
        ChartFrame aux = new ChartFrame("Histograma", graph.getGraph().getGrafica());
        wop = aux.getComponent(0);
        this.add(wop, BorderLayout.EAST);
    }

    public JSlider getU1() {
       return this.u1;
    }
    public JSlider getU2() {
       return this.u2;
    }
    
    public Image getImg(){
        return this.img;
    }
    public Image getResult(){
        return this.result;
    }

    public void setResult(Image result) {
        this.result = result;
    }
    

    public JLabel getILabel() {
        return ILabel;
    }

    public Component getWop() {
        return wop;
    }

    public void setWop(Component wop) {
        this.wop = wop;
    }
    
    
}
