/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.Herramientas.Liseners;

/**
 *
 * @author memotets89
 */
import ir.Herramientas.JFrameSegmentacion;
import ir.SegmentoRGB.FiltrosEspaciales;
import ir.SegmentoRGB.Histogramas;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFrame;

public class SliderLisener implements ChangeListener{
    private JFrameSegmentacion frame;
    
    public SliderLisener(JFrameSegmentacion frame){
        this.frame = frame;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        int un1 = this.frame.getU1().getValue();
        int un2 = this.frame.getU2().getValue();
        Image res = FiltrosEspaciales.toBin(this.frame.getImg(),un1,un2);
        
        CambiarChart(res);
        
       this.frame.getILabel().setIcon(new ImageIcon(res));
       this.frame.revalidate();
       this.frame.repaint();
//         	int u1 = this.frame.getJSliderU1().getValue();
//	int u2 = this.frame.getJSliderU2().getValue();
//	Image res = FiltrosEspaciales.
//	segmentarImagen(this.frame.getImagenEscalada(), u1, u2);
//	this.frame. getLabelImagen().setIcon(new ImageIcon(res));
    }
    
    private void CambiarChart(Image res){
        this.frame.remove(this.frame.getWop());
        Histogramas graph =new Histogramas(res);
        graph.Graph(false);
        ChartFrame aux = new ChartFrame("Histograma", graph.getGraph().getGrafica());
        this.frame.setWop(aux.getComponent(0));
        this.frame.add(this.frame.getWop(), BorderLayout.EAST);
    }
    
}
