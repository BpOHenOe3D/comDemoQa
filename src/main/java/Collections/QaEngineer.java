package Collections;

import java.util.Map;
import java.util.Set;

public class QaEngineer {
    private String name;
    private int age;
    private Map<String, Set<String>> skills;

    public QaEngineer(String name, int age, Map<String, Set<String>> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    public boolean haveSkill(String field, String skill) {
        for (Map.Entry<String, Set<String>> entry : skills.entrySet()) {
            if (entry.getKey().equals(field)) {
                for (String skillPerson : entry.getValue()) {
                    if (skillPerson.equals(skill)) return true;
                }
            }
        }
        return false;
    }
}
