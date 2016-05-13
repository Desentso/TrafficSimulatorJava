
import Objektit.Auto;
import Objektit.Rakennus;
import Objektit.Suunta;
import Objektit.Tie;
import java.util.ArrayList;
import logiikka.Liikennevalot;
import logiikka.Simulaattori;
import ui.Piirtoalusta;
import ui.UI;


public class Main {

    public static void main(String[] args) {

        ArrayList<Auto> autot = new ArrayList<>();
        
        Tie tie = new Tie();
        
        //ArrayList<Integer> reittix = tie.getTieX();
        //ArrayList<Integer> reittiy = tie.getTieY();
        
        Rakennus rakennus1 = new Rakennus(80, 52, 40, 25);
        Rakennus rakennus2 = new Rakennus(505, 200, 25, 40);
        Rakennus rakennus3 = new Rakennus(100, -8, 50, 15);
        
        ArrayList<Rakennus> rakennukset = new ArrayList<>();
        
        rakennukset.add(rakennus1);
        rakennukset.add(rakennus2);
        rakennukset.add(rakennus3);
        
        //Auto auto1 = new Auto(12, 20, 2, Suunta.YLOS);
        Auto auto1 = new Auto(12, 20, 2, Suunta.YLOS);
        Auto autoTest = new Auto(12, 20, 2);
        Auto auto2 = new Auto(12, 30, 1);
        Auto auto3 = new Auto(8, 15, 3, Suunta.VASEN);
        
        
        autot.add(auto1);
        autot.add(auto2);
        autot.add(auto3);
        autot.add(autoTest);
        
        auto2.setY(150);
        
        auto1.setX(35);
        auto1.setY(200);
        auto1.setOikea(false);
        
        auto3.setY(14);
        auto3.setX(400);
        
        autoTest.setY(100);
        //autoTest.setX(14);
        //autoTest.setKohde(200, 420);
        autoTest.setKohde(rakennus3);
        autoTest.laskeReitti();
        
        //auto1.setOikea(false);
        //auto3.setSuunta(Suunta.VASEN);
        
        auto3.setMutkaX(1);
        auto3.setMutkaY(1);
        
        Piirtoalusta piirtoalusta = new Piirtoalusta(tie, autot, rakennukset);  
        
        UI ui = new UI(tie, auto1, piirtoalusta);
        
        ui.run();
        
        Liikennevalot valot = new Liikennevalot(tie);
        
        Simulaattori simulaattori = new Simulaattori(tie, autot, piirtoalusta, valot);
        
        simulaattori.simuloi();
        

    }
}
