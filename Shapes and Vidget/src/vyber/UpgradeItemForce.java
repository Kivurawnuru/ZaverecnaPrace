package vyber;

import postava.SeznamHrdinu;

import java.util.Scanner;

public class UpgradeItemForce extends UpgradeItem {
    public UpgradeItemForce(String description, SeznamHrdinu hrdina) {
        super(description, hrdina);
    }

    @Override
    public boolean execute() {
        Scanner sc = new Scanner(System.in);
        int skillpointy = hrdina.getHrdinove().get(0).getSkillpoint();


        System.out.println("Aktuálně máš " + skillpointy + " volných skillpointů.");
        if (skillpointy <= 0) {
            System.out.println("Aktuáně nemáš žádné skillpointy, které bys mohl použít.");
            return false;
        } else {
            int sprOdpoved = 0;
            while (sprOdpoved == 0) {
                System.out.println("Kolikrát ji chceš vylepšit.");
                int kolikrat = sc.nextInt();
                if (kolikrat > 0 && kolikrat <= skillpointy) {
                    for (int i = 0; i < kolikrat; i++) {
                        double zviseniSily = hrdina.getHrdinove().get(0).getSila();
                        zviseniSily = zviseniSily + 0.5;
                        hrdina.getHrdinove().get(0).setSila(zviseniSily);
                        skillpointy--;
                        hrdina.getHrdinove().get(0).setSkillpoint(skillpointy);
                    }
                    sprOdpoved++;
                }

            }

        }

        return false;
    }
}
