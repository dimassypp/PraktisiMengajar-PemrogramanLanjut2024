import java.io.*;
import java.util.*;

class AntrianOperationPrac {
    private static final String FILE_NAME = "antrian.txt";
    
    public static void main(String[] args) {
        Queue<String> antrian = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        // Load data dari file 
        loadAntrrian(antrian);

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
                        int nomorAntrian = antrian.size();
                        Date tanggal = new Date();
                        saveAntrian(nama, nomorAntrian, tanggal);
                        System.out.println("Nomor antrian Anda: " + nomorAntrian);
                        break;
                    case 2:
                        if (!antrian.isEmpty()) {
                            String panggilan = antrian.poll();
                            System.out.println("Antrian yang dipanggil: " + panggilan);
                            updateAntrian(antrian);
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

    private static void saveAntrian(String nama, int nomorAntrian, Date tanggal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(nama + "," + nomorAntrian + "," + tanggal + "\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data antrian: " + e.getMessage());
        }
    }

    private static void loadAntrrian(Queue<String> antrian) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    antrian.add(parts[0]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File antrian tidak ditemukan, mulai dengan antrian kosong.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file antrian: " + e.getMessage());
        }
    }

    private static void updateAntrian(Queue<String> antrian) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            int nomorAntrian = 1;
            for (String nama : antrian) {
                Date tanggal = new Date();
                writer.write(nama + "," + nomorAntrian++ + "," + tanggal + "\n");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat memperbarui file antrian: " + e.getMessage());
        }
    }
}
