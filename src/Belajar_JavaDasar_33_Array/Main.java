package Belajar_JavaDasar_33_Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Tipedata [] nama = {komponen - komponen};
        //  index  0 1 2
        System.out.println("=== Array Assigment ===");
        int[] a = {1,2,3};
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);

        //Deklarasi
        //Tipedata[] nama = new int[jumlahInt]
        System.out.println("=== Hanya Deklarasi Array ===");
        float[] arrayFloat = new float[5];

        arrayFloat[3] = 11.6f;

        System.out.println(arrayFloat[0]);
        System.out.println(arrayFloat[1]);
        System.out.println(arrayFloat[2]);
        System.out.println(arrayFloat[3]);
        System.out.println(arrayFloat[4]);

        System.out.println("=== isi Array ===");
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(arrayFloat));
        System.out.println("=== Panjang Array ===");
        System.out.println(a.length);
        System.out.println(arrayFloat.length);
    }
}
