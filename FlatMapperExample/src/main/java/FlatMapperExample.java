import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapperExample {

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(
                new User("Rohim", 25, Arrays.asList("1", "2")),
                new User("Faisal", 23, Arrays.asList("3", "4")),
                new User("Rajon", 24, Arrays.asList("5", "6", "7")),
                new User("Sourav", 25, Arrays.asList("8", "9")),
                new User("Kamrul", 25, Arrays.asList("10"))
        );

        System.out.println("With Stream \n");
        String s ="7";

        Optional<Object> num = userList.stream()
                .map(user -> user.getNum().stream())
                .flatMap(new Function<Stream<String>, Stream<?>>() {
                    @Override
                    public Stream<?> apply(Stream<String> stringStream) {
                        return stringStream.filter(num -> num.equals("5"));
                    }
                })
                .findAny();

        num.ifPresent(System.out::println);

        Optional<String> stringOptional = userList.stream()
                .map(user -> user.getNum().stream())
                .flatMap(stringStream -> stringStream.filter(number -> number.equals(s)))
                .findAny();
        stringOptional.ifPresent(System.out::println);


        // Demo Filter

        for (User user : userList) {
            Optional<String> ss = user.getNum().stream().filter(n -> n.equals(s)).findAny();
            ss.ifPresent(s1 -> System.out.println(user));
        }

      userList.forEach(user -> user.getNum().stream().filter(n -> n.equals(s)).forEach(s1 -> System.out.println(user)));



    }
}
