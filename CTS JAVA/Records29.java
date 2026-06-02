import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class Records29 {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Mervyn", 21),
                new Person("John", 17),
                new Person("Alex", 25)
        );

        System.out.println("All Persons:");

        for(Person p : people) {
            System.out.println(p);
        }

        System.out.println("\nAge >= 18:");

        List<Person> adults = people.stream()
                .filter(p -> p.age() >= 18)
                .collect(Collectors.toList());

        for(Person p : adults) {
            System.out.println(p);
        }
    }
}