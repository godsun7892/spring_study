package tobyspring.hellospring;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        List<String> scores = Arrays.asList("s", "gwef", "EWfef", "d");
        Collections.sort(scores, (o1, o2) -> o1.length() - o2.length());


        scores.forEach(System.out::println);
    }
}
