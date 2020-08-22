package Belajar_JavaDasar_40_Operasi_String;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        String kalimat = "Hello World";
        System.out.println("\n" + kalimat);

        System.out.println("==== Mengambil Panjang String ====");
        System.out.println("Panjang Kata: " + kalimat.length());

        System.out.println("==== Mengambil Komponen String ====");
        System.out.println(kalimat.charAt(1));

        System.out.println("==== Mengambil String dengan range ====");
        // TIDAK Ditaruh di String Pool / hanya di memori heap(biasa)
        String kata = kalimat.substring(6,11);
        System.out.println(kata);

        System.out.println("==== String Concatenation ====");
        String kalimat2 = "Another " + kata ;
        kata = "Another " + kata  + "!"; // Ditaruh di String Pool
        System.out.println(kalimat2);
        System.out.println(kata);
        System.out.println(kata.concat(" Kakkokari"));

        System.out.println("==== String concat dengan NonString ====");
        int jumlah = 20;
        String kalimat3 = kata + " " + jumlah;
        System.out.println(kalimat3);

        System.out.println("==== String lowercase & UPERCASE ====");
        System.out.println(kalimat.toUpperCase());
        System.out.println(kalimat.toLowerCase());

        System.out.println("==== String Replace ====");
        String kalimat4 = kalimat2.replace("World","Dunia");
        System.out.println(kalimat2);
        System.out.println(kalimat4);

        System.out.println("==== String Equals ====");
        // ini ada di stringPool dan ini string literal
        // String kataInput = "test";
        //=============================================
        //ini bukan string Literal ,dan tidak ada di string pool
        String kataInput = new String("test");
        //=============================================
        // ini juga ada di StringPool
        String kataTest = "test";
        //=============================================

        if(kataTest == kataInput){
            System.out.println("Sama");
        }else {
            System.out.println("Tidak Sama");
        }

        //Input user selalu berada di Heap
        System.out.print("Masukan kata: ");
        kataInput = userInput.next();
        System.out.println("Input User: " + kataInput);

        if(kataTest.equals(kataInput)){
            System.out.println("Sama");
        }else {
            System.out.println("Tidak Sama");
        }

        System.out.println("==== String Compare ====");
        String Heroine1 = "Emilia";
        String Heroine2 = "Yui Yuigahama ";
        System.out.println(Heroine1.compareTo(Heroine2));
        System.out.println(Heroine2.compareTo(Heroine1));

        System.out.println("==== Cek String Kosong / Tidak ====");
        String perbandingan = (kataInput.isEmpty())? "Kosong" : "Tidak Kosong";
        System.out.println("Input user : " + perbandingan);

        System.out.println("==== Cek Index pada String ====");
        System.out.println(Heroine2);
        System.out.println("Huruf i di Index Ke: " + Heroine2.indexOf("i"));

        System.out.println("==== Penghapus spasi String ====");
        System.out.println(Heroine2.trim());
        System.out.println(kataInput.trim());
    }
}
