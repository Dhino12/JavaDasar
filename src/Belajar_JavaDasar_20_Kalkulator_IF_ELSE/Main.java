package Belajar_JavaDasar_20_Kalkulator_IF_ELSE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float a,b,hasil = 0;
        char operator;

        Scanner userInput = new Scanner(System.in);
        System.out.print("Nilai A: ");
        a = userInput.nextFloat();

        System.out.print("Operator: ");
        operator = userInput.next().charAt(0);

        System.out.print("Nilai B: ");
        b = userInput.nextFloat();

        if(operator == '*'){
            hasil = a * b;
        }else if(operator == '/'){
            if(b == 0){
                System.out.println("Tidak bisa dibagi 0");
            }else {
                hasil = a / b;
            }
        }else if(operator == '-'){
            hasil = a - b;
        }else {
            hasil = a + b;
        }

        System.out.printf("%.2f %s %.2f : %.2f" ,a,operator,b,hasil);
    }
}
