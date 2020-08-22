package Belajar_JavaDasar_31_Method_Nested_Rekursif;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Masukan Nilai: ");
        int nilai = userInput.nextInt();

        System.out.println( "Nilai fibonacci ke " + nilai + " = " + fibonacci(nilai,"atas"));
    }

    public static int fibonacci(int n,String daun){
        System.out.println("daun " + daun);
        System.out.println("Fibonnaci ke- " + n);

        if(n == 1 || n == 0) return n;
        else

        return fibonacci(n - 1,"kiri") + fibonacci( n - 2 ,"kanan");
    }

}
