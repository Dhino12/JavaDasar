package Belajar_JavaOOP_64_Inheritance;

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

    }

}
