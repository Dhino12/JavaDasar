package Belajar_JavaOOP_62_Non_Access_Modifier.statik;

public class Perhitungan {

    //Ia digunakan untuk mendeklarasikan
        // variabel atau metode yang berdiri sendiri tanpa
        // perlu instance/object dari suatu kelas.
    //static variable hanya berjumlah satu, tak peduli berapapun obyek yang dibuat.
    public static int nilai1 = 0;
    Perhitungan(){
        nilai1++;
    }

    protected static int getNilai(){
        return nilai1;
    }
}
