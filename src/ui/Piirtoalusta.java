/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Objektit.Auto;
import Objektit.Rakennus;
import Objektit.Tie;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    private ArrayList<Rakennus> rakennukset;
    
    public Piirtoalusta(Tie tiet, ArrayList<Auto> autot, ArrayList<Rakennus> rakennukset){
        this.tie = tiet;
        this.autot = autot;
        this.rakennukset = rakennukset;
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
        g.drawLine(50, 50, 50, 280);
        
        //kaistaviivat pystysuuntasille
        for(int i = 40; i < 420; i+=20){
            
            g.drawLine(30, i, 30, i+5);
        }
        
        for(int i = 40; i < 420; i+=20){
            
            g.drawLine(480, i, 480, i+5);
        }
        
        for(int i = 50; i < 280; i+=20){
            
            g.drawLine(400, i, 400, i+5);
        }
        
        //top
        g.drawLine(10,10, 500, 10);
        g.drawLine(50, 50, 380, 50);
        g.drawLine(50, 320, 460, 320);
        g.drawLine(50, 280, 380, 280);
        
        //kaistaviivat vaakasuuntasille
        for(int i = 50; i < 460; i+=20){
            
            g.drawLine(i, 30, i+5, 30);
        }
        
        for(int i = 50; i < 460; i+=20){
            
            g.drawLine(i, 300, i+5, 300);
        }
        
        for(int i = 50; i < 460; i+=20){
            
            g.drawLine(i, 420, i+5, 420);
        }
        
        //
        g.drawLine(380, 280, 380, 50);
        g.drawLine(420, 280, 420, 50);
        
        //
        g.drawLine(420, 50, 460, 50);
        g.drawLine(420, 280, 460, 280);
        
        //
        g.drawLine(500, 300, 500, 10);
        g.drawLine(460, 280, 460, 50);
        
        g.drawLine(50, 320, 50, 400);
        g.drawLine(10, 440, 500, 440);
        
        g.drawLine(50, 400, 460, 400);
        g.drawLine(460, 400, 460, 320);
        
        g.drawLine(500, 440, 500, 300);
        
        for (Auto auto : this.autot){
        
            int leveys = auto.getLeveys();
            int korkeus = auto.getKorkeus();
        
            int x = auto.getX();
            int y = auto.getY();
        
            g.fillRect(x, y, leveys, korkeus);
            
           /* Graphics2D g2d = (Graphics2D)g;

            g2d.rotate(Math.toRadians(40));
            g2d.fillRect(550, 400, 20, 10);*/
        }
        
        g.setColor(Color.GRAY);
        
        for(Rakennus rakennus : this.rakennukset){
            
            int leveys = rakennus.getLeveys();
            int korkeus = rakennus.getKorkeus();
            
            int x = rakennus.getX();
            int y = rakennus.getY();
            
            g.fillRect(x, y, leveys, korkeus);
        }
        
        if (this.tie.valot()){
            
            g.setColor(Color.GREEN);
        } else {
            
            g.setColor(Color.RED);
        }
        
        g.fillOval(1, 264, 9, 9);
        
        g.fillOval(422, 55, 9 ,9);
    }
    
    public void paivita(){
        
        repaint();
    }
    
    public void piirra(int x, int y, int x2, int y2){
        
        
    }
    
}
