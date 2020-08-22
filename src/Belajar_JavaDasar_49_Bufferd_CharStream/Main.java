package Belajar_JavaDasar_49_Bufferd_CharStream;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        //Membaca File
        FileReader fileInput = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileInput);
        bufferedReader.mark(200);

        //Membaca kedalam String
        String data = bufferedReader.readLine();
        System.out.println("Isi Data = " + data);

        //Membaca Kedalam Char
        bufferedReader.reset();
        char[] dataChar = new char[11];
        bufferedReader.read(dataChar,0,11);
        System.out.println(Arrays.toString(dataChar));

        //Membaca Baris
        bufferedReader.reset();
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());

        //Menulis File
        FileWriter fileOut = new FileWriter("output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileOut);

        bufferedReader.reset();
        String baris1 = bufferedReader.readLine();

        bufferedWriter.write(baris1,0,baris1.length());
        bufferedWriter.flush();

        //Menambah newLine / Enter
        bufferedWriter.newLine();

        String baris2 = bufferedReader.readLine();
        bufferedWriter.write(baris2,0,baris2.length());
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        fileInput.close();
        fileOut.close();
    }
}
