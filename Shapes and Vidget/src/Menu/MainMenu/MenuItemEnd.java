package Menu.MainMenu;

import character.HeroArrayList;
import character.EnemyArrayList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MenuItemEnd extends MenuItem {
    public MenuItemEnd(String description, HeroArrayList hrdinove, EnemyArrayList nepratele) {
        super(description, hrdinove, nepratele);
    }

    @Override
    public boolean execute() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("postavy.txt"))) {
            for (int i = 0; i < hrdinove.getHrdinove().size(); i++) {
                bw.write(hrdinove.getHrdinove().get(i).doCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Problem se ctenim ze souboru.");
        }
        return true;
    }
}