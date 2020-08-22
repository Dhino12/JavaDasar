package Belajar_JavaDasar_37_ArrayMultidimensi;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Array2D =====");
        int[][] array2D = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12}
        };
        printArray2D(array2D);

        System.out.println("===== Array2D Deklarasi saja =====");
        //Array2D dengan deklarasi saja
        //int[baris][kolom]
        int[][] arrayAngka = new int[2][3];
        printArray2D(arrayAngka);

        System.out.println("===== Array2D Loop Manual =====");
        for (int i = 0 ; i < arrayAngka.length; i++){
            System.out.print("[");
            for (int j = 0 ; j < arrayAngka[i].length;j++){
                System.out.print(arrayAngka[i][j] + ",");
            }
            System.out.print("]\n");
        }
        System.out.println("===== Array2D Loop ForEach =====");
        for (int[] baris:arrayAngka) {
            System.out.print("[");
            for (int angka: baris) {
                System.out.print(angka + ",");
            }
            System.out.print("]\n");
        }
        System.out.println("===== Array2D Ragged =====");
        int[][] arrayRegged = {
                {1,2,3},
                {4,5,6,7},
                {8}
        };
        printArray2D(arrayRegged);

        char[] arrayChar1 = {'a','b','c'};
        char[] arrayChar2 = {'d','e','f'};
        char[][] arrayChar2D = {
                arrayChar1,
                arrayChar2
        };

        System.out.println("===== ArrayMultidimensi Lebih Dalam =====");
        System.out.println(arrayChar2D);
        System.out.println("ArrayChar1 = " + Integer.toHexString(System.identityHashCode(arrayChar1)));
        System.out.println("ArrayChar2 = " + Integer.toHexString(System.identityHashCode(arrayChar2)));
        System.out.println(Arrays.toString(arrayChar2D));
        System.out.println(Arrays.deepToString(arrayChar2D));

    }

    public static void printArray2D(int[][] dataArray){
        for (int i = 0; i < dataArray.length; i++){
            System.out.println(Arrays.toString(dataArray[i]));
        }
    }
}
