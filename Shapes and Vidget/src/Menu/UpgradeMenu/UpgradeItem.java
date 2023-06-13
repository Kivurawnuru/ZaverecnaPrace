package Menu.UpgradeMenu;

import character.HeroArrayList;

public abstract class UpgradeItem {
    protected String description;
    protected HeroArrayList hrdina;

    public UpgradeItem(String description, HeroArrayList hrdina) {
        this.description = description;
        this.hrdina = hrdina;
    }

    @Override
    public String toString() {
        return description;
    }
    public abstract boolean execute();
}
