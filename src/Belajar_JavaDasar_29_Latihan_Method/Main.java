package Belajar_JavaDasar_29_Latihan_Method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int panjang ,lebar;
        Scanner inputUser = new Scanner(System.in);

        System.out.print("Panjang: ");
        panjang = inputUser.nextInt();

        System.out.print("Lebar: ");
        lebar = inputUser.nextInt();

        gambar(panjang,lebar);
        System.out.println("Luas : " + luas(panjang,lebar));
        System.out.println("Keliling : " + keliling(panjang,lebar));
    }

    public static int keliling(int panjang, int lebar){
        return panjang * lebar + 2;
    }

    private static int luas(int panjang,int lebar){
        return panjang * lebar;
    }

    private static void gambar(int panjang,int lebar){
        for(int i = 0; i < lebar;i++){
            for (int j = 0; j < panjang ; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
