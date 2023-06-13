package Menu.MainMenu;

import character.Character;
import character.HeroArrayList;
import character.EnemyArrayList;

import java.util.Scanner;

public class MenuItemCharacterStatement extends MenuItem {
    public MenuItemCharacterStatement(String description, HeroArrayList hrdinove, EnemyArrayList nepratele) {
        super(description, hrdinove, nepratele);
    }

    @Override
    public boolean execute() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tohle jsou tvé statistiky.");
        System.out.println();
        Character nHrdina = hrdinove.getHrdinove().get(0);
        System.out.println(nHrdina);
        System.out.println("Aktuálně máš zplaceno " + hrdinove.getHrdinove().get(0).getZplacenoZDluhu()+" korun.");
        int puvodniLevel = nHrdina.getLevel();
        if(nHrdina.getExpy() >= (hrdinove.getHrdinove().get(0).getLevel() * 100)){
            System.out.println("Máš možnost zvíšit si level, chceš to provést? Ano/Ne");
            String levelChoice = sc.nextLine();
            if(levelChoice.matches("^[anoANO]{3}")){
                hrdinove.getHrdinove().get(0).levelUp();
                int rozdilLevelu = nHrdina.getLevel() - puvodniLevel;
                if(rozdilLevelu == 1){
                    System.out.println("Získal jsi jeden level.");
                } else if (rozdilLevelu >= 2) {
                    System.out.println("Získal jsi "+rozdilLevelu+" levelů.");
                }
            } else {
                System.out.println("Tak teda nic.");
            }
        }
        Thread.sleep(3000);
        System.out.println();
        return false;
    }
}
