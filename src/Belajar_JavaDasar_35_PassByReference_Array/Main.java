package Belajar_JavaDasar_35_PassByReference_Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayAngka1 = {1,2,3,4,5};
        int[] arrayAngka2 = new int[5];

        System.out.println("==== TIDAK BISA BERBEDA ANTAR DUA ARRAY ====");

        System.out.println("[Before] Memori Array1: " + arrayAngka1);
        System.out.println("[Before] Memori Array2: " + arrayAngka2);

        //Kerena ini bukan hanya mengoper value
            //tetapi memindahkan address dengan value
        arrayAngka2 = arrayAngka1;


        System.out.println(Arrays.toString(arrayAngka1));
        System.out.println(Arrays.toString(arrayAngka2));

        System.out.println("[After] Memori Array1: " + arrayAngka1);
        System.out.println("[After] Memori Array2: " + arrayAngka2);
        System.out.println();
        System.out.println("Method Pass By Reference");
        ubahArray(arrayAngka1);
    }

    //Method yang argumentnya adalah reference = Pass By Reference
        // BUKAN PASS BY VALUE
    public static void ubahArray(int[] dataArray){
        for (int value: dataArray) {
            System.out.println("[Before]: " + value);
        }

        dataArray[0] = 125;

        for (int value: dataArray) {
            System.out.println("[After]: " + value);
        }
    }
}
