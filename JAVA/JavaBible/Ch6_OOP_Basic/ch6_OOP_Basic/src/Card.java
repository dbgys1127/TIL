public class Card {
    String kind;
    int number;
    static int width=100;
    static int height=250;
}
class CardTest{
    public static void main(String[] args) {
        System.out.println("Card.width = "+Card.width);
        System.out.println("Card.height = "+Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 "+c1.kind+", "+c1.number+" 크기는 ("+Card.width+", "+Card.height+")");
        System.out.println("c2은 "+c2.kind+", "+c2.number+" 크기는 ("+Card.width+", "+Card.height+")");

        System.out.println("c1의 너비, 높이를 50,80 으로 바꿨습니다.");
        c1.width = 50;
        c1.height = 80;

        System.out.println("c1은 "+c1.kind+", "+c1.number+" 크기는 ("+Card.width+", "+Card.height+")");
        System.out.println("c2은 "+c2.kind+", "+c2.number+" 크기는 ("+Card.width+", "+Card.height+")");
    }
}
