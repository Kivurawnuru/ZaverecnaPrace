package Menu.MainMenu;

import character.HeroArrayList;
import character.EnemyArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserInterface {

    public void start() throws Exception {
        HeroArrayList hrdinove = null;
        EnemyArrayList nepratele = null;
        EnemyArrayList sampion = null;

        try (BufferedReader ctenar = new BufferedReader(new FileReader("EntraceStory.txt"))) {
            String radek = null;
            while ((radek = ctenar.readLine()) != null) {
                System.out.println(radek);
                Thread.sleep(1800);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            hrdinove = HeroArrayList.nacti("postavy.txt");
            nepratele = EnemyArrayList.nacti("nepratele.txt");
            sampion = EnemyArrayList.nacti("Champion.txt");
            MainMenu(hrdinove, nepratele,sampion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("KONEC");
    }

    private boolean exit = false;

    public void MainMenu(HeroArrayList hrdinove, EnemyArrayList nepratele,EnemyArrayList sampion) throws Exception {

        System.out.println("__________________________________________________________________________________________________");
        Menu menu = new Menu("Nyní si vyber jednu možnost: (Jenom číselně)");
        menu.add(new MenuItemCharacterStatement("Výpis postavy", hrdinove, nepratele));
        menu.add(new MenuItemFight("Souboj", hrdinove, nepratele));
        if (hrdinove.getHrdinove().get(0).getLevel() >= 10) {
            menu.add(new MenuItemChallengeMode("Challenge Mode", hrdinove, nepratele));
        }
        if(hrdinove.getHrdinove().get(0).getLevel() >=50){
            menu.add(new MenuItemExtremeFight("Extrémní výzva",hrdinove,nepratele));
        }
        if(hrdinove.getHrdinove().get(0).getZplacenoZDluhu() >= 10000){
           menu.add(new MenuItemFinalFight("Finální boj",hrdinove,sampion));
        }
        menu.add(new MenuItemUpgrade("Upgrade", hrdinove, nepratele));
        menu.add(new MenuItemEnd("Konec", hrdinove, nepratele));
        while (!exit) {
            MenuItem item = menu.execute();
            exit = item.execute();
        }
    }
}