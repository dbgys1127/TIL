package CodeStatesString;
import java.util.*;
import java.util.stream.Stream;

public class ExMap {
    public static void main(String[] args) {
        Stream<String[]> stringArraysStream = Stream.of(
                new String[]{"hello", "world", "java"},
                new String[]{"code", "states"});

        stringArraysStream.map(Arrays::stream).forEach(System.out::println);
    }
}
