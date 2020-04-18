package lesson01behaviour;

import commons.Apple;
import commons.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BehaviourParametrization {

    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> apples, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> apples, Integer weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> apples, Color color, Integer weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    public static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public static class AppleGreenPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Color.GREEN.equals(apple.getColor());
        }
    }

    static class RedAndHeavyApples implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Color.RED.equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    public static List<Apple> filterApplesP(List<Apple> apples, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(Color.GREEN, 100),
                new Apple(Color.GREEN, 150),
                new Apple(Color.GREEN, 180),
                new Apple(Color.GREEN, 200),
                new Apple(Color.RED, 90),
                new Apple(Color.RED, 140),
                new Apple(Color.RED, 160),
                new Apple(Color.RED, 210)
        );

        List<Apple> redAndHeavyApples = filterApplesP(apples, new RedAndHeavyApples());
        List<Apple> greenAndHeavyApples = filterApplesP(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.GREEN.equals(apple.getColor()) && apple.getWeight() > 150;
            }
        });
        List<Apple> redAndLightApples = filterApplesP(apples, apple -> apple.getWeight() < 150 && Color.RED.equals(apple.getColor()));

        System.out.println(redAndLightApples);

    }


}
