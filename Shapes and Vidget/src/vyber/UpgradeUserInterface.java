package vyber;

import postava.SeznamHrdinu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UpgradeUserInterface {

    public void start() throws Exception {
        SeznamHrdinu hrdina = null;
        int skillpointy = hrdina.getHrdinove().get(0).getSkillpoint();
        if (skillpointy >= 1) {
            try {
                hrdina = SeznamHrdinu.nacti("postavy.txt");
                UpgradeMenu(hrdina);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean exit = false;

    public void UpgradeMenu(SeznamHrdinu hrdina) {

        try (BufferedReader ctenar = new BufferedReader(new FileReader("PravidlaProUpgrade.txt"))) {
            String radek = null;
            while ((radek = ctenar.readLine()) != null) {
                System.out.println(radek);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        MenuUpgrade upmenu = new MenuUpgrade("Vyber jakou schopnost chceš vylepšit.");
        upmenu.add(new UpgradeItemForce("Upgrade síly", hrdina));
        upmenu.add(new UpgradeItemInteligence("Upgrade Inteligence", hrdina));
        upmenu.add(new UpgradeItemDexterity("Upgrade Obratnosti", hrdina));
        upmenu.add(new UpgradeItemEndurance("Upgrade odolnosti", hrdina));
        upmenu.add(new UpgradeItemEnd("Zpátky", hrdina));

        while (!exit) {
            UpgradeItem upitem = upmenu.execute();
            exit = upitem.execute();
        }
    }
}
