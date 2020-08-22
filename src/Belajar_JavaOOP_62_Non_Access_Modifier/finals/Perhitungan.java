package Belajar_JavaOOP_62_Non_Access_Modifier.finals;

public class Perhitungan {
    //Final seperti const pada bahasa pemrogramman lain
        //Final variabel hanya bisa diinisiasi sekali. Ini menandakan bahwa
        // variabel yang sudah dideklarasikan final
        // tidak dapat diganti dengan objek lainnya.
    final double PI = 3.14;
    int jari = 13;
    void ubahNilai(){
        // Error = Access Modifier bersifat Final
        //---------------------------------------
        // nilai = 0;
        //=======================================
    }


    //Metode yang dideklarasikan final maka tidak dapat di override
    // oleh anak kelas.
    // Ini akan berguna jika kita ingin membuat metode
    // yang tidak dapat diubah
    final double getLuas(){
        return PI * (jari * jari);
    }
}

//  Kelas yang dideklarasikan sebagai final maka tidak
    //  bisa dijadikan sebagai induk kelas.
final class Lingkaran{

}
