/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.GUI.Views;

import ir.GUI.Liseners.Buttons.*;
import ir.GUI.RawView.JFrameImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
        "Doble Umbralizado","Expansion definida",
        "Expancion Linea","Expancion Logaritmica", 
        "Expansion exponencial","Expancion única", 
        "1 Binarizado", "2 Binarizados",
        "Bin. Automatico","Otzu", 
        "Ruido Aditivo", "Ruido Sustractivo",
        "Ruido mixto", "Suavizar"
    };
    private ArrayList<Effect> al;
    

    public Image getInit() {
        return init;
    }
    
    public IntImage(Image img){
        addListenersToAl();
        this.setTitle("PhotoBomb");
        this.init = img;
        this.InitComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrameImage.EXIT_ON_CLOSE);
    }

    private void InitComponents() {
        setLayout(new BorderLayout());
        this.ILabel = new JLabel(new ImageIcon(this.init));
        this.add(this.ILabel, BorderLayout.CENTER);
        JPanel panel = new JPanel(new GridLayout(3,this.names.length/3)); 
        int w = 80, h =50;
        for (int x=0; x<this.names.length;x++){
            JButton aux = new JButton(this.names[x]);
            aux.setOpaque(true);
            aux.setName(this.names[x]);
            //aux.setBackground(new Color(230,200,245));
            aux.setForeground(Color.black);
            aux.addActionListener(al.get(x));
            //aux.addActionListener(al);
            panel.add(aux);
        }
        panel.setBackground(Color.white);
        this.add(panel,BorderLayout.SOUTH);
        this.pack();
    }

    private void addListenersToAl() {
        al = new ArrayList<>();
        for(int i =0; i < names.length;i++)
        this.al.add(new Effect(this,i));
        
    }

   /* private static class BorderExample implements Border {
        private int radius;
        public BorderExample(int i) {
            this.radius = i;
        }

        @Override
        public void paintBorder(Component cmpnt, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-5, height-5, radius, radius);
    }

        @Override
        public Insets getBorderInsets(Component cmpnt) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
     }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }*/

}
