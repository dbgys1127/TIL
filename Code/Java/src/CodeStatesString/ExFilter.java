package CodeStatesString;
import java.util.Arrays;
import java.util.List;

public class ExFilter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("김코딩","이자바","김인기","김코딩");
        names.stream()
                .distinct()
                .forEach(n-> System.out.println(n));
        System.out.println();
        names.stream()
                .filter(n->n.startsWith("김"))
                .forEach(n-> System.out.println(n));
        System.out.println();
        names.stream()
                .distinct()
                .filter(n->n.startsWith("김"))
                .forEach(n-> System.out.println(n));
    }
}
