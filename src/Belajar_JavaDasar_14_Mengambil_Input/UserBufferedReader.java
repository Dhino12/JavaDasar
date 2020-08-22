package Belajar_JavaDasar_14_Mengambil_Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserBufferedReader {
    public static void main(String[] args) {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        System.out.println("======= Program Penjumlahan =======");
        String nama = "";
        int value1 = 0;
        int value2 = 0;

        //Menggunakan try and catch untuk penanganan error
            //dan menggunakan parseInt untuk dikompersi ke angka / Int

        //Penggunaan Method readline untuk mengambil satu baris
        try {
            System.out.print("Masukan Nama: ");
            nama = bufferedReader.readLine();

            System.out.print("Masukan Angka : ");
            value1 = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Masukan Angka : ");
            value2 = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int hasil = value1 + value2 ;
        System.out.println("Nama : " + nama);
        System.out.println("Hasil : " + hasil);
    }
}
