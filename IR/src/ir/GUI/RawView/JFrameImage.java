/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.RawView;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author memotets89
 */
public class JFrameImage extends JFrame{
   private Image  imagen;
   
    public JFrameImage (Image imagenOrigen){
        imagen = imagenOrigen;
        
        this.setSize(imagen.getWidth(null),imagen.getHeight(null));
        JLabel label = new JLabel ();
        label.setIcon(new ImageIcon(imagenOrigen));
        this.add(label);
        
        this.setVisible(true);
        
       this.setDefaultCloseOperation(JFrameImage.EXIT_ON_CLOSE);
    }
    
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    
}
