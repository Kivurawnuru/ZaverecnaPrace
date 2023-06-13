package Menu.MainMenu;

import character.Character;
import character.EnemyArrayList;
import character.HeroArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MenuItemFinalFight extends MenuItem{
    public MenuItemFinalFight(String description, HeroArrayList hrdinove, EnemyArrayList nepratele) {
        super(description, hrdinove, nepratele);
    }

    private static DecimalFormat getDecimalFormat() throws Exception {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormat df = new DecimalFormat("### ###.#", symbols);
        symbols.setGroupingSeparator(' ');
        df.setDecimalFormatSymbols(symbols);
        df.setGroupingSize(3);
        df.setGroupingUsed(true);
        return df;
    }

    public static void souboj(Character hrdina, Character nepritel) throws Exception{

        try (BufferedReader ctenar = new BufferedReader(new FileReader("TalkBeforeFinalFight.txt"))) {
            String radek = null;
            while ((radek = ctenar.readLine()) != null) {
                System.out.println(radek);
                Thread.sleep(1800);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        Thread.sleep(6000);

        double zalohaHrdinyZ = hrdina.getZivoty();
        double zalohSampionaZ = nepritel.getZivoty();

        DecimalFormat df = getDecimalFormat();

        int hrdinaD = 1;
        int nepritelD = 1;
        System.out.println("Prvni zacina hrdina.");
        System.out.println();
        System.out.println("Hrdina " + hrdina);
        System.out.println("Šampión arény " + nepritel);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");

        Thread.sleep(1800);

        while(hrdinaD ==1 && nepritelD ==1){

            if(nepritel.getZivoty() <= 0){
                System.out.println();
                System.out.println("Šampión arény padl.");
                nepritelD++;
                hrdina.setZivoty(zalohaHrdinyZ);
                nepritel.setZivoty(zalohSampionaZ);

                hrdina.vyhraExM(nepritel.getLevel(),hrdina.getLevel());

            }else{
                System.out.println();
                System.out.println("Šampión "+nepritel.getJmeno() +" má "+ df.format(nepritel.getZivoty())+" a ted utoci.");
                double dmgN = nepritel.utociNa(hrdina);
                double odecrtOdHrd = hrdina.getZivoty() - dmgN;
                hrdina.setZivoty(odecrtOdHrd);
                System.out.println("Šampión "+ nepritel.getJmeno() +" dává "+ hrdina.getJmeno()+"ovi dmg " + df.format(dmgN));

                Thread.sleep(1800);

                if(hrdina.getZivoty() <= 0){
                    System.out.println();
                    System.out.println("Hrdina je v bezvědomí vyhrál Šampión, jak jinak.");
                    System.out.println("Možná se ti poštěstí příště.");
                    hrdinaD++;
                    hrdina.setZivoty(zalohaHrdinyZ);
                    nepritel.setZivoty(zalohSampionaZ);

                }else{
                    System.out.println();
                    System.out.println("Hrdina "+hrdina.getJmeno() +" má "+ df.format(hrdina.getZivoty())+" a ted utoci.");
                    double dmgH = hrdina.utociNa(nepritel);
                    double odecetOdNepr = nepritel.getZivoty() - dmgH;
                    nepritel.setZivoty(odecetOdNepr);
                    System.out.println("Hrdina "+ hrdina.getJmeno() +" dává Šampiónovi "+ nepritel.getJmeno()+"ovi dmg " + df.format(dmgH));

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
        EnemyArrayList sl = nepratele;

        souboj(sh.getHrdinove().get(0), sl.getNepratele().get(0));
        return false;
    }
}
