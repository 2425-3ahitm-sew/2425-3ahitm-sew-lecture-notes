package at.htl.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Using a Consumer to print each element of the list
        Consumer<String> printName = name -> System.out.println(name);
        names.forEach(printName);
    }


}
