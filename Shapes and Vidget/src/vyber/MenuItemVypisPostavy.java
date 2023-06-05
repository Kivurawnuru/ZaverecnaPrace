package vyber;

import postava.Postava;
import postava.SeznamHrdinu;
import postava.SeznamNepratel;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuItemVypisPostavy extends MenuItem{
    public MenuItemVypisPostavy(String description, SeznamHrdinu hrdinove, SeznamNepratel nepratele) {
        super(description, hrdinove, nepratele);
    }

    @Override
    public boolean execute() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tohle jsou tvé statistiky.");
        System.out.println();
        Postava nHrdina = hrdinove.getHrdinove().get(0);
        System.out.println(nHrdina);
        int puvodniLevel = nHrdina.getLevel();
        if(nHrdina.getLevel()*100 >= nHrdina.getExpy()){
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
