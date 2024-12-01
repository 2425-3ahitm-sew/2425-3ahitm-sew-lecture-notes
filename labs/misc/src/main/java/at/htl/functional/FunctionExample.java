package at.htl.functional;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> addTwoFunction = x -> x + 2;
    }

    public static int addTwoMethod(int number) {
        return number + 2;
    }
}
