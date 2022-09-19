package Collections;

import java.util.ArrayList;
import java.util.List;

public class Computers {
    List<String> storedComputers = new ArrayList<>();

    public void addNewComputer(String computer) {
        storedComputers.add(computer);
    }

    public void removeComputer(String computer) {
        storedComputers.remove(computer);
    }

    public void printComputer() {
        for (int i = 0; i <= storedComputers.size(); i++) {
            System.out.println("Комьютер в продаже " + i);
        }
    }

    public void searchComputer(String author) {
        for (String storedComputer : storedComputers) {
            if (storedComputers.contains(author)) {
                System.out.println("Комьютер в наличии");
            } else System.out.println("Комьютера нет в наличии");
        }


    }
}