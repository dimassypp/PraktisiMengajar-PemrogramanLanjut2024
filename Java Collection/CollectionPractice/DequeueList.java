import java.util.*;

public class DequeueList {
    public static void main(String[] args) {
        Deque<String> daftarNama = new LinkedList<>();
        
        daftarNama.offerLast("Dima");
        daftarNama.offerLast("Sick");
        daftarNama.offerLast("Meng");
        
        for(String next = daftarNama.pollLast(); next != null; next = daftarNama.pollLast()) {
            System.out.println(next);
        }
    }
}