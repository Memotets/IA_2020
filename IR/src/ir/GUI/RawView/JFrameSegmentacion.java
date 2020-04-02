/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.RawView;

/**
 *
 * @author memotets89
 */
import ir.GUI.Liseners.Slider.SliderLisener;
import ir.Espacial.Histogramas;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFrame;


public class JFrameSegmentacion extends JFrame{
    private JSlider u1, u2;
    private JLabel ILabel;
    private Image img;
    private Component wop;
    
    public JFrameSegmentacion(String title, Image imagen){
        this.setTitle(title);
        int ancho = imagen.getWidth(null)/2;
        int alto = imagen.getHeight(null)/2;
        this.img = ImageManager.toBufferedImage(imagen).getScaledInstance(ancho,alto, BufferedImage.TYPE_INT_BGR);
        
        intComponets();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrameImage.DISPOSE_ON_CLOSE);
    }

    private void intComponets() {
        setLayout(new BorderLayout());
        this.ILabel = new JLabel(new ImageIcon(this.img));
        this.add(this.ILabel, BorderLayout.CENTER);
        
        this.u1 = new JSlider();
        this.u1.setMinorTickSpacing(1);
        this.u1.setMajorTickSpacing(15);
        this.u1.setPaintLabels(true);
        this.u1.setPaintTicks(true);
        this.u1.setMinimum(0);
        this.u1.setMaximum(255);
        this.u1.setValue(0);
        
        this.u2 = new JSlider();
        this.u2.setMinorTickSpacing(1);
        this.u2.setMajorTickSpacing(15);
        this.u2.setPaintLabels(true);
        this.u2.setPaintTicks(true);
        this.u2.setMinimum(0);
        this.u2.setMaximum(255);
        this.u2.setValue(255);
        
        InyectarGrafica(this.img);
        
        SliderLisener lis = new  SliderLisener(this);
        this.u1.addChangeListener(lis);
        this.u2.addChangeListener(lis);
        
        JPanel panel = new JPanel(new GridLayout(2,1)); 
        panel.add(this.u1);
        panel.add(this.u2);
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
        return u1;
    }

    public JSlider getU2() {
        return u2;
    }

    public JLabel getILabel() {
        return ILabel;
    }

    public Image getImg() {
        return img;
    }

    public Component getWop() {
        return wop;
    }

    public void setWop(Component wop) {
        this.wop = wop;
    }
    
    public void setU1(JSlider u1) {
        this.u1 = u1;
    }

    public void setU2(JSlider u2) {
        this.u2 = u2;
    }

    public void setILabel(JLabel ILabel) {
        this.ILabel = ILabel;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    
}
