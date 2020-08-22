package Belajar_JavaDasar_36_Array_Operation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayAngka1 = {1,2,3,4,5};

        System.out.println("==== Merubah Array menjadi String ====");
        printArray(arrayAngka1);

        //Mengcopy Array
        System.out.println("==== Mengcopy Array ====");
        int[] arrayAngka2 = new int[5];
        printArray(arrayAngka1);
        printArray(arrayAngka2);
        System.out.println("\n==== Dengan Loop ====");
        for(int i = 0 ; i < arrayAngka1.length; i++){
            arrayAngka2[i] = arrayAngka1[i];
        }
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka2);
        System.out.println(arrayAngka2);

        System.out.println("\n==== Dengan copyOf ====");
        int[] arrayAngka3 = Arrays.copyOf(arrayAngka1,3);
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka3);
        System.out.println(arrayAngka3);

        System.out.println("\n==== Dengan copyOfRange ====");
        int[] arrayAngka4 = Arrays.copyOfRange(arrayAngka1,3,5);
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka4);
        System.out.println(arrayAngka4);

        //Fill Array
        System.out.println("\n==== Fill Array ====");
        int[] arrayAngka5 = new int[10];
        printArray(arrayAngka5);
        Arrays.fill(arrayAngka5,5);
        printArray(arrayAngka5);

        System.out.println("\n==== Comparasi Array ====");
        int[] arrayAngka6 = {1,2,3,4,5};
        int[] arrayAngka7 = {1,2,3,4,5};
        System.out.println(Arrays.equals(arrayAngka6,arrayAngka7));
        arrayAngka7[2] = 10;
        System.out.println(Arrays.equals(arrayAngka6,arrayAngka7));

        System.out.println("\n==== Cek Array yang lebih besar ====");
            // Cek urutan keduaArray pertama yang paling besar
        System.out.println(Arrays.compare(arrayAngka6,arrayAngka7));

        if(Arrays.compare(arrayAngka6,arrayAngka7) == 0){
            System.out.println("Kedua Array Sama Besar");
        }else if(Arrays.compare(arrayAngka6,arrayAngka7) == -1){
            System.out.println(
                    "arrayAngka7 lebih besar\n" + Arrays.toString(arrayAngka7)
            );
        }else {
            System.out.println(
                    "arrayAngka6 lebih besar\n" + Arrays.toString(arrayAngka6)
            );
        }

        System.out.println("\n==== Cek Index Array yang berbeda ====");
        if(Arrays.mismatch(arrayAngka6,arrayAngka7) == -1){
            System.out.println("Tidak Ada Index yang berbeda");
        }else{
            System.out.println(
                    "Index yang berbeda ke: " + Arrays.mismatch(arrayAngka6,arrayAngka7)
            );
        }

        System.out.println("\n==== Sorting Array ====");
        int[] arrayAngka8 = {1,6,41,11,31,21,71};
        printArray(arrayAngka8);
        Arrays.sort(arrayAngka8);
        printArray(arrayAngka8);

        System.out.println("\n==== Search Array berdasarkan index ====");
        int angka = 31;
        int index = Arrays.binarySearch(arrayAngka8,angka);
        System.out.println("angka " + angka + " ada di index " + index);

        System.out.println("\n==== Sorting Reverse Array ====");
        int[] arrayKebalik = Arrays.copyOf(arrayAngka8,arrayAngka8.length);

        System.out.println("Before " + Arrays.toString(arrayKebalik));

        for(int i = 0; i < arrayAngka8.length; i++){
            arrayAngka8[i] = arrayKebalik[(arrayKebalik.length - 1 ) - i];
        }
        System.out.println("After " + Arrays.toString(arrayAngka8));
        System.out.println(" ----- Reverse2 -----");
        System.out.print("After ");
        reverse2(arrayAngka8);

        System.out.println("\n==== Jumlah 2 Array ====");
        int[] arrayAngka9 = {2,3,4,5,6,7,8};
        int[] arrayAngka10 = {0,1,3,5,6,10,1};
        int[] arrayHasil1 = tambahArray(arrayAngka9,arrayAngka10);
        printArray(arrayHasil1);

        System.out.println("\n==== Gabung 2 Array ====");
        int[] arrayHasil2 = new int[arrayAngka9.length + arrayAngka10.length];
        for(int i = 0 ; i < arrayAngka9.length;i++){
            arrayHasil2[i] = arrayAngka9[i] ;
        }
        for(int i = 0 ; i < arrayAngka10.length;i++){
            arrayHasil2[i + arrayAngka10.length] = arrayAngka10[i] ;
        }
        printArray(arrayAngka9);
        printArray(arrayAngka10);
        printArray(arrayHasil2);
    }

    public static void reverse2(int[] dataArray){
        Arrays.sort(dataArray);
        int buffer;
        for (int i = 0; i < dataArray.length / 2; i++){
            buffer = dataArray[i];
            dataArray[i] = dataArray[(dataArray.length - 1) - i];
            dataArray[(dataArray.length - 1) - i] = buffer;
        }
        System.out.println(Arrays.toString(dataArray));
    }

    public static int[] tambahArray(int[] arrayInt1,int[] arrayInt2){

        int[] arrayHasil = new int[arrayInt1.length];
        for (int i = 0; i < arrayInt1.length; i++){
            arrayHasil[i] = arrayInt1[i] + arrayInt2[i];
        }
        printArray(arrayInt1);
        printArray(arrayInt2);
        return arrayHasil;
    }

    public static void printArray(int[] dataArray){
        System.out.println("array = " + Arrays.toString(dataArray));
    }
}
