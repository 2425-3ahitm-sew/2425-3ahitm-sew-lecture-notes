package at.htl;

import java.util.Arrays;

public class Car {

    int horsePower;   // Instanzvariable
    int[] numbers = new int[3];


    void foo(int hp) {
        System.out.println(hp);
        hp = hp * 2 ;
        System.out.println(hp);
    }

    void bar(int[] ns) {
        System.out.println(ns[0]);
        ns[0] = ns[0] * 2;
        System.out.println(ns[0]);
    }

    public static void main(String[] args) {
        var c = new Car();
        c.horsePower = 34;
        System.out.printf("horsepower %d%n", c.horsePower);
        c.foo(c.horsePower);
        System.out.printf("horsepower %d%n", c.horsePower);
        System.out.println("---------");
        c.numbers[0] = 1100;
        System.out.printf("hubraum %d%n", c.numbers[0]);
        c.bar(c.numbers);
        System.out.printf("hubraum %d%n", c.numbers[0]);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return horsePower == car.horsePower && Arrays.equals(numbers, car.numbers);
    }

    @Override
    public int hashCode() {
        int result = horsePower;
        result = 31 * result + Arrays.hashCode(numbers);
        return result;
    }

}
