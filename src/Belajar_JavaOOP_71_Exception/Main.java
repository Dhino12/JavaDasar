package Belajar_JavaOOP_71_Exception;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //.Ini dikarenakan exception java.io.FileNotFoundException merupakan checked exception.
        // Maka kita perlu memasukkannya ke dalam try-catch agar bisa di -compile.
        FileReader file = null;
        BufferedReader buffereRead = null;
        try {
            //Mencoba Membaca file berkas output.txt
            file = new FileReader("output.txt");
            buffereRead = new BufferedReader(file);
            String data = buffereRead.readLine();
            System.out.print("Berhasil: ");
            System.out.println(data);
        }catch (IOException e ){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }finally {
            /*
            *   Finally akan selalu dijalankan
            *   setelah try-catch baik terjadi exception atau tidak.
            *   Finally bermanfaat ketika kita ingin melakukan cleanup code.
            *   Cleanup code di sini maksudnya adalah de-alokasi sumber daya,
             *
             */
            try {
                buffereRead.close();
                file.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
