class Tv {
    // TV property(member variable)
    String color;
    boolean power;
    int channel;

    //TV function
    void power() {power=!power;}
    void channelUp() {
        channel++;
    }
    void channelDown() {
        channel--;
    }
}
class TvTest{
    public static void main(String[] args) {
        Tv t;
        t = new Tv();
        t.channel = 7;
        t.channelDown();
        System.out.println("present channel = "+t.channel );
    }
}

class TvTest2{
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("present channel = "+t1.channel );
        System.out.println("present channel = "+t2.channel );

        t1.channel = 7;
        System.out.println("present channel = "+t1.channel );
        System.out.println("present channel = "+t2.channel );

    }
}
class TvTest3{
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("present channel = "+t1.channel );
        System.out.println("present channel = "+t2.channel );

        t2=t1;

        t1.channel = 7;
        System.out.println("present channel = "+t1.channel );
        System.out.println("present channel = "+t2.channel );

    }
}
class TvTest4{
    public static void main(String[] args) {
        Tv [] tvArr = new Tv[3];
        for(int i=0;i< tvArr.length;i++){
            tvArr[i]=new Tv();
            tvArr[i].channel=i+10;
        }
        for(int i=0;i< tvArr.length;i++){
            tvArr[i].channelUp();
            System.out.println("tv"+(i+1)+" channel : "+tvArr[i].channel);
        }
    }
}