package Menu.UpgradeMenu;

import character.Character;
import character.HeroArrayList;

public class UpgradeItemCharacterStatement extends UpgradeItem {
    public UpgradeItemCharacterStatement(String description, HeroArrayList hrdina) {
        super(description, hrdina);
    }

    @Override
    public boolean execute() {
        System.out.println("Tohle jsou tvé statistiky.");
        Character nHrdina = hrdina.getHrdinove().get(0);
        System.out.println(nHrdina);
        return false;
    }
}
