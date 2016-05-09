
import Objektit.Auto;
import Objektit.Suunta;
import Objektit.Tie;
import java.util.ArrayList;
import logiikka.Simulaattori;
import ui.Piirtoalusta;
import ui.UI;


public class Main {

    public static void main(String[] args) {

        ArrayList<Auto> autot = new ArrayList<>();
        
        Tie tie = new Tie();
        
        //ArrayList<Integer> reittix = tie.getTieX();
        //ArrayList<Integer> reittiy = tie.getTieY();
        
        Auto auto1 = new Auto(12, 20, 10);
        Auto auto2 = new Auto(12, 30, 10);
        Auto auto3 = new Auto(8, 15, 5);
        
        autot.add(auto1);
        autot.add(auto2);
        autot.add(auto3);
        
        auto2.setY(150);
        
        auto3.setY(14);
        auto3.setX(400);
        auto3.setSuunta(Suunta.VASEN);
        
        
        
        Piirtoalusta piirtoalusta = new Piirtoalusta(tie, autot);  
        
        UI ui = new UI(tie, auto1, piirtoalusta);
        
        ui.run();
        
        Simulaattori simulaattori = new Simulaattori(tie, autot, piirtoalusta);
        
        simulaattori.simuloi();
        
        
        
        //boolean yMove = true;
        //boolean xMove = false;
        
        //Suunta suunta = Suunta.ALAS;
        /*while(true){

            
            tie.rakennaTie();
            
            ArrayList<Integer> listaY = tie.getTieY();
                
            if((auto.getY() <= listaY.get(0)+5 || auto.getY() > listaY.get(1)-25) && yMove==true){

                yMove = false;
                xMove = true;
                
                System.out.println(auto.getY() + ", y0 " + listaY.get(0));
                System.out.println(auto.getY() + ", y1 " + listaY.get(1));
                
                if (auto.getSuunta() == Suunta.ALAS){
                    
                    auto.setSuunta(Suunta.OIKEA);
                    auto.setX(15);
                } else if(auto.getSuunta() == Suunta.YLOS){
                    
                    auto.setX(480);
                    auto.setSuunta(Suunta.VASEN);
                }
            }
            
            ArrayList<Integer> listaX = tie.getTieX();
                
            if((auto.getX() < listaX.get(0)+5 || auto.getX() > listaX.get(1)-20) && xMove){

                yMove = true;
                xMove = false;
                
                System.out.println(auto.getX() + ", x1 " + listaX.get(1));
                System.out.println(auto.getX() + ", x0 " + listaX.get(0));
                if (auto.getSuunta() == Suunta.OIKEA){
                    
                    auto.setSuunta(Suunta.YLOS);
                } else if (auto.getSuunta() == Suunta.VASEN){
                    
                    auto.setSuunta(Suunta.ALAS);
                }
            }

            
            if(yMove && auto.getSuunta() == Suunta.ALAS){
                
                auto.setY(auto.getY() + 10);
                piirtoalusta.paivita();
            } else if (yMove){
                
                auto.setY(auto.getY() - 10);
                piirtoalusta.paivita();  
            }
            
            if(xMove && auto.getSuunta() == Suunta.OIKEA){
                
                auto.setX(auto.getX() + 10);
                piirtoalusta.paivita();
            } else if (xMove){
                
                auto.setX(auto.getX() - 10);
                piirtoalusta.paivita();
            }
            
            try {
                
                Thread.sleep(auto.getNopeus());
            } catch(InterruptedException ex) {
                
                Thread.currentThread().interrupt();
            }
        }*/

    }
}
