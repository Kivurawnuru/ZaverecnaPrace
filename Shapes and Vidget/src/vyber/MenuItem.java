package vyber;

import postava.SeznamHrdinu;
import postava.SeznamNepratel;

public abstract class MenuItem {
    protected String description;
    protected SeznamHrdinu hrdinove;
    protected SeznamNepratel nepratele;

    public MenuItem(String description, SeznamHrdinu hrdinove,SeznamNepratel nepratele) {
        this.description = description;
        this.hrdinove = hrdinove;
        this.nepratele = nepratele;
    }

    @Override
    public String toString() {
        return description;
    }

    public abstract boolean execute() throws Exception;
}