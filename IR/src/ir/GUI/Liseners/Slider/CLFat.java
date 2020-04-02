/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Liseners.Slider;

import ir.Espacial.Histogramas;
import ir.GUI.Views.SliderView;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFrame;

/**
 *
 * @author memotets89
 */
public class CLFat implements ChangeListener{

    @Override
    public void stateChanged(ChangeEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void CambiarChart(Image res, SliderView frame) {
        frame.remove(frame.getWop());
        Histogramas graph =new Histogramas(res);
        graph.Graph(false);
        ChartFrame aux = new ChartFrame("Histograma", graph.getGraph().getGrafica());
        frame.setWop(aux.getComponent(0));
        frame.add(frame.getWop(), BorderLayout.EAST);
    }
    
}
