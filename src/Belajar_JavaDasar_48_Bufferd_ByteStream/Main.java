package Belajar_JavaDasar_48_Bufferd_ByteStream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("\n===== Membaca Dari File =====");
        FileInputStream byteInput = new FileInputStream("input.txt");
        System.out.println("Karakter dalam file = " + byteInput.available());

        System.out.println("---- menghitung waktu pembacaan ----");
        long waktuStart,waktuFinish;
        waktuStart = System.nanoTime();
        System.out.println("ArrayByte = " + byteInput.readAllBytes());
        waktuFinish = System.nanoTime();
        System.out.println("waktu = " + (waktuFinish - waktuStart));
        byteInput.close();

        System.out.println("\n===== Membaca Dari Memori =====");
        FileInputStream byteInput2 = new FileInputStream("input.txt");
        BufferedInputStream bufferedInput = new BufferedInputStream(byteInput2);

        bufferedInput.mark(200); //batas Reset | Hanya penggunaan Bufferd
        System.out.println("---- menghitung waktu pembacaan ----");
        waktuStart = System.nanoTime();
        System.out.println(bufferedInput.readAllBytes());
        waktuFinish = System.nanoTime();
        System.out.println("waktu = " + (waktuFinish - waktuStart));
        bufferedInput.reset(); //Reset

        //Baca Ulang
        System.out.println("---- Baca Ulang setelah RESET ----");
        byte[] data = bufferedInput.readAllBytes();
        String dataString = new String(data);
        bufferedInput.close();
        System.out.println(dataString);
        byteInput2.close();

        // Menulis Dengan BufferdOutput
        FileOutputStream byteOutput = new FileOutputStream("output.txt");
        BufferedOutputStream bufferedOut = new BufferedOutputStream(byteOutput);
        // Write Data berupa Byte
        bufferedOut.write(data,0,data.length);//Kumpul data
        bufferedOut.flush(); //Masukan ke file

        bufferedOut.close();
        byteOutput.close();

    }
}
