package lesson02lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Luis", 30),
                new Person("Andrés", 28),
                new Person("Juan", 18),
                new Person("Mateo", 21),
                new Person("Sebastian", 36)
        );

        Predicate<Person> isOlderThan21 = person -> person.getAge() > 21;
        List<Person> peopleOlderThan21 = filter(people, isOlderThan21);
        System.out.println(peopleOlderThan21);

        Predicate<Person> isYoungerThan30 = person -> person.getAge() < 30;
        Predicate<Person> isIn20s = isOlderThan21.and(isYoungerThan30);
        List<Person> in20sPeople = filter(people, isIn20s);
        System.out.println(in20sPeople);
    }

    public static List<Person> filter(List<Person> people, Predicate<Person> predicate) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            boolean condition = predicate.test(person);
            if (condition) {
                result.add(person);
            }
        }
        return result;
    }


    public static class Person {
        private final String name;
        private final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("{name: %s, age: %s}", name, age);
        }
    }
}
