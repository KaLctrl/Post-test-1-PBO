/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.post_test1;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Destinasi {
        String nama;
        String lokasi;
        String kategori;

        Destinasi(String nama, String lokasi, String kategori) {
            this.nama = nama;
            this.lokasi = lokasi;
            this.kategori = kategori;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Destinasi> daftarWisata = new ArrayList<>();

        while (true) {
            System.out.println("\n=== MENU DESTINASI WISATA ===");
            System.out.println("1. Tambah Destinasi");
            System.out.println("2. Lihat Daftar Destinasi");
            System.out.println("3. Edit Destinasi");
            System.out.println("4. Hapus Destinasi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = input.nextInt();
            input.nextLine(); 

            if (pilih == 1) {
                // Tambah destinasi
                System.out.print("Masukkan nama destinasi: ");
                String nama = input.nextLine();
                System.out.print("Masukkan lokasi: ");
                String lokasi = input.nextLine();
                System.out.print("Masukkan kategori (Alam/Budaya/Kuliner/etc): ");
                String kategori = input.nextLine();

                daftarWisata.add(new Destinasi(nama, lokasi, kategori));
                System.out.println("✅ Destinasi berhasil ditambahkan!");

            } else if (pilih == 2) {
               
                if (daftarWisata.isEmpty()) {
                    System.out.println("⚠️ Belum ada destinasi yang tersimpan.");
                } else {
                    System.out.println("\n=== DAFTAR DESTINASI ===");
                    for (int i = 0; i < daftarWisata.size(); i++) {
                        Destinasi d = daftarWisata.get(i);
                        System.out.println((i + 1) + ". " + d.nama + " | Lokasi: " + d.lokasi + " | Kategori: " + d.kategori);
                    }
                }

            } else if (pilih == 3) {
                
                if (daftarWisata.isEmpty()) {
                    System.out.println("⚠️ Tidak ada data untuk diedit.");
                } else {
                    System.out.println("\nPilih destinasi yang akan diedit:");
                    for (int i = 0; i < daftarWisata.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarWisata.get(i).nama);
                    }
                    System.out.print("Masukkan nomor destinasi: ");
                    int index = input.nextInt();
                    input.nextLine();

                    if (index > 0 && index <= daftarWisata.size()) {
                        Destinasi d = daftarWisata.get(index - 1);

                        System.out.print("Nama baru (" + d.nama + "): ");
                        String namaBaru = input.nextLine();
                        System.out.print("Lokasi baru (" + d.lokasi + "): ");
                        String lokasiBaru = input.nextLine();
                        System.out.print("Kategori baru (" + d.kategori + "): ");
                        String kategoriBaru = input.nextLine();

                        if (!namaBaru.isEmpty()) d.nama = namaBaru;
                        if (!lokasiBaru.isEmpty()) d.lokasi = lokasiBaru;
                        if (!kategoriBaru.isEmpty()) d.kategori = kategoriBaru;

                        System.out.println("✅ Data destinasi berhasil diperbarui!");
                    } else {
                        System.out.println("⚠️ Nomor tidak valid.");
                    }
                }

            } else if (pilih == 4) {
                
                if (daftarWisata.isEmpty()) {
                    System.out.println("⚠️ Tidak ada data untuk dihapus.");
                } else {
                    System.out.println("\nPilih destinasi yang akan dihapus:");
                    for (int i = 0; i < daftarWisata.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarWisata.get(i).nama);
                    }
                    System.out.print("Masukkan nomor destinasi: ");
                    int index = input.nextInt();
                    input.nextLine();

                    if (index > 0 && index <= daftarWisata.size()) {
                        daftarWisata.remove(index - 1);
                        System.out.println("✅ Destinasi berhasil dihapus!");
                    } else {
                        System.out.println("⚠️ Nomor tidak valid.");
                    }
                }

            } else if (pilih == 5) {
                
                System.out.println("👋 Terima kasih! Program selesai.");
                break;

            } else {
                System.out.println("⚠️ Menu tidak tersedia, coba lagi.");
            }
        }

        input.close();
    }
}

