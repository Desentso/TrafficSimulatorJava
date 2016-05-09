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
public class Auto {
    
    private ArrayList<Integer> reittix;
    private ArrayList<Integer> reittiy;
    
    private int leveys;
    private int korkeus;
    private int x;
    private int y;
    private int nopeus;
    private Suunta suunta;
    
    private int mutkaX;
    private int mutkaY;
    
    private boolean ymove;
    private boolean xmove;
    
    public Auto(int leveys, int korkeus, int nopeus){
        
       this.leveys = leveys;
       this.korkeus = korkeus;
       this.x = 14;
       this.y = 20;
       this.nopeus = nopeus;
       this.suunta = Suunta.ALAS;
       this.ymove = true;
       this.xmove = false;
       
       this.mutkaX = 2;
       this.mutkaY = 2;

    }

    public int getLeveys() {
        return this.leveys;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getNopeus(){
        return this.nopeus;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public Suunta getSuunta() {
        
        return this.suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
        
        if (suunta == Suunta.OIKEA || suunta == Suunta.VASEN){
            
            int l = this.korkeus;
            this.korkeus = this.leveys;
            this.leveys = l;
            
        } else if (suunta == Suunta.ALAS ||suunta == Suunta.YLOS){
            
            int k = this.korkeus;
            this.korkeus = this.leveys;
            this.leveys = k;
        }
    }
    
    public boolean yMove(){
        return this.ymove;
    }
    
    public boolean xMove(){
        return this.xmove;
    }

    public void setXmove(boolean xmove) {
        this.xmove = xmove;
    }

    public void setYmove(boolean ymove) {
        this.ymove = ymove;
    }

    public int getMutkaX() {
        return mutkaX;
    }

    public int getMutkaY() {
        return mutkaY;
    }

    public void setMutkaX(int mutkaX) {
        this.mutkaX = mutkaX;
    }

    public void setMutkaY(int mutkaY) {
        this.mutkaY = mutkaY;
    }
    
    
    
}
