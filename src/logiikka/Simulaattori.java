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
    
    public Simulaattori(Tie tie, ArrayList<Auto> autot, Piirtoalusta pa){
        
        this.tie = tie;
        this.autot = autot;
        this.piirtoalusta = pa;
    }
    
    public void simuloi(){
        
        while(true){
            
            for(Auto auto : this.autot){
                
                int indeksi = this.autot.indexOf(auto);
                
                this.tie.rakennaTie();
                ArrayList<Integer> listaY = this.tie.getTieY();
                int mutkay = auto.getMutkaY();
                //ArrayList<Integer> listaY = auto.getReittiy();

                if((auto.getY() <= listaY.get(0)+5 || auto.getY() > listaY.get(mutkay)-15) && auto.yMove()==true){

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


                if(auto.yMove() && auto.getSuunta() == Suunta.ALAS){

                    auto.setY(auto.getY() + 2);
                    piirtoalusta.paivita();
                } else if (auto.yMove()){

                    auto.setY(auto.getY() - 2);
                    piirtoalusta.paivita();  
                }

                if(auto.xMove() && auto.getSuunta() == Suunta.OIKEA){

                    auto.setX(auto.getX() + 2);
                    piirtoalusta.paivita();
                } else if (auto.xMove()){

                    auto.setX(auto.getX() - 2);
                    piirtoalusta.paivita();
                }

                try {

                    Thread.sleep(auto.getNopeus());
                } catch(InterruptedException ex) {

                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
