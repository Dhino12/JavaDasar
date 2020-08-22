package Belajar_JavaOOP_62_Non_Access_Modifier.statik;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nilai1 Awal : " + Perhitungan.nilai1);

        for (int i = 0 ; i < 10; i++){
            // tes pembuatan objek kelas perhitungan sebanyak 10 kali
            new Perhitungan();
        }

        System.out.println("Nilai1 Akhir : " + Perhitungan.nilai1);
        System.out.println("getNilai() : " + Perhitungan.getNilai());
    }
}
