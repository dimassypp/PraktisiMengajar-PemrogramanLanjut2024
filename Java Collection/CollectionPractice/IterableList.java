import java.util.*;

public class IterableList {

    public static void main(String[] args) {
        Iterable<String> nama = List.of("Carlo", "Ancel");
        
        // Java 5 kebawah
        Iterator<String> iterator = nama.iterator();

        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
        
        // diatas Java 5
        for(var name: nama) {
            System.out.println(name);
        }
    }
}