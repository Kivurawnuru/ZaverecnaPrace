package vyber;

import postava.SeznamHrdinu;
import postava.SeznamNepratel;

public class MenuItemUpgrade extends MenuItem{

    public MenuItemUpgrade(String description, SeznamHrdinu hrdinove, SeznamNepratel nepratele) {
        super(description, hrdinove, nepratele);
    }

    @Override
    public boolean execute() throws Exception {
        UpgradeUserInterface uui = new UpgradeUserInterface();
        uui.start();
        return false;
    }
}
