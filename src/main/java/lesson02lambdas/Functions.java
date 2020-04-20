package lesson02lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Functions {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Luis", 30),
                new Person("Andrés", 28),
                new Person("Juan", 18),
                new Person("Mateo", 21)
        );


        Function<Person, String> getPersonName = person -> person.getName();
        List<String> names = transform(people, getPersonName);
        System.out.println(names);


        Function<String, String> toUpperCase = string -> string.toUpperCase();

        Function<Person, String> personStringFunction = getPersonName.andThen(toUpperCase);
        List<String> namesUpperCase = transform(people, personStringFunction);
        System.out.println(namesUpperCase);
    }

    public static List<String> transform(List<Person> people, Function<Person, String> transformer) {
        List<String> result = new ArrayList<>();
        for (Person person : people) {
            String value = transformer.apply(person);
            result.add(value);
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
