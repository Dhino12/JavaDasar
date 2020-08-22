package Belajar_JavaDasar_16_IF_ELSE_Statement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //IF STATEMENT / PERCABANGAN
        Scanner userInput = new Scanner(System.in);
        System.out.print("Masukan angka: ");
        int data = userInput.nextInt();
        System.out.println("Isi Data: " + data);
        if (data == 5){
            System.out.printf("\nApakah %d == 5 : %b \n",data,(data == 5));
        } else if(data >= 5){
            System.out.printf("Apakah %d >= 5 : %b \n",data,(data >= 5));
        } else {
            System.out.printf("%d != 5 ,dan %d <= 5 \n\n", data,data);
        }
        System.out.println("Selesai");
    }
}
