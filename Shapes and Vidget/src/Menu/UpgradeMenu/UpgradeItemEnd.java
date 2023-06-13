package Menu.UpgradeMenu;

import character.HeroArrayList;

public class UpgradeItemEnd extends UpgradeItem {
    public UpgradeItemEnd(String description, HeroArrayList hrdina) {
        super(description, hrdina);
    }

    @Override
    public boolean execute() {
        return true;
    }
}
