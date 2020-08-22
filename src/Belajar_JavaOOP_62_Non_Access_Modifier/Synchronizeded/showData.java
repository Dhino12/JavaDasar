package Belajar_JavaOOP_62_Non_Access_Modifier.Synchronizeded;

public class showData {

    // Synchronized modifier digunakan untuk membatasi akses
        // ke suatu variable/methods yang hanya boleh dilakukan oleh satu thread.
        // Ketika ada 2 thread yang ingin mengakses synchronized variable/methods,
        // maka prosesnya akan dilakukan secara serial (bergantian).

    public synchronized void showData(){
        System.out.println("Haii");
    }
}
