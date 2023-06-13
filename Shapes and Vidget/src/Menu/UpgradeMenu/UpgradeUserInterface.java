package Menu.UpgradeMenu;

import Menu.UpgradeMenu.AbilityUpgrades.UpgradeItemDexterity;
import Menu.UpgradeMenu.AbilityUpgrades.UpgradeItemEndurance;
import Menu.UpgradeMenu.AbilityUpgrades.UpgradeItemForce;
import Menu.UpgradeMenu.AbilityUpgrades.UpgradeItemInteligence;
import character.HeroArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UpgradeUserInterface {

    public void start(HeroArrayList hrdinove) throws Exception {
        HeroArrayList UpHrdina = hrdinove;
        UpgradeMenu(hrdinove);
    }
    private boolean exit = false;
        public void UpgradeMenu(HeroArrayList UpHrdina){

        try (BufferedReader ctenar = new BufferedReader(new FileReader("PravidlaProUpgrade.txt"))) {
            String radek = null;
            while ((radek = ctenar.readLine()) != null) {
                System.out.println(radek);
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        MenuUpgrade upmenu = new MenuUpgrade("Vyber jakou schopnost chceš vylepšit.(Zadávej výběr číselně)");
        upmenu.add(new UpgradeItemCharacterStatement("Výpis postavy",UpHrdina));
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
