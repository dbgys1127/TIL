package modifier;

public class FinalModifier {
    public static void main(String[] args) {
        Card c = new Card(10, "HEART");
//        c.NUMBER = 5;
        System.out.println(c.KIND);
        System.out.println(c.NUMBER);
        System.out.println(c);
    }
}

class Card {
    final int NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    public Card(int NUMBER, String KIND) {
        this.NUMBER = NUMBER;
        this.KIND = KIND;
    }

    public Card() {
        this(1, "HEART");
    }

    @Override
    public String toString() {
        return "Card{" +
                "NUMBER=" + NUMBER +
                ", KIND='" + KIND + '\'' +
                '}';
    }
}
