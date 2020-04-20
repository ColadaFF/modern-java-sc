package lesson02lambdas;

import java.util.Comparator;

public class AnonymousReplacement {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("I'm running");
        };

        r.run();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

    }
}
