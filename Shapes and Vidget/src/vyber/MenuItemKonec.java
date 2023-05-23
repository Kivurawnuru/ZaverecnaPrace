package vyber;

import postava.Postava;
import postava.SeznamHrdinu;
import postava.SeznamNepratel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MenuItemKonec extends MenuItem {
    public MenuItemKonec(String description, SeznamHrdinu hrdinove , SeznamNepratel nepratele) {
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