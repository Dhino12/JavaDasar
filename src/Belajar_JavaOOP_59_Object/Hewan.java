package Belajar_JavaOOP_59_Object;

public class Hewan {
    String namaHewan;
    int beratHewan;
    int jumlahKakiHewan;

    // Ini merupakan konstruktor dari kelas hewan.
        // konstruktor adalah method yang pertama
        // kali dijalankan ketika object diciptakan.
    //Constructor ============
    public Hewan(String nama){
        namaHewan = nama;
    }

    public void beratHewan(int berat){
        beratHewan = berat;
    }

    public void jumlahKakiHewan(int jumlahKaki){
        jumlahKakiHewan = jumlahKaki;
    }

    public void cetakHewan(){
        System.out.println("Nama Hewan = " + namaHewan);
        System.out.println("Berat Hewan = " + beratHewan + " kg");
        System.out.println("Jumlah Kaki Hewan = " + jumlahKakiHewan);
    }
}
