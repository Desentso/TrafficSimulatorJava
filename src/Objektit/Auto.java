/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objektit;

import java.util.ArrayList;
import logiikka.Reitinloytaja;

/**
 *
 * @author Olli
 */
public class Auto {
    
    private ArrayList<Integer> reittix;
    private ArrayList<Integer> reittiy;
    
    private Reitinloytaja reitinloytaja;
    
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
    
    private boolean oikea;
    
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
       
       this.oikea = true;
       
       this.reitinloytaja = new Reitinloytaja(this, new Tie());
    }
    
    public Auto(int leveys, int korkeus, int nopeus, Suunta suunta){
        
       this.leveys = leveys;
       this.korkeus = korkeus;
       this.x = 14;
       this.y = 20;
       this.nopeus = nopeus;
       this.suunta = suunta;
       this.ymove = true;
       this.xmove = false;
       
       this.mutkaX = 2;
       this.mutkaY = 2;
       
       this.oikea = true;
       
       this.reitinloytaja = new Reitinloytaja(this , new Tie());
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

    public void setSuunta() {
        
        //this.suunta = suunta;
        
        if (this.xmove && this.oikea){
        
            if (this.suunta == Suunta.ALAS){

                this.suunta = Suunta.OIKEA;
                this.setX(15);
            } else if(this.suunta == Suunta.YLOS){

                this.setX(this.getX()-2);
                this.suunta = Suunta.VASEN;
            }
            
        } else if (this.xmove && !this.oikea){
            
            if (this.suunta == Suunta.ALAS){

                this.suunta = Suunta.VASEN;
                //this.setX(15);
                this.x = this.x - 2;
            } else if(this.suunta == Suunta.YLOS){

                //this.setX(this.getX()-2);
                this.x = this.x + 2;
                this.suunta = Suunta.OIKEA;
                System.out.println("asd");
            }
        }
        
        if (this.ymove && this.oikea){
            
            if (this.suunta == Suunta.OIKEA){

                this.suunta = Suunta.YLOS;
            } else if (this.suunta == Suunta.VASEN){

                this.setX(this.getX()+2);
                this.suunta = Suunta.ALAS;
            }
        } else if (this.ymove && !this.oikea){
            
            if (this.suunta == Suunta.OIKEA){

                this.suunta = Suunta.ALAS;
            } else if (this.suunta == Suunta.VASEN){

                //this.setX(this.getX()+2);
                this.suunta = Suunta.YLOS;
            }
        }
        
        if (this.suunta == Suunta.OIKEA || this.suunta == Suunta.VASEN){
            
            int l = this.korkeus;
            this.korkeus = this.leveys;
            this.leveys = l;
            
        } else if (this.suunta == Suunta.ALAS || this.suunta == Suunta.YLOS){
            
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
    
    public void liiku(){
        
         if(this.yMove() && this.getSuunta() == Suunta.ALAS){

            this.setY(this.getY() + this.nopeus);

        } else if (this.yMove()){

            this.setY(this.getY() - this.nopeus); 
        }
         

        if(this.xMove() && this.getSuunta() == Suunta.OIKEA){

            this.setX(this.getX() + this.nopeus);
        } else if (this.xMove()){

            this.setX(this.getX() - this.nopeus);
        }
    }
    
    public void setOikea(boolean oikea){
        
        this.oikea = oikea;
    }
    
    public boolean getOikea(){
        
        return this.oikea;
    }
    
    public void setKohde(int x, int y){
        
        this.reitinloytaja.setKohde(x, y);
    }
    
    public void setKohde(Rakennus rakennus){
        
        this.reitinloytaja.setKohde(rakennus);
    }
    
    public void laskeReitti(){
        
        this.reitinloytaja.laskeReitti();
    }
}
