/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Objektit.Auto;
import Objektit.Tie;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Olli
 */
public class Piirtoalusta extends JPanel{
    
    private Tie tie;
    private Auto auto;
    private ArrayList<Auto> autot;
    
    public Piirtoalusta(Tie tiet, ArrayList<Auto> autot){
        this.tie = tiet;
        this.autot = autot;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        /*for (Integer luku : this.tie.getTie()){
            
            g.drawLine(10,10,10, 300);
            g.drawLine(30, 30, 30, 280);
        }*/
        
        
        //left side
        g.drawLine(10,10,10, 440);
        g.drawLine(30, 30, 30, 280);
        
        //top
        g.drawLine(10,10, 500, 10);
        g.drawLine(30, 30, 400, 30);
        g.drawLine(30, 300, 480, 300);
        g.drawLine(30, 280, 400, 280);
        
        //
        g.drawLine(400, 280, 400, 30);
        g.drawLine(420, 280, 420, 30);
        
        //
        g.drawLine(420, 30, 480, 30);
        g.drawLine(420, 280, 480, 280);
        
        //
        g.drawLine(500, 300, 500, 10);
        g.drawLine(480, 280, 480, 30);
        
        g.drawLine(30, 300, 30, 420);
        g.drawLine(10, 440, 500, 440);
        
        g.drawLine(30, 420, 480, 420);
        g.drawLine(480, 420, 480, 300);
        
        g.drawLine(500, 440, 500, 300);
        for (Auto auto : this.autot){
        
            int leveys = auto.getLeveys();
            int korkeus = auto.getKorkeus();
        
            int x = auto.getX();
            int y = auto.getY();
        
            g.fillRect(x, y, leveys, korkeus);
        }
        
        g.setColor(Color.GREEN);
        g.fillOval(0, 240, 10, 10);
        g.setColor(Color.YELLOW);
        g.fillOval(0, 252, 10, 10);
        g.setColor(Color.RED);
        g.fillOval(0, 264, 10, 10);
    }
    
    public void paivita(){
        
        repaint();
    }
    
    public void piirra(int x, int y, int x2, int y2){
        
        
    }
    
}
