package Belajar_JavaDasar_34_ArrayLoop;

public class Main {
    public static void main(String[] args) {
        int[] arrayAngka = {11,12,13,14,15};

        System.out.println("===== For Biasa =====");
        for(int i = 0; i < arrayAngka.length; i++){
            System.out.println("index ke: " + i + " adalah " + arrayAngka[i]);
        }

        System.out.println("===== ForEach =======");
        for(int items: arrayAngka){
            System.out.println("items: " + items);
        }
    }
}
