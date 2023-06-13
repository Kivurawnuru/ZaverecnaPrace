package Menu.MainMenu;

import character.HeroArrayList;
import character.EnemyArrayList;

public abstract class MenuItem {
    protected String description;
    protected HeroArrayList hrdinove;
    protected EnemyArrayList nepratele;

    public MenuItem(String description, HeroArrayList hrdinove, EnemyArrayList nepratele) {
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