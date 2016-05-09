/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objektit;

/**
 *
 * @author Olli
 */
public class Rakennus {
    
    public int x;
    public int y;
    public int leveys;
    public int korkeus;
    
    public Rakennus(int x, int y, int leveys, int korkeus){
        
        this.x = x;
        this.y = y;
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }
    
    
}
