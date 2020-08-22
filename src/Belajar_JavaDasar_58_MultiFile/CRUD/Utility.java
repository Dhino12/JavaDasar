package Belajar_JavaDasar_58_MultiFile.CRUD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utility {


    static long ambilEntryPerTahun(String penulis,String tahun) throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferIn = new BufferedReader(fileInput);

        long entry = 0 ;
        String data = bufferIn.readLine();
        Scanner dataScanner;
        String PK;

        while (data != null){
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            PK = dataScanner.next();

            dataScanner = new Scanner(PK);
            dataScanner.useDelimiter("_");

            penulis = penulis.replaceAll("\\s+","");
            if(penulis.equalsIgnoreCase(dataScanner.next()) && tahun.equalsIgnoreCase(dataScanner.next())){
                entry = dataScanner.nextInt();
            }
            data = bufferIn.readLine();

        }
        fileInput.close();
        bufferIn.close();
        return entry;
    }

    protected static String ambilTahun() throws IOException{

        boolean tahunValid = false;

        Scanner terminalInput = new Scanner(System.in);
        String tahunInput = terminalInput.nextLine();

        while (!tahunValid) {
            try {
                Year.parse(tahunInput);
                tahunValid = true;
            } catch (Exception e) {
                System.err.println("Format Tahun Salah : " + e.getMessage());
                System.err.println("\nFormat Tahun (YYYY): ");
                tahunValid = false;
                System.out.print("\nMasukan Tahun Kembali: ");
                tahunInput =  terminalInput.nextLine();

            }
        }
        return tahunInput;
    }

    //Default Access Modifier
    static boolean cekBukuDatabase(String[] keywords, boolean isDisplay) throws IOException{
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false ;
        int nomorData = 0;

        if (isDisplay){
            System.out.println("\n| No |\tTahun |\tPenulis              |\tPenerbit             |\tJudul Buku");
            System.out.println("-----------------------------------------------------------------------------");
        }

        while (data != null){
            //Cek Keyword didalam Baris
            isExist = true;

            for (String keyword:keywords) {
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            //Jika Keyword maka Tampilkan
            if(isExist){
                if (isDisplay){
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data, ",");
                    stringToken.nextToken();
                    System.out.printf("| %2d ", nomorData);
                    System.out.printf("|\t%4s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s ", stringToken.nextToken());
                    System.out.printf("|\t%-20s ", stringToken.nextToken());
                    System.out.printf("|\t%s \n", stringToken.nextToken());
                }else {
                    break;
                }
            }
            data = bufferInput.readLine();
        }
        if (isDisplay){
            System.out.println("-----------------------------------------------------------------------------");
        }
        return isExist;
    }

    public static boolean getYESorNO(String message){
        Scanner consoleInput = new Scanner(System.in);
        System.out.print("\n" + message +" (Y/N) : ");
        String pilihanUser = consoleInput.next();;

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("Pilihan Anda Bukan Y/N !!...");
            System.out.print("\n" + message +" (Y/N) ? ");
            pilihanUser = consoleInput.next();;
        }

        return pilihanUser.equalsIgnoreCase("y");
    }

    public static void clearScreen(){
        try {
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\033\143");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}
