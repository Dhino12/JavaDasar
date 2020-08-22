package Belajar_JavaDasar_47_CharStream_InputOutput;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Membuka File
        //byte stream -> FileInputStream
        //Char stream -> FileReader

        FileInputStream byteFileIn = new FileInputStream("input3.txt");
        FileReader      charFileIn = new FileReader("input3.txt");
        FileOutputStream byteFileOut = new FileOutputStream("outputByte.txt");
        FileWriter      charFileOut = new FileWriter("outputChar.txt");

        //Membaca File
        System.out.println("==== ByteStream ====");

        int buffer = byteFileIn.read();
        while (buffer != -1){
            System.out.print((char)buffer);
            byteFileOut.write(buffer);
            buffer = byteFileIn.read();
        }

        System.out.println("\n==== CharStream ====");

        buffer = charFileIn.read();
        while (buffer != -1){
            System.out.print((char)buffer);
            charFileOut.write(buffer);
            buffer = charFileIn.read();
        }

        //Menutup File
        byteFileIn.close();
        charFileIn.close();
        byteFileOut.close();
        charFileOut.close();
    }
}
