/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import Objektit.Auto;
import Objektit.Rakennus;
import Objektit.Tie;
import java.util.ArrayList;

/**
 *
 * @author Olli
 */
public class Reitinloytaja {
    
    public Auto auto;
    public int ax;
    public int ay;
    
    public Rakennus rakennus;
    public int kohdex;
    public int kohdey;
    
    public Tie tiet;
    
    public ArrayList<Integer> mutkat;
    
    public Reitinloytaja(Auto auto, Tie tiet){
        
        this.auto = auto;
        this.ax = this.auto.getX();
        this.ay = this.auto.getY();
        
        this.kohdex = -1;
        
        this.tiet = tiet;
        
        this.tiet.rakennaTie();
        
        this.mutkat = new ArrayList<>();
    }

    public void setKohde(Rakennus rakennus){
        
        this.rakennus = rakennus;
        this.kohdex = rakennus.getX() - 15;
        this.kohdey = rakennus.getY();
    }
    
    public void setKohde(int x, int y){
        
        this.kohdex = x;
        this.kohdey = y;
    }
    
    public void laskeReitti(){
        
        if (this.kohdex != -1){
            int valittuMutka = 0;
            int lahin = 0;

            this.ay = this.auto.getY();
            this.ax = this.auto.getX();
            
            //System.out.println(this.ay + ", Y " + this.kohdey);
            //System.out.println(this.ax + ", X " + this.kohdex);
            
            if ((this.ax >= this.kohdex-5 && this.ax < this.kohdex + 10) && (this.ay > this.kohdey && this.ay < this.kohdey + 27)){

                this.auto.setXmove(false);
                this.auto.setYmove(false);
                System.out.println("PERILLÄ");
                
               /* if (this.kohdex != 200 || this.kohdey != 10){
                    this.setKohde(200, 10);
                
                    this.auto.setXmove(true);
                }*/
            }

            if(this.ay != this.kohdey){

                for(Integer mutka : this.tiet.getTieY()){

                    int ero = this.ay - mutka;
                    
                    if (lahin == 0 && mutka > this.ay){

                        lahin = ero;
                        valittuMutka = mutka;
                    } else if(ero > lahin && mutka > this.ay){

                        lahin = ero;
                        valittuMutka = mutka;
                    }

                    //System.out.println(valittu);
                }

                int mutkaNo = this.tiet.getTieY().indexOf(valittuMutka);
                //this.mutkat.add(mutkaNo);

                if(mutkaNo > -1){
                    this.auto.setMutkaY(mutkaNo);
                }

                //System.out.println(valittuMutka);
            }
            
            System.out.println(this.ay + ", Y " + this.kohdey +  ",valittuY " + valittuMutka);

            valittuMutka = 0;
            lahin = 0;
            
            if (this.ax != this.kohdex){

                for(Integer mutka : this.tiet.getTieX()){

                    int ero = this.kohdex - mutka;

                    if (lahin == 0 && mutka > this.ax){

                        lahin = ero;
                        valittuMutka = mutka;
                    } else if(ero < lahin && mutka > this.ax){

                        lahin = ero;
                        valittuMutka = mutka;
                    }
                }  

                int mutkaNo = this.tiet.getTieX().indexOf(valittuMutka);
                //this.mutkat.add(mutkaNo);

                if(mutkaNo > -1){
                    this.auto.setMutkaX(mutkaNo);
                }

                //System.out.println(valittuMutka);   
            }
            
            System.out.println(this.ax + ", X " + this.kohdex + ", valittuX " + valittuMutka);

        }
    }
    
    
}
