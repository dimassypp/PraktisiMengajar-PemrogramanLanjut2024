/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.praktikgui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class PraktikGUI extends JFrame {
    private Queue<String> antrian = new LinkedList<>();
    private JTextArea daftarAntrian;
    private JTextField namaInput;
    private static final String FILE_NAME = "antrian.txt";

    public PraktikGUI() {
        setTitle("Sistem Antrian Sederhana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text area untuk daftar antrian
        daftarAntrian = new JTextArea();
        daftarAntrian.setEditable(false);
        add(new JScrollPane(daftarAntrian), BorderLayout.CENTER);

        // Panel bawah untuk input nama dan tombol
        JPanel panelBawah = new JPanel();
        panelBawah.setLayout(new BorderLayout());

        // Text field untuk input nama
        namaInput = new JTextField();
        panelBawah.add(namaInput, BorderLayout.CENTER);

        // Panel tombol
        JPanel panelTombol = new JPanel();
        JButton ambilNomorButton = new JButton("Ambil Nomor Antrian");
        JButton panggilAntrianButton = new JButton("Panggil Antrian");
        panelTombol.add(ambilNomorButton);
        panelTombol.add(panggilAntrianButton);
        panelBawah.add(panelTombol, BorderLayout.SOUTH);

        add(panelBawah, BorderLayout.SOUTH);

        // Event listeners
        ambilNomorButton.addActionListener(e -> ambilNomorAntrian());
        panggilAntrianButton.addActionListener(e -> panggilAntrian());

        // Load antrian from file
        loadAntrian();
        updateDaftarAntrian();
    }

    private void ambilNomorAntrian() {
        String nama = namaInput.getText().trim();
        if (!nama.isEmpty()) {
            antrian.add(nama);
            int nomorAntrian = antrian.size();
            Date tanggal = new Date();
            saveAntrian(nama, nomorAntrian, tanggal);
            updateDaftarAntrian();
            namaInput.setText("");
            JOptionPane.showMessageDialog(this, "Nomor antrian Anda: " + nomorAntrian);
        } else {
            JOptionPane.showMessageDialog(this, "Nama pasien tidak boleh kosong");
        }
    }

    private void panggilAntrian() {
        if (!antrian.isEmpty()) {
            String panggilan = antrian.poll();
            JOptionPane.showMessageDialog(this, "Antrian yang dipanggil: " + panggilan);
            updateDaftarAntrian();
            updateAntrian();
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada antrian");
        }
    }

    private void updateDaftarAntrian() {
        daftarAntrian.setText("");
        int nomorAntrian = 1;
        for (String nama : antrian) {
            daftarAntrian.append(nomorAntrian++ + ". " + nama + "\n");
        }
    }

    private void saveAntrian(String nama, int nomorAntrian, Date tanggal) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(nama + "," + nomorAntrian + "," + tanggal + "\n");
            System.out.println("Data antrian disimpan: " + nama + "," + nomorAntrian + "," + tanggal);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data antrian: " + e.getMessage());
        }
    }

    private void loadAntrian() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    antrian.add(parts[0]);
                }
            }
            System.out.println("Data antrian dimuat dari file.");
        } catch (FileNotFoundException e) {
            System.out.println("File antrian tidak ditemukan, mulai dengan antrian kosong.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file antrian: " + e.getMessage());
        }
    }

    private void updateAntrian() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            int nomorAntrian = 1;
            for (String nama : antrian) {
                Date tanggal = new Date();
                writer.write(nama + "," + nomorAntrian++ + "," + tanggal + "\n");
            }
            System.out.println("File antrian diperbarui.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat memperbarui file antrian: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PraktikGUI().setVisible(true);
        });
    }
}
