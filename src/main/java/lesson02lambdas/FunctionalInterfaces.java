package lesson02lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Luis", 30),
                new Person("Andrés", 28),
                new Person("Juan", 18),
                new Person("Mateo", 21)
        );


        Consumer<Person> printPerson = person -> System.out.println(person);
        people.forEach(printPerson);

        Supplier<Person> personCreator = () -> new Person("Cristian", 24);
        System.out.println(personCreator.get());
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
