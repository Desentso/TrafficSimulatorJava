/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Objektit.Auto;
import Objektit.Tie;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Olli
 */
public class UI implements Runnable{

    private JFrame frame;
    private Auto auto;
    private Tie tie;
    private Piirtoalusta piirtoalusta;
    
    public UI(Tie tie, Auto auto, Piirtoalusta piirtoalusta){
        
        this.tie = tie;
        this.auto = auto;
        this.piirtoalusta = piirtoalusta;
    }
    
    @Override
    public void run() {
        
        this.frame = new JFrame();
        
        frame.setPreferredSize(new Dimension(800, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createObjects(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
    }
    
    public void createObjects(Container container){
        
        this.tie.rakennaTie();
        
        container.add(this.piirtoalusta);
    }
}
