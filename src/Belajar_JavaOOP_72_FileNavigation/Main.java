package Belajar_JavaOOP_72_FileNavigation;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Secara default akan membuat direktori di C:/
        String dirname = "/java/latihan1";
        File file = new File(dirname);
        String[] path;

        try {
            // inisalisasi Object File
            file = new File(dirname);
            //Ambil list file dan masukan ke paths
            path = file.list();
            //Tampilkan Semua path yang ada
            for (String paths:path){
                System.out.println("isi : " + paths);
            }
            // dengan ini kita bisa membuat program yang
            // dapat melakukan navigasi ke directories di dalam storage.
        }catch (Exception e){
            e.printStackTrace();
        }

        //Buat direktori
        // file.mkdirs();
    }
}
