package childparent;

public class ChildExtend {
    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel= 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCaption("try 1st : Hello World");
        ctv.caption = true;
        ctv.displayCaption("try 2nd : Hello World");
    }
}
class Tv{
    boolean power;
    int channel;

    void power() {
        power=!power;
    }
    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}

class CaptionTv extends Tv {
    boolean caption;

    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }
}
