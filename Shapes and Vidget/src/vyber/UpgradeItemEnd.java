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
        return true;
    }
}
