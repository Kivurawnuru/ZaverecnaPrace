package vyber;

import postava.SeznamHrdinu;
import postava.SeznamNepratel;

public class UserInterface {

    public void start() throws Exception {
        SeznamHrdinu hrdinove = null;
        SeznamNepratel nepratele = null;

        try {
            hrdinove = SeznamHrdinu.nacti("postavy.txt");
            nepratele = SeznamNepratel.nacti("nepratele.txt");
            MainMenu(hrdinove, nepratele);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("KONEC");
    }


    private boolean exit = false;

    public void MainMenu(SeznamHrdinu hrdinove, SeznamNepratel nepratele) throws Exception {
        Menu menu = new Menu("Vyber jednu možnost: ");
        menu.add(new MenuItemBoj("Souboj", hrdinove, nepratele));
        menu.add(new MenuItemUpgrade("Upgrade", hrdinove, nepratele));
        //Misto MenuItem pouziji tridy oddedene od MenuItem
        menu.add(new MenuItemKonec("Konec", hrdinove, nepratele));
        while (!exit) {
            MenuItem item = menu.execute();
            exit = item.execute();
        }
    }
}