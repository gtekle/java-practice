import com.streams_api.Gender;
import com.streams_api.Person;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Filer - Imperative Approach
        List<Person> females = new ArrayList<>();
        getPeople().forEach(person -> {
            if (person.getGender() == Gender.FEMALE) {
                females.add(person);
            }
        });
        System.out.println(females);
        System.out.println(getPeople());

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
