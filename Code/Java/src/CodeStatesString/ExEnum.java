package CodeStatesString;

enum Season{SPRING,SUMMER,FALL,WINTER}

public class ExEnum {
    public static void main(String[] args) {
        Season season = Season.SUMMER;
        Season [] allSeason = Season.values();
        for(Season s : allSeason)
            System.out.println(s.name()+"="+s.ordinal());
        Season findSeason = Season.valueOf("FALL");
        System.out.println(findSeason);
        System.out.println(Season.SPRING==Season.valueOf("SPRING"));
        System.out.println(Season.SPRING.compareTo(Season.FALL));
        switch (season){
            case SPRING:
                System.out.println("봄");
                break;

            case SUMMER:
                System.out.println("여름");
                break;

            case FALL:
                System.out.println("가을");
                break;

            case WINTER:
                System.out.println("겨울");
                break;


        }
    }
}
