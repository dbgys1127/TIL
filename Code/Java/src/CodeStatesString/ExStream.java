package CodeStatesString;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
class Student {
    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
}
public class ExStream {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("김코딩",95),
                new Student("이자바",92)
        );
        Stream<Student> stream = list.stream();
        stream.forEach(a->{
            String name = a.getName();
            int score = a.getScore();
            System.out.println(name+" "+score);
        });
    }
}
