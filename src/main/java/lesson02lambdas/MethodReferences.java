package lesson02lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {
        List<Bread> breads = Arrays.asList(
                new Bread(100),
                new Bread(200),
                new Bread(150),
                new Bread(400)
        );

        List<Integer> weights = transformBreadToWeight(breads, Bread::getWeight);
        System.out.println(weights);

        List<BreadSlices> breadSlices = transformBreadToSlices(breads, BreadSlices::fromBread);
        System.out.println(breadSlices);
    }

    public static List<Integer> transformBreadToWeight(List<Bread> breads, Function<Bread, Integer> transformer) {
        List<Integer> result = new ArrayList<>();
        for (Bread bread : breads) {
            Integer value = transformer.apply(bread);
            result.add(value);
        }
        return result;
    }

    public static List<BreadSlices> transformBreadToSlices(List<Bread> breads, Function<Bread, BreadSlices> transformer) {
        List<BreadSlices> result = new ArrayList<>();
        for (Bread bread : breads) {
            BreadSlices value = transformer.apply(bread);
            result.add(value);
        }
        return result;
    }


    public static class BreadSlices {
        private final Integer slices;

        public BreadSlices(Integer slices) {
            this.slices = slices;
        }

        public static BreadSlices fromBread(Bread bread) {
            Integer slices = bread.getWeight() / 10;
            return new BreadSlices(slices);
        }

        public Integer getSlices() {
            return slices;
        }

        @Override
        public String toString() {
            return String.format("BreadSlices{%s}", slices);
        }
    }

    public static class Bread {
        private final Integer weight;

        public Bread(Integer weight) {
            this.weight = weight;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return String.format("Bread{%s}", weight);
        }
    }
}
