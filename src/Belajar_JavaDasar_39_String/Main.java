package Belajar_JavaDasar_39_String;

import java.util.Arrays;

//String bersifat final.
    // Alhasil, kita tidak bisa mengubah nilai dari objek yang sudah kita buat.
    // Jika kita ingin mengubah nilai tersebut,
    // kita membutuhkan StringBuffer dan StringBuilder

public class Main {
    public static void main(String[] args) {
        String kataStr = "Hallo";
        char[] kataChr = {'H','a','l','l','o'};
        String kalimat1 = new String(kataChr);

        System.out.println(kataStr);
        System.out.println(Arrays.toString(kataChr));
        System.out.println(kalimat1);

        System.out.println("Komponen Char " + kataChr[0]);
        System.out.println("Komponen String " + kataStr.charAt(1));

        //Merubah Komponen String
            //Merubah komponen String !TIDAK BISA!, karena di java immutable
        // kataStr[0] = "C"; <---- Tidak bisa
        // kataStr.charAt(0) = "C"; <---- Tidak bisa
        String kataString = "C" + kataStr.substring(1,5);// dengan method
        System.out.println(kataStr);
        printAddress("KataStr",kataStr);
        printAddress("KataString",kataString);

        //Memori String (String Pool = 1 Slot memori for String)
        String str1 = "Hallo";
        String str2 = "tester";
        String str3 = "testing";
        printAddress("str_1",str1);
        printAddress("str_2",str2);
        printAddress("str_3",str3);

        str3 = str3.substring(0,4); // dengan method
        printAddress("str_3",str3);

        String str4 = "Callo";
        printAddress("str_4",str4);

        kataStr = "Callo";
        printAddress("kataString",kataStr);
        
        //1. String di java Immutable
        //2. String yang berada di String = reuseable
            //Memorinya lebih efesien
        //3. Membuat String dengan method baru maka akan ditaruh di memori lain
            //bukan di string pool
        String a = new String("Hallo");
        printAddress("a",a);
    }

    public static void printAddress(String nama,String data){
        int address = System.identityHashCode(data);
        System.out.println(nama + " = " + data + "\t|| address = " + Integer.toHexString(address));
    }
}