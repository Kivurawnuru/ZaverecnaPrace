package vyber;

import postava.SeznamHrdinu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UpgradeUserInterface {

    public void start() throws Exception {
        SeznamHrdinu hrdina = null;

        try {
            hrdina = SeznamHrdinu.nacti("postavy.txt");
            UpgradeMenu(hrdina);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("KONEC");
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

        MenuUpgrade upmenu = new MenuUpgrade("Vyber jakou chopnost chceš vylepšit.");
        upmenu.add(new UpgradeItemForce("Upgrade síly", hrdina));


        while (!exit) {
            UpgradeItem upitem = upmenu.execute();
            exit = upitem.execute();
        }
    }
}
