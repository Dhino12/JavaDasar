package Belajar_JavaOOP_61_Access_Modifier.package1;

public class KelasA {
    private int memberA = 5;

    private int functionA(){
        return memberA;
    }

    //public bisa kita sebut sebagai modifier global.
        // Artinya bisa diakses dari manapun bahkan package yang berbeda.
    public int functionB(){
        // Pemanggilan private member dan private function
        int hasil = memberA + functionA();
        return hasil;
    }

    //Default modifier berarti penulisan kodenya tanpa atribut modifier.
        // Ini berlaku untuk semua kelas,
        // member, atau fungsi yang kita tuliskan tanpa access modifier.
        // Tetapi tidak bisa diakses diluar package yang berbeda
    char memberB = 'B';
    double memberC = 2.1;

    //Perbedaannya adalah protected bisa diakses dari luar package.
        // Akan tetapi, satu-satunya cara untuk akses dari luar package
        // adalah kelas yang hendak mengakses, merupakan kelas turunannya
        // Inheritance nya.

    protected void methodC(){
        System.out.println("Percobaan Protected");
    }
}
