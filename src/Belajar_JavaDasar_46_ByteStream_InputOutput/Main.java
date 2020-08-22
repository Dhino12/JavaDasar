package Belajar_JavaDasar_46_ByteStream_InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;

        //Membuka File
        fileInput = new FileInputStream("input.txt");
        int data = fileInput.read();

        //Membaca File
        System.out.print("FileInput = ");
        while (data != -1){
            System.out.print((char)data);
            data = fileInput.read();
        }

        //Menutup File
        fileInput.close(); //Agar tidak trjadi Memory Leak

        //========// Skenario Pembukaan File //===========
        try {
            //Membuka & MembuatFile
            fileInput = new FileInputStream("input2.txt");
            fileOutput = new FileOutputStream("output2.txt");

            //Membaca File
            int buffer = fileInput.read();

            //Menulis File
            while (buffer != -1){
                fileOutput.write(buffer);
                buffer = fileInput.read();
            }
        }finally {
            if (fileInput != null){
                fileInput.close();
            }else if(fileOutput != null){
                fileOutput.close();
            }
        }

        //Finalisasi
            //Try with resources
        try(
                FileInputStream in = new FileInputStream("input.txt");
                FileOutputStream out = new FileOutputStream("output.txt")
        ){
            //Membuka File
            int huruf = in.read();
            //Membaca File
            System.out.print("FileInput = ");
            while (huruf != -1){
                out.write((char) huruf);
                System.out.print((char)huruf);
                huruf = in.read();
            }
        }
    }
}
