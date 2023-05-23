package vyber;

import postava.SeznamHrdinu;

import java.util.Scanner;

public class UpgradeItemDexterity extends UpgradeItem {
    public UpgradeItemDexterity(String description, SeznamHrdinu hrdina) {
        super(description, hrdina);
    }

    @Override
    public boolean execute() {
        Scanner sc = new Scanner(System.in);
        int skillpointy = hrdina.getHrdinove().get(0).getSkillpoint();

        System.out.println("Aktuálně máš " + skillpointy + " volných skillpointů.");
        int sprOdpoved = 0;
        while (sprOdpoved == 0) {
            System.out.println("Kolik skillpointů chceš použít ke zvíšení obratnosti.");
            int kolik = sc.nextInt();
            if (kolik > 0 && kolik <= skillpointy) {
                for (int i = 0; i < kolik; i++) {
                    double zviseniObratnosti = hrdina.getHrdinove().get(0).getObratnost();
                    zviseniObratnosti = zviseniObratnosti + 0.5;
                    hrdina.getHrdinove().get(0).setObratnost(zviseniObratnosti);
                    skillpointy--;
                    hrdina.getHrdinove().get(0).setSkillpoint(skillpointy);
                }
                sprOdpoved++;
            }
        }
        return false;
    }
}

