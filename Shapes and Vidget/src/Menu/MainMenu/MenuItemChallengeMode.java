package Menu.MainMenu;

import character.Character;
import character.HeroArrayList;
import character.EnemyArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class MenuItemChallengeMode extends MenuItem {
    public MenuItemChallengeMode(String description, HeroArrayList hrdinove, EnemyArrayList nepratele) {
        super(description, hrdinove, nepratele);
    }

    /**
     * Method that formats damage and health decimals
     * @throws Exception
     */
    private static DecimalFormat getDecimalFormat() throws Exception {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormat df = new DecimalFormat("### ###.#", symbols);
        symbols.setGroupingSeparator(' ');
        df.setDecimalFormatSymbols(symbols);
        df.setGroupingSize(3);
        df.setGroupingUsed(true);
        return df;
    }

    public static void souboj(Character hrdina, Character nepritel) throws Exception {

        double zalohaHrdinyZ = hrdina.getZivoty();
        double zalohaNepriteleZ = nepritel.getZivoty();

        DecimalFormat df = getDecimalFormat();

        int hrdinaD = 1;
        int nepritelD = 1;
        System.out.println("Prvni zacina hrdina.");
        System.out.println();
        System.out.println("Hrdina " + hrdina);
        System.out.println("Nepritel " + nepritel);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");

        Thread.sleep(1800);

        while (hrdinaD == 1 && nepritelD == 1) {

            if (hrdina.getZivoty() <= 0) {
                System.out.println("Hrdina je v bezvědomí vyhrál nepřítel.");
                hrdinaD++;
                hrdina.setZivoty(zalohaHrdinyZ);
                nepritel.setZivoty(zalohaNepriteleZ);

            } else {
                System.out.println();
                System.out.println("Hrdina " + hrdina.getJmeno() + " má " + df.format(hrdina.getZivoty()) + " a ted utoci.");
                double dmgH = hrdina.utociNa(nepritel);

                double odecetOdNepr = nepritel.getZivoty() - dmgH;
                nepritel.setZivoty(odecetOdNepr);
                System.out.println("Hrdina " + hrdina.getJmeno() + " dává " + nepritel.getJmeno() + "ovi dmg " + df.format(dmgH));

                Thread.sleep(1800);

                if (nepritel.getZivoty() <= 0) {
                    System.out.println();
                    System.out.println("Nepritel je v bezvědomí vyhrál hrdina.");
                    nepritelD++;

                    hrdina.setZivoty(zalohaHrdinyZ);
                    nepritel.setZivoty(zalohaNepriteleZ);
                    hrdina.vyhraCHM(nepritel.getLevel(), hrdina.getLevel());
                    hrdina.vyhrouSiZískalCHM(nepritel.getLevel(),hrdina.getLevel());

                } else {
                    System.out.println();
                    System.out.println("Nepritel " + nepritel.getJmeno() + " má " + df.format(nepritel.getZivoty()) + " a ted utoci.");
                    double dmgN = nepritel.utociNa(hrdina);

                    double odecrtOdHrd = hrdina.getZivoty() - dmgN;
                    hrdina.setZivoty(odecrtOdHrd);
                    System.out.println("Nepritel " + nepritel.getJmeno() + " dává " + hrdina.getJmeno() + "ovi dmg " + df.format(dmgN));
                    Thread.sleep(1800);
                }
            }
        }
        System.out.println();
        System.out.println("Konec hry.");
        System.out.println();
    }

    @Override
    public boolean execute() throws Exception {
        HeroArrayList sh = hrdinove;

        souboj(sh.getHrdinove().get(0), Character.enemyForChallengeMode(sh.getHrdinove().get(0).getLevel()));
        return false;
    }
    //
}
