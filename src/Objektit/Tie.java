/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objektit;

import java.util.ArrayList;

/**
 *
 * @author Olli
 */
public class Tie {
    
    private ArrayList<Integer> tieY;
    private ArrayList<Integer> tieX;
    private Integer[][] tie2;
    
    public Tie(){
        this.tieY = new ArrayList<>();
        this.tieX = new ArrayList<>();
        this.tie2 = new Integer[10][2];
    }
    
    public void rakennaTie(){
        
        this.tieY.add(10);
        this.tieY.add(300);
        this.tieY.add(440);
        
        
        this.tieX.add(10);
        this.tieX.add(415);
        this.tieX.add(500);
    }
    
    public ArrayList<Integer> getTieY(){
        
        return this.tieY;
    }
    
    public ArrayList<Integer> getTieX(){
        
        return this.tieX;
    }
}
