import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lambda27 {
    public static void main(String[] args) {


        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Alex");
        names.add("David");
        names.add("Mervyn");

        Collections.sort(names, (a, b) -> b.length()-a.length());

        System.out.println("Sorted List:");

        for(String s : names) {
            System.out.println(s);
        }
    }
}

