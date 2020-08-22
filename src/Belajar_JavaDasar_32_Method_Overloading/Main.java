package Belajar_JavaDasar_32_Method_Overloading;

public class Main {
    public static void main(String[] args) {
        printAngka(5);

        printAngka(2.2,3);

        printNama("Latina");
    }

    public static void printAngka(int angka){
        System.out.println("ini angka: " + angka);
    }

    public static void printAngka(float angka){
        System.out.println("ini angka: " + angka);
    }

    public static void printAngka(double angka1,int angka2){
        System.out.println("ini angka: " + angka1 + " dan " + angka2);
    }

    public static void printNama(String kata){
        System.out.println("ini kata: " + kata);
    }
}
