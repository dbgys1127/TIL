package Ch14_Lamda;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamEx3 {
    public static void main(String[] args) {
        Student[] stuArr  = {
                new Student("이",3,300),
                new Student("김",1,100),
                new Student("박",2,150),
                new Student("안",2,200),
                new Student("권",1,290),
                new Student("방",3,180)
    };


        Stream<Student> stuStream = Stream.of(stuArr);
        
        stuStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        stuStream = Stream.of(stuArr);
        IntStream stuScoreStream = stuStream.mapToInt(Student::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count="+stat.getCount());
        System.out.println("stat.getSum() = " + stat.getSum());
        System.out.println("stat.getAverage() = " + stat.getAverage());
        System.out.println("stat.getMin() = " + stat.getMin());
        System.out.println("stat.getMax() = " + stat.getMax());
        
    }
}

