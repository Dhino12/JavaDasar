package Belajar_JavaOOP_66_Polymorphism;

import static Belajar_JavaOOP_66_Polymorphism.Mamalia.mamalia;

public class Main {
    public static void main(String[] args) {
        Hewan hewan = new Hewan(); //Memanggil Construct
        System.out.println("Apakah Hewan IS-A Object -> " + (hewan instanceof Object));
        System.out.println("Apakah Hewan IS-A Hewan -> " + (hewan instanceof Hewan));
        System.out.println("Apakah Hewan IS-A Kucing -> " + (hewan instanceof Kucing));

        System.out.println("--------------------- ");

        Kucing kucing = new Kucing(); //Memanggil Construct
        System.out.println("Apakah Hewan IS-A Object -> " + (kucing instanceof Object));
        System.out.println("Apakah Kucing IS-A Hewan -> " + (kucing instanceof Hewan));
        System.out.println("Apakah Kucing IS-A Kucing -> " + (kucing instanceof Kucing));

        System.out.println("--------------------- ");

        hewan.makan(); // Kucing mewarisi metode makan() dari parent class Hewan
        kucing.makan();
        kucing.makan("ikan");

        System.out.println("--------------------- ");

        Kucing meow = new Kucing("Ocicat","Tropis");
        Kucing puss = new Kucing("Ocicat","subTropis");
        Kucing popo = new Kucing("Anggora","subTropis");

        System.out.println(meow.toString());
        System.out.println(puss.toString());
        System.out.println(popo.toString());

        System.out.println("meow equals puss? " + meow.equals(puss));
        System.out.println("meow equals popo? " + meow.equals(popo));


        System.out.println("\n============ Polymoriphism =============");
        System.out.println("--------------------- ");

        Object o = new Kucing(); // Kucing adalah Object
        Hewan h = new Kucing(); // Kucing adalah Hewan
        Kucing k = new Kucing(); // Kucing adalah Kucing

        // Error karena method makan tidak ada pada class Object
        //-----------------------------------------------------
        //o.makan();
        //=====================================================
        h.makan();
        k.makan();

        Object object = k; //bisa langsung di assign
        Hewan hewanK = k; //bisa langsung di assign

        hewanK.makan();

        // Tidak Bisa langsung di assign | harus dicasting dulu
        // Casting sendiri adalah mengubah suatu tipe data
        //    // menjadi tipe data yang lain
        //-----------------------------------------------------
        Kucing kucingK = (Kucing) h ;
        kucingK.makan();
        //=====================================================

        // compile OK tetapi runtime ERROR ClassCastException
        //-----------------------------------------------------
        Hewan harimau = new Hewan();
        Kucing anggora = (Kucing) harimau;
        //=====================================================
    }

}

//. Analoginya kucing adalah pasti hewan tetapi belum tentu
    // hewan adalah kucing. Bisa jadi harimau atau elang atau yang lainnya.

// Inheritance = Konsep inheritance digunakan untuk abstraksi dari
                // yang paling umum ke yang lebih spesifik.
// Interface   =  digunakan sebagai kontrak atau aturan.
                // Class yang menerapkan suatu interface wajib override
                // semua method dari interface tersebut.
                // Artinya class tersebut harus mengikuti aturan
                // atau spesifikasi yang ada di interface.