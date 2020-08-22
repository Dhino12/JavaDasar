package Belajar_JavaDasar_51_CRUD_MainMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner consoleInput = new Scanner(System.in);
        String pilihanUser;
        boolean Lanjutkan = true;

        while (Lanjutkan) {
            clearScreen();
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
                    break;
                case "2":
                    System.out.println("==================");
                    System.out.println("Cari Seluruh Buku");
                    System.out.println("==================");
                    break;
                case "3":
                    System.out.println("==================");
                    System.out.println("Tambah Buku");
                    System.out.println("==================");
                    break;
                case "4":
                    System.out.println("==================");
                    System.out.println("Ubah Buku");
                    System.out.println("==================");
                    break;
                case "5":
                    System.out.println("==================");
                    System.out.println("Hapus Buku");
                    System.out.println("==================");
                    break;
                default:
                    System.err.println(
                            "\nInput anda tidak ditemukan\nSilahkan Pilih [1 - 5]"
                    );
            }
            Lanjutkan = getYESorNO("Ingin Lanjut?");
        }
    }

    private static void tampilkanData() throws IOException{
        boolean isTambah = getYESorNO("Ingin Tambah Data?");
    }
    private static boolean getYESorNO(String message){
        Scanner consoleInput = new Scanner(System.in);
        System.out.print("\n" + message +" (Y/N)");
        String pilihanUser = consoleInput.next();;

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("Pilihan Anda Bukan Y/N !!...");
            System.out.print("\n" + message +" (Y/N)");
            pilihanUser = consoleInput.next();;
        }

        return pilihanUser.equalsIgnoreCase("y");
    }
    private static void clearScreen(){
        try {
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\033\143");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
