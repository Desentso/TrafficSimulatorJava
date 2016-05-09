/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import Objektit.Auto;
import Objektit.Suunta;
import Objektit.Tie;
import java.util.ArrayList;
import ui.Piirtoalusta;

/**
 *
 * @author Olli
 */
public class Simulaattori {
    
    private Tie tie;
    private ArrayList<Auto> autot;
    private Piirtoalusta piirtoalusta;
    private Liikennevalot lvalot;
    
    public Simulaattori(Tie tie, ArrayList<Auto> autot, Piirtoalusta pa, Liikennevalot valot){
        
        this.tie = tie;
        this.autot = autot;
        this.piirtoalusta = pa;
        this.lvalot = valot;
    }
    
    public void simuloi(){
        
        while(true){
            
            for(Auto auto : this.autot){
                
                int indeksi = this.autot.indexOf(auto);
                
                this.lvalot.saadaValot();
                
                boolean valot = this.tie.valot();
                
                this.tie.rakennaTie();
                ArrayList<Integer> listaY = this.tie.getTieY();
                int mutkay = auto.getMutkaY();
                //ArrayList<Integer> listaY = auto.getReittiy();

                if((auto.getY() <= listaY.get(0)+5 || auto.getY() > listaY.get(mutkay)-15) && auto.yMove()){

                    auto.setYmove(false);
                    auto.setXmove(true);

                    if (auto.getSuunta() == Suunta.ALAS){

                        auto.setSuunta(Suunta.OIKEA);
                        auto.setX(15);
                    } else if(auto.getSuunta() == Suunta.YLOS){
                        
                        auto.setX(auto.getX()-2);
                        //auto.setX(410);
                        auto.setSuunta(Suunta.VASEN);
                    }
                }

                ArrayList<Integer> listaX = this.tie.getTieX();
                //ArrayList<Integer> listaX = auto.getReittix();

                int mutkax = auto.getMutkaX();
                
                if((auto.getX() < listaX.get(0)+1 || auto.getX() > listaX.get(mutkax)-12) && auto.xMove()){

                    auto.setYmove(true);
                    auto.setXmove(false);
                    
                    //auto.setX(auto.getX()-2);
                    if (auto.getSuunta() == Suunta.OIKEA){

                        auto.setSuunta(Suunta.YLOS);
                    } else if (auto.getSuunta() == Suunta.VASEN){

                        auto.setX(auto.getX()+2);
                        auto.setSuunta(Suunta.ALAS);
                    }
                }

                if ((auto.getY() >= 220 && auto.getY() <= 255 && auto.getX() <= 20 && !valot) || (auto.getY() >= 30 && auto.getY() <= 60 && auto.getX() <= 450 && auto.getX() >= 400 && !valot)){
                    
                    System.out.println("red light");
                } else {
                    
                    int nopeus = auto.getNopeus();
                    
                    if(auto.yMove() && auto.getSuunta() == Suunta.ALAS){

                        auto.setY(auto.getY() + nopeus);
                        piirtoalusta.paivita();
                    } else if (auto.yMove()){

                        auto.setY(auto.getY() - nopeus);
                        piirtoalusta.paivita();  
                    }

                    if(auto.xMove() && auto.getSuunta() == Suunta.OIKEA){

                        auto.setX(auto.getX() + nopeus);
                        piirtoalusta.paivita();
                    } else if (auto.xMove()){

                        auto.setX(auto.getX() - nopeus);
                        piirtoalusta.paivita();
                    }
                }
                
                //System.out.println(valot);
                
                piirtoalusta.paivita();
                
                try {

                    Thread.sleep(10);
                } catch(InterruptedException ex) {

                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
