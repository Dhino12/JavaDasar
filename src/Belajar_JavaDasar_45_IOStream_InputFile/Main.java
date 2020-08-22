package Belajar_JavaDasar_45_IOStream_InputFile;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = new FileInputStream("input.txt");
        for (int i = 0 ;i <= 10; i++){
            System.out.print((char)fileInput.read());
        }
    }
}
