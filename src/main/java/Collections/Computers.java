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

    public void searchComputer(String computer) {
        for (String storedComputer : storedComputers) {
            if (storedComputers.contains(computer)) {
                System.out.println("Комьютер в наличии");
            } else System.out.println("Комьютера нет в наличии");
        }
    }
}