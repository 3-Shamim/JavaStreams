import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapperExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Rohim", "Masum", "Faisal", "Sourav", "Kamrul", "Rajon");

        for (String name : names) {
            if(!name.equals("Faisal"))
            {
                User user = new User(name);
                System.out.println(user);
            }
        }

        System.out.println("\nJava Stream \n");

        names.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return !name.equals("Faisal");
            }
        }).map(new Function<String, User>() {
            @Override
            public User apply(String name) {
                return new User(name);
            }
        }).forEach(name -> System.out.println(name));

        System.out.println("\nJava Stream With Lamda \n");

        names.stream()
                .filter(name -> !name.equals("Faisal"))
                .map(name -> new User(name))
                .forEach(System.out::println);

        System.out.println("\nJava Stream With Lamda With Two Value \n");

        names.stream()
                .filter(name -> !name.equals("Faisal"))
                .map(name -> new User(name, 30))
                .forEach(System.out::println);

        System.out.println("\nCollect List By Stream \n");

        List<User> userList = names.stream()
                .filter(name -> !name.equals("Faisal"))
                .map(name -> new User(name, 26))
                .collect(Collectors.toList());

        userList.forEach(System.out :: println);

        // MapperInt

        //int i = (int) userList.stream().mapToInt(user -> user.getAge()).count();
        System.out.println("Count : " + userList.stream().mapToInt(user -> user.getAge()).count());
        System.out.println("Average : " + userList.stream().mapToInt(user -> user.getAge()).average());
        System.out.println("Sum : " + userList.stream().mapToInt(user -> user.getAge()).sum());

    }
}
