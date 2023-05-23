package vyber;

import postava.SeznamHrdinu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UpgradeItemEnd extends UpgradeItem {
    public UpgradeItemEnd(String description, SeznamHrdinu hrdina) {
        super(description, hrdina);
    }

    @Override
    public boolean execute() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("postavy.txt"))) {
            for (int i = 0; i < hrdina.getHrdinove().size(); i++) {
                bw.write(hrdina.getHrdinove().get(i).doCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Problem se ctenim ze souboru.");
        }
        return true;
    }
}
