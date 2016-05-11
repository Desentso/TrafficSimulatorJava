/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objektit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Olli
 */
public class Tie {
    
    private ArrayList<Integer> tieY;
    private ArrayList<Integer> tieX;
    
    private ArrayList<Integer> vtieY;
    private ArrayList<Integer> vtieX;
    
    private Integer[][] tie2;
    private boolean valot1;
    
    //private HashMap<Integer, Integer> tiet;
    
    public Tie(){
        this.tieY = new ArrayList<>();
        this.tieX = new ArrayList<>();
        
        this.vtieY = new ArrayList<>();
        this.vtieX = new ArrayList<>();
        
        this.tie2 = new Integer[10][2];
        this.valot1 = true;
    }
    
    public void rakennaTie(){
        
        this.tieY.add(10);
        this.tieY.add(320);
        this.tieY.add(440);
        
        
        this.tieX.add(12);
        this.tieX.add(416);
        this.tieX.add(495);
        
        this.vtieX.add(20);
        this.vtieX.add(463);
        this.vtieX.add(406);
        
        this.vtieY.add(36);
        this.vtieY.add(280);
        //this.tiet.push(10, );
    }
    
    public ArrayList<Integer> getTieY(){
        
        return this.tieY;
    }
    
    public ArrayList<Integer> getTieX(){
        
        return this.tieX;
    }
    
    public boolean valot(){
        
        return this.valot1;
    }
    
    public void setValot(boolean valinta){
        
        this.valot1 = valinta;
    }
}
