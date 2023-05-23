package vyber;

import postava.SeznamHrdinu;

public abstract class UpgradeItem {
    protected String description;
    protected SeznamHrdinu hrdina;

    public UpgradeItem(String description, SeznamHrdinu hrdina) {
        this.description = description;
        this.hrdina = hrdina;
    }

    @Override
    public String toString() {
        return description;
    }
    public abstract boolean execute();
}
