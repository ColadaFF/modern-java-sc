package lesson01behaviour;

import java.util.Arrays;
import java.util.List;

public class BehaviourParametrization {

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


        System.out.println();

    }


    public static enum Color {
        RED,
        GREEN
    }

    public static class Apple {
        private final Color color;
        private final Integer weight;

        public Apple(Color color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return String.format("Apple{color: %s, weight: %s}", color, weight);
        }
    }

}
