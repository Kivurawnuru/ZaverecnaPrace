package vyber;

import postava.Postava;
import postava.SeznamHrdinu;
import postava.SeznamNepratel;

public class MenuItemVypisPostavy extends MenuItem{
    public MenuItemVypisPostavy(String description, SeznamHrdinu hrdinove, SeznamNepratel nepratele) {
        super(description, hrdinove, nepratele);
    }

    @Override
    public boolean execute() throws Exception {
        System.out.println("Tohle jsou tvé statistiky.");
        System.out.println();
        Postava nHrdina = hrdinove.getHrdinove().get(0);
        System.out.println(nHrdina);
        Thread.sleep(3000);
        System.out.println();
        return false;
    }
}
