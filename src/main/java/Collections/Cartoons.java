package Collections;

import java.util.HashMap;
import java.util.Map;

public class Cartoons {

        Map<Integer, String> storedCartoons = new HashMap<>();

        public void addCartoon(int year, String name) {
            storedCartoons.put(year, name);
        }

        public void removeCartoon(String name) {
            storedCartoons.remove(name);
        }

        public void printCartoons() {
            for (Map.Entry<Integer, String> entry : storedCartoons.entrySet()) {
                System.out.println(entry.getKey() + "  " + entry.getValue());

            }
        }
}
