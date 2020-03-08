/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Views;

import ir.GUI.RawView.ImageManager;
import ir.GUI.RawView.JFrameImage;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author memotets89
 */
public class IntImage extends JFrame{
    private Image init;
    private JLabel ILabel;
    public String[] names = {
        "Gris","Negativo", "Infrarojo", 
        "Iluminación", "Umbralización",
        "Doble Umbralizado","Contraste definido",
        "Contraste calculado", "Expancion Linea",
        "Expancion Logaritmica", "Expansion exponencial",
        "Expancion única", "1 Binarizado", "2 Binarizados",
        "Otzu"
    };
    
    public IntImage(Image img){
        this.setTitle("PhotoBomb");
        int ancho = img.getWidth(null)/2;
        int alto = img.getHeight(null)/2;
        this.init = ImageManager.toBufferedImage(img).getScaledInstance(ancho,alto, BufferedImage.TYPE_INT_BGR);
        this.InitComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrameImage.DISPOSE_ON_CLOSE);
    }

    private void InitComponents() {
        setLayout(new BorderLayout());
        this.ILabel = new JLabel(new ImageIcon(this.init));
        this.add(this.ILabel, BorderLayout.CENTER);
        JPanel panel = new JPanel(new GridLayout(2,this.names.length/2)); 
        int w = 80, h =50;
        for (int x=0; x<this.names.length;x++){
            Button aux = new Button();
            aux.setLabel(this.names[x]);
            aux.setName(this.names[x]);
            aux.setBackground(Color.BLACK);
            aux.setForeground(Color.WHITE);
            panel.add(aux);
        }
        panel.setBackground(Color.white);
        this.add(panel,BorderLayout.SOUTH);
        this.pack();
    }
}
