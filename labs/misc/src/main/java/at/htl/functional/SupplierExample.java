package at.htl.functional;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Double> random1000 = () -> Math.random() * 1000;
        System.out.println(random1000.get());
    }

    public static double createRandomNumber() {
        return Math.random() * 1000.0;
    }
}
