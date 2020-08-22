package Belajar_JavaDasar_02_OrganisasiProgram_dengan_Package.Main;

import Belajar_JavaDasar_02_OrganisasiProgram_dengan_Package.Bola.Bola;
import org.apache.commons.lang3.time.DateUtils;

//Penggunaan wildcard (*) kadang tidak disarankan
    // jika class di dalam package tersebut terlalu banyak.
    // Sebabnya, ia memperlama waktu untuk pencarian class tersebut
    //import Belajar_JavaDasar_02_OrganisasiProgram_dengan_Package.Bola.*;

    //Untuk itu kita serahkan ke IntelliJ mengatur import yang optimal.
    // Pilih menu Code | Optimize Imports.
    // Baris import akan kembali ke sebelumnya tanpa menggunakan wildcard (*).

import java.util.Date; //dari Java Library
import org.apache.commons.lang3.time.DateUtils; // dari Apache Library


public class Main {
    public static void main(String[] args) {

        System.out.println("Haii.... ");
        Bola.sepakBola();
        Bola.bolaBasket();

        // Menambahkan Waktu
        Date today = new Date();
        System.out.println("Hari Ini = " + today);

        // DateUtils.addDays(hari ini , brp hari dari sekarang);
        Date besok = DateUtils.addDays(today,1);
        System.out.println("Besok \t = " + besok);
    }
}
