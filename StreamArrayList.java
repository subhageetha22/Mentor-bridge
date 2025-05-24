import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
public class StreamArrayList {
    public static void main(String args[]) {
        List<String> names = new ArrayList<>();
        names.add("anand");
        names.add("bob");
        names.add("ram");
        names.add("divith");
        names.add("elan");
        Stream<String> data = names.stream();
        System.out.println("Names in the list:");
        data.forEach(n -> System.out.println(n));
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        String search = obj.next();
        Optional<String> result = names.stream().filter(n -> n.equalsIgnoreCase(search)).findFirst();
        if (result.isPresent()) {
            System.out.println("Element Found: " + result.get());
        } else {
            System.out.println(search + " not found");
        }
        obj.close();
    }
}