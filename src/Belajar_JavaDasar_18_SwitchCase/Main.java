package Belajar_JavaDasar_18_SwitchCase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Switch Case
        // Ekpresi berupa satuan (int, long, byte, short) ,String, Enum

        Scanner userInput = new Scanner(System.in);
        System.out.print("Panggil Nama: ");
        String input = userInput.next();
        switch (input){
            case "latina":
            case "hatena":
                System.out.println(input);
                break;
            default:
                System.out.println("Tidak Hadir");
        }
    }
}
