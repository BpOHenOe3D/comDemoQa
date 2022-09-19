package Collections;

import java.util.HashSet;
import java.util.Set;

public class App {
    Set<String> storedApps = new HashSet<>();

    public void addApp(String app) {
        storedApps.add(app);
    }

    public void removeApp(String app) {
        storedApps.remove(app);
    }

    public void printApp() {
        int i = 0;
        while (i <= storedApps.size()) {
            i++;
            System.out.println(storedApps);
        }
    }

    public void searchApp(String app) {
        for (String storedApps : storedApps) {
            if (storedApps.contains(app)) {
                System.out.println("Приложение доступно");
            } else System.out.println("Приложение не найдено");
        }
    }
}