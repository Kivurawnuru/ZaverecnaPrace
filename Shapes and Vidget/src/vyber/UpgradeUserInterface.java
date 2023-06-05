package vyber;

import postava.SeznamHrdinu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class
UpgradeUserInterface {

    public void start(SeznamHrdinu hrdinove) throws Exception {
        SeznamHrdinu UpHrdina = hrdinove;
        UpgradeMenu(hrdinove);
    }
    private boolean exit = false;
        public void UpgradeMenu(SeznamHrdinu UpHrdina){

        try (BufferedReader ctenar = new BufferedReader(new FileReader("PravidlaProUpgrade.txt"))) {
            String radek = null;
            while ((radek = ctenar.readLine()) != null) {
                System.out.println(radek);
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        MenuUpgrade upmenu = new MenuUpgrade("Vyber jakou schopnost chceš vylepšit.");
        upmenu.add(new UpgradeItemVypisPostavy("Výpis postavy",UpHrdina));
        upmenu.add(new UpgradeItemForce("Upgrade síly", UpHrdina));
        upmenu.add(new UpgradeItemInteligence("Upgrade Inteligence", UpHrdina));
        upmenu.add(new UpgradeItemDexterity("Upgrade Obratnosti", UpHrdina));
        upmenu.add(new UpgradeItemEndurance("Upgrade odolnosti", UpHrdina));
        upmenu.add(new UpgradeItemEnd("Zpátky", UpHrdina));

        while (!exit) {
            UpgradeItem upitem = upmenu.execute();
            exit = upitem.execute();
        }
    }
}
