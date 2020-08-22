package Belajar_JavaDasar_15_Latihan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Program Tebak Angka ====================
        Scanner userInput = new Scanner(System.in);

        int nilaiBenar = 6;
        int nilaiTebakan;
        boolean statusTebakan;
        String berhenti = "Y";
        System.out.println("=== Program Tebak Angka === ");

        while (berhenti.equals("Y") || berhenti.equals("y")){
            System.out.print("Input: ");
            nilaiTebakan = userInput.nextInt();
            System.out.println("Nilai Tebakan : " + nilaiTebakan);
            System.out.println("Tebakan Anda : " + (nilaiBenar == nilaiTebakan));

            System.out.println("Apakah Nilai tebakan antara 0 - 6 ");
            statusTebakan = (nilaiTebakan > 0) && (nilaiTebakan < 6);
            System.out.println("==== " + statusTebakan + " ====");

            System.out.print("Lanjut? : ");
            berhenti = userInput.next();
            System.out.println();
        }
    }
}
