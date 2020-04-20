package lesson02lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Generics {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Andrés",
                "Juan",
                "Carlos",
                "Daniel"
        );

        List<Integer> lengths = transform(names, String::length);
        System.out.println(lengths);
    }

    public static <IN, OUT> List<OUT> transform(List<IN> list, Function<IN, OUT> transformation) {
        List<OUT> result = new ArrayList<>();
        for (IN element : list) {
            OUT transformed = transformation.apply(element);
            result.add(transformed);
        }
        return result;
    }
}
