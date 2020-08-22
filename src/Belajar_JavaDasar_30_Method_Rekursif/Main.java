package Belajar_JavaDasar_30_Method_Rekursif;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Masukan Nilai: ");
        int nilai = userInput.nextInt();
//        PrintNilai(nilai);

        System.out.println("Rekursif +: " + jumlahNilai(nilai));
        System.out.println("Faktorial *: " + faktorial(nilai));
    }

    public static int faktorial(int parameter){

        if(parameter == 1) return parameter ;
        return parameter * faktorial(parameter - 1 );
    }

    public static int jumlahNilai(int parameter){

        if(parameter == 0) return parameter ;
        return parameter + jumlahNilai(parameter - 1 );
    }

    private static void PrintNilai(int parameter){
        if(parameter == 0){
            return;
        }
        parameter--;
        PrintNilai(parameter);
    }
}
