import java.util.*;

class ExcHandling {
    public static void main(String[] args) {
        Queue<String> antrian = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Selamat Datang di Rumah Sakit");
                System.out.println("1. Ambil Nomor Antrian");
                System.out.println("2. Panggil Antrian");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                int pilihan = input.nextInt();
                
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama pasien: ");
                        String nama = input.next();
                        antrian.add(nama);
                        System.out.println("Nomor antrian Anda: " + antrian.size());
                        break;
                    case 2:
                        if (!antrian.isEmpty()) {
                            String panggilan = antrian.poll();
                            System.out.println("Antrian yang dipanggil: " + panggilan);
                        } else {
                            System.out.println("Tidak ada antrian");
                        }
                        break;
                    case 3:
                        System.out.println("Terima kasih");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Masukkan pilihan yang valid");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                input.nextLine();
            }
        }
    }
}
