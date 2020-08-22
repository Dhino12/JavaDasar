package Belajar_JavaDasar_17_Nested_IF;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Masukan nilai: ");
        int i = userInput.nextInt();

        if(i == 5 || (i >= 0 && i <= 15) ){

            System.out.printf("i = %d\n",i);

            if(i >= 5 && i <= 10){
                System.out.println(i + " dianatara 5 dan 10");
            }else {
                System.out.println(i + " Tidak dianatara 5 dan 10");
            }

        }else {
            System.out.println("i != 5");
        }
    }
}
