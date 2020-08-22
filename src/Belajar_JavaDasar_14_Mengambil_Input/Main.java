package Belajar_JavaDasar_14_Mengambil_Input;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int panjang,lebar ,luas ,tinggi,volume;
        //Menghitung Luas
            // L = P * L
        System.out.println("\n==== Menghitung Luas ====");
        System.out.print("Panjang: ");
        panjang = userInput.nextInt();
        System.out.print("Lebar: ");
        lebar = userInput.nextInt();

        luas = panjang * lebar;
        System.out.printf("%d * %d : %d \n", panjang ,lebar ,luas);

        System.out.println("\n==== Menghitung Volume ====");
        System.out.print("Tinggi: ");
        tinggi = userInput.nextInt();

        volume = tinggi * luas;
        System.out.printf("%d * %d : %d \n", tinggi ,luas ,volume);
    }
}
