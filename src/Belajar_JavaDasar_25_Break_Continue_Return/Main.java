package Belajar_JavaDasar_25_Break_Continue_Return;

public class Main {
    public static void main(String[] args) {
        // Break | Continue | Return

        int a = 0;
        while (true){
            a++;
            if(a == 10){
                System.out.println("Looping ke: " + a);
                break; //Berhenti Proses Looping
            }else if(a == 6){
                continue; //Skip proses looping
            }else if(a == 8){
                System.out.println("Keluar Program: " + a);

                return; //Keluar dari semua Statement
            }
            System.out.println("Looping ke: " + a);
        }

        System.out.println("Keluar Looping ke: " + a);
    }
}
