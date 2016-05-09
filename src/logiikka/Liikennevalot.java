/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import Objektit.Tie;

/**
 *
 * @author Olli
 */
public class Liikennevalot {
    
    private Tie tie;
    private int laskuri;
    
    public Liikennevalot(Tie tie){
        
        this.laskuri = 0;
        this.tie = tie;
    }
    
    public void saadaValot(){
        
        this.laskuri += 1;
        
        if (this.laskuri > 800){
            
            this.tie.setValot(true);
            this.laskuri = 0;
        } else if (this.laskuri > 500){
            
            this.tie.setValot(false);
        } else {
            
            this.tie.setValot(true);
        }
    }
    
}
