package Menu.UpgradeMenu.AbilityUpgrades;

import Menu.UpgradeMenu.UpgradeItem;
import character.HeroArrayList;

import java.util.Scanner;

public class UpgradeItemForce extends UpgradeItem {
    public UpgradeItemForce(String description, HeroArrayList hrdina) {
        super(description, hrdina);
    }

    @Override
    public boolean execute() {
        Scanner sc = new Scanner(System.in);
        int skillpointy = hrdina.getHrdinove().get(0).getSkillpoint();

        System.out.println("Aktuálně máš " + skillpointy + " volných skillpointů.");
            int sprOdpoved = 0;
        if(skillpointy >= 1) {
            while (sprOdpoved == 0) {
                System.out.println("Kolik skillpointů chceš použít ke zvíšení síly.");
                int olik = sc.nextInt();
                if (olik > 0 && olik <= skillpointy) {
                    for (int i = 0; i < olik; i++) {
                        double zviseniSily = hrdina.getHrdinove().get(0).getSila();
                        zviseniSily = zviseniSily + 0.5;
                        hrdina.getHrdinove().get(0).setSila(zviseniSily);
                        skillpointy--;
                        hrdina.getHrdinove().get(0).setSkillpoint(skillpointy);
                    }
                    sprOdpoved++;
                }
            }
        }else {
            System.out.println("Nemáš žádné skill pointy vrať se do hlavní nabídky");
        }
        return false;
    }
}
