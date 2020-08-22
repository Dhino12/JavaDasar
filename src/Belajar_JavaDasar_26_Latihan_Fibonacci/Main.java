package Belajar_JavaDasar_26_Latihan_Fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int f_n,f_n1,f_n2, n;
        Scanner inputUser = new Scanner(System.in);

        System.out.print("Mengambil Nilai Fibonaci ke-: ");
        n = inputUser.nextInt();

        f_n2 = 0;
        f_n1 = 1;
        f_n = 1;
        for (int i = 0; i < n; i++){
            System.out.println("nilai ke- " + i + " = " + f_n);
            f_n = f_n1 + f_n2;
            f_n2 = f_n1;
            f_n1 = f_n;
        }

    }
}
