package lesson03streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsIntroduction {
    public static void main(String[] args) {
        List<Pizza> pizzaList = Arrays.asList(
                new Pizza("Básica", Size.SMALL, 600),
                new Pizza("Familiar", Size.LARGE, 1800),
                new Pizza("Vegetariana", Size.LARGE, 860),
                new Pizza("Solo queso", Size.MEDIUM, 1000),
                new Pizza("Hawaiana", Size.SMALL, 1200),
                new Pizza("Extra carnes", Size.LARGE, 2100),
                new Pizza("Pollo", Size.SMALL, 900),
                new Pizza("Pollo + tocineta", Size.MEDIUM, 1500),
                new Pizza("Pollo + Jamon", Size.MEDIUM, 1300)
        );

        Predicate<Pizza> isLowCalories = pizza -> pizza.getCalories() < 1100;
        Function<Pizza, String> getPizzaName = Pizza::getName;

        List<Pizza> lowCalories = filter(pizzaList, isLowCalories);
        System.out.println(lowCalories);

        List<String> lowCaloriesNames = transform(lowCalories, getPizzaName);
        System.out.println(lowCaloriesNames);

        List<String> lowCaloriesPizzaNames = pizzaList
                .stream()
                .filter(pizza -> pizza.getCalories() < 1100)
                .map(Pizza::getName)
                .collect(Collectors.toList());

        System.out.println(lowCaloriesPizzaNames);
    }

    public static <IN, OUT> List<OUT> transform(List<IN> list, Function<IN, OUT> transformation) {
        List<OUT> result = new ArrayList<>();
        for (IN element : list) {
            OUT transformed = transformation.apply(element);
            result.add(transformed);
        }
        return result;
    }

    public static <IN> List<IN> filter(List<IN> list, Predicate<IN> predicate) {
        List<IN> result = new ArrayList<>();
        for (IN element : list) {
            boolean pass = predicate.test(element);
            if (pass) {
                result.add(element);
            }
        }
        return result;
    }


    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    public static class Pizza {
        private final String name;
        private final Size size;
        private final Integer calories;

        public Pizza(String name, Size size, Integer calories) {
            this.name = name;
            this.size = size;
            this.calories = calories;
        }

        public Size getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        public Integer getCalories() {
            return calories;
        }

        @Override
        public String toString() {
            return String.format("Pizza{%s, %s, %s}", name, size, calories);
        }
    }


}
