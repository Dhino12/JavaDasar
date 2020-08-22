package Belajar_JavaDasar_28_Method_atau_Function;

public class Main {
    public static void main(String[] args) {
        int x,y;

        //static = penggunaan Function / Method tanpa membuat Object

        //Pertama, nama metode haruslah kata kerja dengan huruf kecil (lower case).
            // Dan kalau terdiri lebih dari 1 kata,
            // penulisan dimulai dari kata kerja dengan huruf kecil dan diikuti dengan
            // kata benda yang huruf pertamanya adalah besar/kapital.

        x = 10;
        y = hitung(x);
        System.out.println("x = " + x + " y = " + y);

        x = 20;
        y = hitung(x);
        System.out.println("x = " + x + " y = " + y);

        x = 30;
        y = hitung(x);
        System.out.println("x = " + x + " y = " + y);

        cobaFungsi();
    }

    private static int hitung(int input){
        // Int(TipeData) = dengan kembalian
            //Fungsi dengan kembalian

        int hasil;
        hasil = (input + 2) * input;
        return hasil;
    }

    public static void cobaFungsi() {
        //Void = Tidak Mengembalikan Apapun
        System.out.println("\nIni Merupakan Bagian Dari Function/Method");
    }
}
