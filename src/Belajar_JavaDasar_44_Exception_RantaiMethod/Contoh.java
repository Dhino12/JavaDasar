package Belajar_JavaDasar_44_Exception_RantaiMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Contoh {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = new FileInputStream("input.txt");
        System.out.println((char) fileInput.read());

        System.out.println("Akhir Program");
    }
}
