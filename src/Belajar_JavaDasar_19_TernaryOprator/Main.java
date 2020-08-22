package Belajar_JavaDasar_19_TernaryOprator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //=========== TERNARY OPERATOR ================
        int a = 1;
        int x = (a == 1) ? (a = 1 + 1 ) : (a = 3 * 2);
        System.out.println("x = " + x);
        //=============================================

        //=============================================
        Scanner inputUser = new Scanner(System.in);
        System.out.print("Masukan Nilai: ");
        a = inputUser.nextInt();
        x = (a == 10) ? (a = a * a ) : (a = a / 2);
        System.out.println("Hasil : " + x);
        //=============================================
    }
}
