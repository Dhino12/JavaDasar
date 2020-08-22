package Belajar_JavaDasar_24_Latihan_Looping;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nilaiAwal,nilaiAkhir,total;
        Scanner inputUser = new Scanner(System.in);

        System.out.print("Masukan Nilai Awal: ");
        nilaiAwal = inputUser.nextInt();

        System.out.print("Masukan Nilai Akhir: ");
        nilaiAkhir = inputUser.nextInt();
        total = 0;

        while (nilaiAwal <= nilaiAkhir){
            total += nilaiAwal;
            System.out.println("ditambah " + nilaiAwal + " Menjadi " + total);
            nilaiAwal++;
        }
    }
}
