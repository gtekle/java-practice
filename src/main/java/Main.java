import com.streams_api.Gender;
import com.streams_api.Person;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

//        Filer - Imperative Approach
        List<Person> females = new ArrayList<>();
        getPeople().forEach(person -> {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        });
        System.out.println(females);
        System.out.println(getPeople());

        //    Declarative approach - Filter
        var femaleList = getPeople().stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();
        System.out.println(femaleList);

        //    Declarative approach - Sort
        var sortedPeople = getPeople().stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getAge))
                .toList();

        System.out.println(sortedPeople);

//        All match
        boolean existAgeGreaterThanFive = getPeople().stream()
                .allMatch(person -> person.getAge() > 8);
        System.out.println(existAgeGreaterThanFive);

//        Any match
        boolean anyMatch = getPeople().stream()
                .anyMatch(person -> person.getAge() > 121);
        System.out.println(anyMatch);

//        None match
        boolean noneMatch = getPeople().stream()
                .noneMatch(person -> person.getAge() > 100);
        System.out.println(noneMatch);

//        Max
        Optional<Person> max = getPeople().stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println(max);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alitia Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
