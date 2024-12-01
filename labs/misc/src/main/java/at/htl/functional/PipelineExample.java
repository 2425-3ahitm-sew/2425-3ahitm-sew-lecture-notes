package at.htl.functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PipelineExample {

    public static void main(String[] args) {
        bsp4();
    }

    public static void bsp1() {
        var number = List.of(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = number
                .stream()
                .map(i -> i * i)
                .distinct()
                //.toList();
                .collect(Collectors.toList());
    }

    public static void bsp2() {
        var numbers = List.of(10, 3, 5, 7, 2, 8, 6, 1, 9, 4);

        List<Integer> distinctEvenSquared = numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .map(n -> n * n)
                .toList();

        System.out.println(distinctEvenSquared);
    }

    public static void bsp3() {
        try (Stream<String> fileStream = Files.lines(Path.of("schoolplan.csv"))) {
            fileStream
                    .filter(s -> s.matches("^Montag.*"))  // Zeile, beginnend mit "Montag"
                    .map(s -> s.split(";")[1])            // 2. Spalte
                    .forEach(System.out::println);              // Ausgabe auf Konsole
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void bsp4() {
        var persons = List.of(
                new Person("Aigner", "Anton", 65),
                new Person("Berger", "Berta", 23),
                new Person("Czerveny", "Clemens", 34),
                new Person("Doll", "Doris", 25),
                new Person("Egger", "Emil", 83)
        );

        persons.stream()
                .filter(p -> p.getAge() <= 50)
                .peek(p -> System.out.println(p.getLastName()))
                .map(Person::getLastName)
                .reduce((i, j) -> i + ", " + j)
                .ifPresent(System.out::println);
    }


}
