package Belajar_JavaDasar_58_MultiFile.MAIN;

//Import JAVA Library

import java.io.IOException;
import java.util.Scanner;

//Import CRUD Library
import Belajar_JavaDasar_58_MultiFile.CRUD.Operasi;
import Belajar_JavaDasar_58_MultiFile.CRUD.Utility;


public class Main {
    public static void main(String[] args) throws IOException{
        Scanner consoleInput = new Scanner(System.in);
        String pilihanUser;
        boolean Lanjutkan = true;
        while (Lanjutkan) {
            Utility.clearScreen();
            System.out.println("Database Perpustakaan\n");
            System.out.println("1.\tLihat Seluruh Buku");
            System.out.println("2.\tCari Data Buku");
            System.out.println("3.\tTambah Data Buku");
            System.out.println("4.\tUbah Data Buku");
            System.out.println("5.\tHapus Data Buku");

            System.out.print("\n\nPilihan Anda: ");
            pilihanUser = consoleInput.next();

            switch (pilihanUser) {
                case "1":
                    System.out.println("==================");
                    System.out.println("List Seluruh Buku");
                    System.out.println("==================");
                    Operasi.tampilkanData();
                    break;
                case "2":
                    System.out.println("==================");
                    System.out.println("Cari Seluruh Buku");
                    System.out.println("==================");
                    Operasi.cariData();
                    break;
                case "3":
                    System.out.println("==================");
                    System.out.println("Tambah Buku");
                    System.out.println("==================");
                    Operasi.tambahData();
                    Operasi.tampilkanData();
                    break;
                case "4":
                    System.out.println("==================");
                    System.out.println("Ubah Buku");
                    System.out.println("==================");
                    Operasi.updateData();
                    break;
                case "5":
                    System.out.println("==================");
                    System.out.println("Hapus Buku");
                    System.out.println("==================");
                    Operasi.deleteData();
                    break;
                default:
                    System.err.println(
                            "\nInput anda tidak ditemukan\nSilahkan Pilih [1 - 5]"
                    );
            }
            Lanjutkan = Utility.getYESorNO("Ingin Lanjut? ");
        }
    }
}
