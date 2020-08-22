package Belajar_JavaOOP_59_Object;

//Penamaan Sebuah Class haruslah menggunakan camelCase
public class Main {

    public static void main(String[] args) {
        Hewan Elang = new Hewan("Elang");

        Elang.beratHewan(5);
        Elang.jumlahKakiHewan(2);
        Elang.cetakHewan();

        System.out.println();

        Hewan Kucing = new Hewan("Kucing");
        Kucing.beratHewan(3);
        Kucing.jumlahKakiHewan(4);
        Kucing.cetakHewan();
    }
}
