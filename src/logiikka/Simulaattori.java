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
                
                //ArrayList<Integer> listaY = this.tie.getTieY();
                int mutkay = auto.getMutkaY();
                //ArrayList<Integer> listaY = auto.getReittiy();
                
                auto.laskeReitti();
                
                if (!auto.getOikea()){
                    
                    ArrayList<Integer> listaY = this.tie.getvTieY();
                    
                    //Toisensuuntainen liikenne
                    if ((auto.getY() < listaY.get(0) && auto.getSuunta() == Suunta.YLOS) || (auto.getY() > 400 && auto.getSuunta() == Suunta.ALAS) && auto.yMove()){

                        System.out.println(auto.getNopeus());
                        auto.setYmove(false);
                        auto.setXmove(true);
                        auto.setSuunta();
                        //auto.setY(auto.getY() - 4);
                    }
                } else if (auto.getOikea()){
                
                    ArrayList<Integer> listaY = this.tie.getTieY();
                    
                    if((auto.getY() <= listaY.get(0)+5 || auto.getY() > listaY.get(mutkay)-15) && auto.yMove()){

                        auto.setYmove(false);
                        auto.setXmove(true);
                        auto.setSuunta();

                    }

                }
                
                //ArrayList<Integer> listaX = this.tie.getTieX();
                //ArrayList<Integer> listaX = auto.getReittix();

                int mutkax = auto.getMutkaX();
                
                if (!auto.getOikea()){
                    
                    ArrayList<Integer> listaX = this.tie.getvTieX();
                    
                    if((auto.getX() > listaX.get(4) && auto.getSuunta() == Suunta.OIKEA) || (auto.getX() < 38 && auto.getSuunta() == Suunta.VASEN)  && auto.xMove()){

                        auto.setYmove(true);
                        auto.setXmove(false);

                        auto.setSuunta();
                    }
                } else if (auto.getOikea()){
                
                    ArrayList<Integer> listaX = this.tie.getTieX();
                    
                    if((auto.getX() < listaX.get(0)+1 || auto.getX() > listaX.get(mutkax)-12) && auto.xMove()){

                        auto.setYmove(true);
                        auto.setXmove(false);

                        auto.setSuunta();

                    }
                }

                if ((auto.getY() >= 220 && auto.getY() <= 255 && auto.getX() <= 20 && !valot) || (auto.getY() >= 40 && auto.getY() <= 70 && auto.getX() <= 450 && auto.getX() >= 400 && !valot)){
                    
                    System.out.println("red light");
                } else {
                    
                    auto.liiku();
                    
                }
                
                //System.out.println(valot);
                
                this.piirtoalusta.paivita();
                
                try {

                    Thread.sleep(10);
                } catch(InterruptedException ex) {

                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
