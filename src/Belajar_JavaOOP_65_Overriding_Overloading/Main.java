package Belajar_JavaOOP_65_Overriding_Overloading;

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
    }

}
