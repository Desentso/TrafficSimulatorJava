/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import Objektit.Auto;
import Objektit.Rakennus;

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
    
    public Reitinloytaja(){
        
    }
    
    public void setAuto(Auto auto){
        
        this.auto = auto;
        this.ax = this.auto.getX();
        this.ay = this.auto.getY();
    }
}
