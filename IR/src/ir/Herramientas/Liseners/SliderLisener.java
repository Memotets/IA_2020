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
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderLisener implements ChangeListener{
    private JFrameSegmentacion frame;
    
    public SliderLisener(JFrameSegmentacion frame){
        this.frame = frame;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        int un1 = this.frame.getU1().getValue();
        int un2 = this.frame.getU2().getValue();
        Image res = FiltrosEspaciales.fondol(this.frame.getImg(),un1,un2);
        this.frame.getILabel().setIcon(new ImageIcon(res));
        
//         	int u1 = this.frame.getJSliderU1().getValue();
//	int u2 = this.frame.getJSliderU2().getValue();
//	Image res = FiltrosEspaciales.
//	segmentarImagen(this.frame.getImagenEscalada(), u1, u2);
//	this.frame. getLabelImagen().setIcon(new ImageIcon(res));
    }
    
}
