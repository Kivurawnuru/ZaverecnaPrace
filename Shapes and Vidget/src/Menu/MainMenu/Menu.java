package Menu.MainMenu;

import java.util.*;

public class Menu {

    private String caption;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    Scanner scanner = new Scanner(System.in);

    public Menu(String caption) {
        this.caption = caption;
    }

    public void show() {
        System.out.println(caption);
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }

    public MenuItem selection() {
        System.out.println();
        int input = scanner.nextInt();
        System.out.println();

        return selection(input);
    }

    public MenuItem selection(int userInput) {
        int index = userInput - 1;
        if (index < 0 || index > menuItems.size()) {
            System.out.println("Index " + userInput + " is not valid input");
            return null;
        }

        return menuItems.get(index);
    }

    public void add(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }


    public MenuItem execute() {
        MenuItem item = null;
        do {
            show();
            item = this.selection();
        } while (item == null);

        return item;
    }
}

