package Belajar_JavaDasar_50_Scanner_StringTokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner inputUser = new Scanner(System.in);
        System.out.print("InputIn: ");
        String input = inputUser.next();
        System.out.println("InputOut: " + input);
        input = inputUser.next();
        System.out.println("KataKedua: " + input);
        // ==========================================
        // ==========================================
        FileReader fileIn = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileIn);

        Scanner scanner = new Scanner(bufferedReader);

        System.out.println("\n==== Dengan Delimiter Spasi ====");
        //===== untuk membaca kata ,dengan pemisah/Delimeter Spasi =====
        System.out.println("Kata 1 = " + scanner.next());
        System.out.println("Kata 2 = " + scanner.next());
        System.out.println("Kata 3 = " + scanner.next());
        System.out.println("Kata 4 = " + scanner.next());

        //===== Check ada kata selanjutnya atau tidak =====
        System.out.println("=== cek ada kata selanjutnya atau tidak ===");
        //============= True | False ========
        System.out.println("Kata 5 = " + scanner.hasNext());

        System.out.println("==== Dengan Delimiter Tertentu ====");
        FileReader fileInput2 = new FileReader("input.txt");
        bufferedReader = new BufferedReader(fileInput2);
        bufferedReader.mark(200);

        scanner = new Scanner(bufferedReader);
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }

        System.out.println("==== Dengan String Tokenizer ====");
        bufferedReader.reset();

        //Baris Pertama
        String data = bufferedReader.readLine();
        System.out.println("Data 1 Baris: " + data);
        System.out.println("----------------------------------");
        StringTokenizer stringToken = new StringTokenizer(data,",");

        while (stringToken.hasMoreTokens()){
            System.out.println(stringToken.nextToken());
        }

        //Baris Ke Dua
        data = bufferedReader.readLine();
        stringToken = new StringTokenizer(data,",");

        while (stringToken.hasMoreTokens()){
            System.out.println(stringToken.nextToken());
        }
    }
}
