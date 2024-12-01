package at.htl.functional;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        List<String> students = List.of("Peter", "Paul", "Marie");
        Predicate<String> studentTest = name -> name.startsWith("M");
        boolean b = students.stream().anyMatch(studentTest);
        System.out.println(b);
    }

    public static boolean testStudent(String student) {
        return student.startsWith("M");
    }

}
