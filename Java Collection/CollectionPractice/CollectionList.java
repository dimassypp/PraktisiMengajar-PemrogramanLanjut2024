import java.util.*;

public class CollectionList {
    public static void main(String[] args) {
        Collection<String> nama = new ArrayList<>();
        nama.add("Meong");
        nama.add("Dimas");
        nama.addAll(Arrays.asList("Aji Santoso", "Thomas"));
        
        nama.remove("Thomas");
        
        for(var name: nama) {
            System.out.println(name);
        }
    }
}