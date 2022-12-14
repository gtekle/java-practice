import com.streams_api.Gender;
import com.streams_api.Person;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        boolean existAgeGreaterThanFive = getPeople().stream().allMatch(person -> person.getAge() > 8);
        System.out.println(existAgeGreaterThanFive);

//        Any match
        boolean anyMatch = getPeople().stream().anyMatch(person -> person.getAge() > 121);
        System.out.println(anyMatch);

//        None match
        boolean noneMatch = getPeople().stream().noneMatch(person -> person.getAge() > 100);
        System.out.println(noneMatch);

//        Max
        getPeople().stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

//        Min
        getPeople().stream().min(Comparator.comparing(Person::getGender)).ifPresent(System.out::println);

//        Group
        Map<Gender, List<Person>> groupByGender = getPeople().stream().collect(Collectors.groupingBy(Person::getGender));
        groupByGender.forEach((gender, people) -> {
            System.out.println(gender);
            people.stream().collect(Collectors.groupingBy(Person::getDept)).forEach((dept, byDeptPeople) -> {
                System.out.println(gender + "-" + dept);
                byDeptPeople.stream().map(Person::getName).forEach(System.out::println);
            });
            System.out.println();
        });

        Optional<String> oldestFemale = getPeople().stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemale.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE, "IT"),
                new Person("Alitia Smith", 33, Gender.FEMALE, "Operation"),
                new Person("Helen White", 57, Gender.FEMALE, "IT"),
                new Person("Alex Boz", 14, Gender.MALE, "Operation"),
                new Person("Jamie Goa", 99, Gender.MALE, "IT"),
                new Person("Anna Cook", 7, Gender.FEMALE, "Operation"),
                new Person("Zelda Brown", 120, Gender.FEMALE, "IT")
        );
    }
}
