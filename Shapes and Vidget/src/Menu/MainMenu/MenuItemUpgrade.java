package Menu.MainMenu;

import Menu.UpgradeMenu.UpgradeUserInterface;
import character.Character;
import character.HeroArrayList;
import character.EnemyArrayList;

import java.util.Scanner;

public class MenuItemUpgrade extends MenuItem {

    public MenuItemUpgrade(String description, HeroArrayList hrdinove, EnemyArrayList nepratele) {
        super(description, hrdinove, nepratele);
    }

    @Override
    public boolean execute() throws Exception {
        Scanner sc = new Scanner(System.in);

        int skillpointy = hrdinove.getHrdinove().get(0).getSkillpoint();
        if (skillpointy >= 1) {
            System.out.println("Tohle jsou tvé statistiky.");
            Character nHrdina = hrdinove.getHrdinove().get(0);
            System.out.println(nHrdina);
            System.out.println("Opravdu chceš pokračovat a vylepšit si statistiky?");
            System.out.println("Ano/Ne");
            System.out.println("V případě špatné odpovědi budeš vrácen do základní nabídky. ");
            String odpoved = sc.nextLine();
            if(odpoved.matches("^[anoANO]{3}")){
                UpgradeUserInterface uui = new UpgradeUserInterface();
                uui.start(hrdinove);
            } else if (odpoved.matches("^[neNE]{2}")) {
                System.out.println("Jak si přeješ.");
                return false;
            }
        }else{
            System.out.println("Nemáš dostatek skillpointů");
        }return false;

    }
}
