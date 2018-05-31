import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample {

    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Rohim", "Masum", "Faisal", "Sourav", "Kamrul", "Rajon");

        for (String name : names) {
            if(!name.equals("Masum"))
            {
                System.out.println(name);
            }
        }

        System.out.println("\nUsing Stream \n");

        names.stream().filter(new Predicate<String>() {
            public boolean test(String name) {
                return !name.equals("Masum");
            }
        }).forEach(name -> System.out.println(name));

        System.out.println("\nUsing Stream with Lamda \n");

        names.stream().filter(name -> !name.equals("Masum")).forEach(System.out::println);
    }
}
