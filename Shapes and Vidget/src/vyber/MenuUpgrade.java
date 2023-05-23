package vyber;

import java.util.*;

public class MenuUpgrade {
    private String pokyn;

    private List<UpgradeItem> menuItems = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public MenuUpgrade(String pokyn){
        this.pokyn = pokyn;
    }
    public void show(){
        System.out.println(pokyn);
        for(int i = 0; i < menuItems.size(); i++){
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }

    public UpgradeItem selection() {
        System.out.println();
        int input = scanner.nextInt();
        System.out.println();

        return selection(input);
    }

    public UpgradeItem selection(int userInput) {
        int index = userInput - 1;
        if (index < 0 || index >= menuItems.size()) {
            System.out.println("Index " + userInput + " is not valid input");
            return null;
        }
        return menuItems.get(index);
    }
    public void add(UpgradeItem upgradeItem) {
        this.menuItems.add(upgradeItem);
    }
    public UpgradeItem execute() {
        UpgradeItem item = null;
        do {
            show();
            item = this.selection();
        } while (item == null);

        return item;
    }
}
