package vyber;

import postava.Postava;
import postava.SeznamHrdinu;

public class UpgradeItemVypisPostavy extends UpgradeItem{
    public UpgradeItemVypisPostavy(String description, SeznamHrdinu hrdina) {
        super(description, hrdina);
    }

    @Override
    public boolean execute() {
        System.out.println("Tohle jsou tvé statistiky.");
        Postava nHrdina = hrdina.getHrdinove().get(0);
        System.out.println(nHrdina);
        return false;
    }
}
