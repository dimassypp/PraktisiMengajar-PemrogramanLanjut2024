import java.util.*;

public class QueueList {
    public static void main(String[] args) {
        Queue<String> nama = new ArrayDeque<>();
        
        nama.offer("Mel");
        nama.offer("Flor");
        
        for(String next = nama.poll(); next != null; next = nama.poll()) {
            System.out.println(next);
        }
        
        System.out.println(nama.size());
    }
}