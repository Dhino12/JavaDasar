package Belajar_JavaOOP_62_Non_Access_Modifier.transients;

import java.io.Serializable;

//Serialisasi adalah proses
    // konversi suatu objek menjadi byte agar dapat ditransmisikan.
//Variabel yang dideklarasikan sebagai transient maka akan
    // tidak dijaga nilainya di dalam proses serialisasi
public class Test implements Serializable {
    // Variabel ini tidak akan dijaga nilainya
    transient int nilaiA;

    // Variable ini akan dijaga Nilainya
    double nilaiB;
}
