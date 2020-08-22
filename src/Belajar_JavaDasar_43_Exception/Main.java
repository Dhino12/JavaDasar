package Belajar_JavaDasar_43_Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};

        Scanner userInput = new Scanner(System.in);
        FileInputStream fileInput = null;

        // ======== Exception - IndexOutOfBounds ========
        System.out.print("Nilai Array ke : ");
        int index = userInput.nextInt();

        try {
            System.out.printf("index ke %d adalah %d\n",index,array[index]);
        }catch (Exception e){
            System.out.println("IndexOutOfBounds \n" + e);
        }

        //Runtime error jika file tidak ada
        // ======== Exception - IO NotFound ========
        try {
            fileInput = new FileInputStream("input.txt");
        }catch (IOException e){
            System.err.println(e);
        }

        //Gabung 2 Exception
        try {
            System.out.printf("index ke %d adalah %d\n",index,array[index]);
            fileInput = new FileInputStream("input.txt");
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Index Berlebihan");
        }catch (IOException e){
            System.err.println("File Tidak Ditemukan");
        }

        //======== Menambahkan Finnaly
        try {
            System.out.printf("index ke %d adalah %d\n",index,array[index]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Index Berlebihan");
        }finally {
            //Finaly akan dijalankan ketika catch dan try selesai dijalankan
            System.out.println("Finally");
        }

        System.out.println("==== Akhir Program ====");
    }
}
