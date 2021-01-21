/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sliders;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
/**
 *
 * @author Manohar Vemuri
 */




public class SliderDemo{
    JFrame f;
    JPanel p;
    JLabel l1;
    JSlider slider;
    public SliderDemo(){
        f=new JFrame();
        p=new JPanel();
        l1=new JLabel();
        slider=new JSlider(0,100,50);
        slider.setPreferredSize(new Dimension(400,200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.addChangeListener(e ->{
                l1.setText("Temperature is: "+slider.getValue()+" °C");
            }
        );
        p.add(slider);
        p.add(l1);
        f.add(p);
        f.setVisible(true);
        f.setSize(420,420);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
