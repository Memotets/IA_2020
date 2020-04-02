/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Liseners.Slider;

import ir.Espacial.FiltrosEspaciales;
import ir.Espacial.Histogramas;
import ir.Espacial.Suavisado;
import ir.GUI.RawView.JFrameSegmentacion;
import ir.GUI.Views.SliderView;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import org.jfree.chart.ChartFrame;

/**
 *
 * @author memotets89
 */
public class SlideChange extends CLFat{
    private SliderView frame;
    private int i;
    public SlideChange(SliderView a, int i){
        this.frame = a;
        this.i=i;
    }
    
    @Override
    public void stateChanged(ChangeEvent ce) {
        int un1 = this.frame.getU1().getValue();
        int un2 = this.frame.getU2().getValue();
        double z = un1*0.01;
        Image res=null; 
        if (i == 1)res= FiltrosEspaciales.generarInfrarojo(this.frame.getImg(), un1);
        if (i == 2)res= FiltrosEspaciales.generarLuz(this.frame.getImg(), un1);
        if (i == 3)res= FiltrosEspaciales.fondol(this.frame.getImg(), un1, 255);
        if (i == 4)res= FiltrosEspaciales.fondol(this.frame.getImg(), un1, un2);
        if (i == 5)res= FiltrosEspaciales.Contraste(this.frame.getImg(), un1, un2);
        if (i == 6)res= FiltrosEspaciales.Xp(this.frame.getImg(), z);
        if (i == 7)res= FiltrosEspaciales.LnAlpha(this.frame.getImg(), un1);
        if (i == 8)res= FiltrosEspaciales.toBin(this.frame.getImg(), un1);
        if (i == 9)res= FiltrosEspaciales.toBin(this.frame.getImg(), un1, un2);
        if (i == 10)res= Suavisado.InyectarRuidoBlanco(this.frame.getImg(), un1);
        if (i == 11)res= Suavisado.InyectarRuidoNegro(this.frame.getImg(), un1);
        if (i == 12)res= Suavisado.mix(this.frame.getImg(), un1);
        CambiarChart(res,this.frame);
       
       this.frame.setResult(res);
       this.frame.getILabel().setIcon(new ImageIcon(res));
       this.frame.revalidate();
       this.frame.repaint();
    }
    
}
