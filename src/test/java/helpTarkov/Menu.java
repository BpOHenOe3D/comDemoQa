package helpTarkov;

public enum Menu {
    Quest("Квесты"), Maps("Карты, ключи, выходы");

    String elements;

    Menu(String elements) {
        this.elements = elements;
    }

    public String getElements() { return elements; }
}
