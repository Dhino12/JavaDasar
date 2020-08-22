package Belajar_JavaOOP_73_DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        long timeNow = System.currentTimeMillis();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormat = sdf.format(new Date());

        //CurrentTimeMillis() mengembalikan jumlah waktu mulai dari 1-1-1970
            // sampai dengan waktu yang sekarang.
        System.out.println("Waktu Sekarang: " + timeNow + " milisecond");
        System.out.println(date.toString());
        System.out.println(calendar.getTime());

        // Menampilkan Spesifik waktu yang diinginkan
        System.out.println("\nTanggal : " + calendar.get(Calendar.DATE));
        System.out.println("Bulan : " + calendar.get(Calendar.MONTH));
        System.out.println("Tahun : " + calendar.get(Calendar.YEAR));

        //Menampilkan waktu 15 hari lalu
        calendar.add(Calendar.DATE, -15);
        System.out.println("\n15 Hari lalu : " + calendar.getTime());

        //Menampilkan 4 bulan yang akan datang
        calendar.add(Calendar.MONTH,4);
        System.out.println("4 Bulan Kemudian : " + calendar.getTime());

        //Menampilkan waktu 2 tahun yang akan datang
        calendar.add(Calendar.YEAR,2);
        System.out.println("2 Tahun Kemudian : " + calendar.getTime());

        //Simple Date Formate
        System.out.println("\nFormat tanggal Default: " + new Date());
        System.out.println("Format tanggal Custom : " + dateFormat);
    }
}
