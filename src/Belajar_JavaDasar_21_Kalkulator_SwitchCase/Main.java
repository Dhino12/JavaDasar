package Belajar_JavaDasar_21_Kalkulator_SwitchCase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float a,b,hasil;
        String operator;
        Scanner inputUser;

        inputUser = new Scanner(System.in);

        System.out.print("Nilai A: ");
        a = inputUser.nextFloat();

        System.out.print("Operator: ");
        operator = inputUser.next();

        System.out.print("Nilai B: ");
        b = inputUser.nextFloat();

        switch (operator){
            case "+":
                System.out.printf("%.2f %s %.2f = %.2f",a,operator,b,( a + b ));
                break;
            case "-":
                System.out.printf("%.2f %s %.2f = %.2f",a,operator,b,( a - b ));
                break;
            case "/":
                System.out.printf("%.2f %s %.2f = %.2f",a,operator,b,( a / b ));
                break;
            case "*":
                System.out.printf("%.2f %s %.2f = %.2f",a,operator,b,( a * b ));
                break;
            default:
                System.out.println("Operator Tidak Ditemukan");
                break;
        }
    }
}
