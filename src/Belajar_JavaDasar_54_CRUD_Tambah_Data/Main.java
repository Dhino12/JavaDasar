package Belajar_JavaDasar_54_CRUD_Tambah_Data;

import java.io.*;
import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner consoleInput = new Scanner(System.in);
        String pilihanUser;
        boolean Lanjutkan = true;

        while (Lanjutkan) {
            clearScreen();
            System.out.println("Database Perpustakaan\n");
            System.out.println("1.\tLihat Seluruh Buku");
            System.out.println("2.\tCari Data Buku");
            System.out.println("3.\tTambah Data Buku");
            System.out.println("4.\tUbah Data Buku");
            System.out.println("5.\tHapus Data Buku");

            System.out.print("\n\nPilihan Anda: ");
            pilihanUser = consoleInput.next();

            switch (pilihanUser) {
                case "1":
                    System.out.println("==================");
                    System.out.println("List Seluruh Buku");
                    System.out.println("==================");
                    tampilkanData();
                    break;
                case "2":
                    System.out.println("==================");
                    System.out.println("Cari Seluruh Buku");
                    System.out.println("==================");
                    cariData();
                    break;
                case "3":
                    System.out.println("==================");
                    System.out.println("Tambah Buku");
                    System.out.println("==================");
                    tambahData();
                    break;
                case "4":
                    System.out.println("==================");
                    System.out.println("Ubah Buku");
                    System.out.println("==================");
                    break;
                case "5":
                    System.out.println("==================");
                    System.out.println("Hapus Buku");
                    System.out.println("==================");
                    break;
                default:
                    System.err.println(
                            "\nInput anda tidak ditemukan\nSilahkan Pilih [1 - 5]"
                    );
            }
            Lanjutkan = getYESorNO("Ingin Lanjut? ");
        }
    }
    private static void tambahData() throws IOException{
        FileWriter fileOutput = new FileWriter("database.txt",true);
        BufferedWriter bufferOut = new BufferedWriter(fileOutput);

        //========== Mengambil Input User ==========
        Scanner terminalInput = new Scanner(System.in);
        String penulis,judul,penerbit,tahun;

        System.out.print("Masukan Nama Penulis: ");
        penulis = terminalInput.nextLine();

        System.out.print("Masukan Judul Buku: ");
        judul =  terminalInput.nextLine();

        System.out.print("Masukan Nama Penerbit: ");
        penerbit =  terminalInput.nextLine();

        System.out.print("Masukan Tahun Terbit: ");
        tahun =  ambilTahun();

        //========== Cek Buku Database ==========

        String[] keywords = {tahun + "," + penulis + "," + penerbit + "," + judul};
        System.out.println(Arrays.toString(keywords));

        boolean isExist = cekBukuDatabase(keywords,false);
        //========== Menulis Buku DiDatabase ==========
        if(!isExist){

            System.out.println("PK = " + ambilEntryPerTahun(penulis ,tahun));
            long noEntry = ambilEntryPerTahun(penulis,tahun) + 1;

            String penulisTanpaSpasi = penulis.replaceAll("\\s+","");
            String PK = penulisTanpaSpasi + "_" + tahun + "_" + noEntry;

            System.out.println("\nData Yang Akan Anda Masukan adalah");
            System.out.println("=====================================");
            System.out.println("Primary Key  = " + PK);
            System.out.println("Tahun Terbit = " + tahun);
            System.out.println("Penulis      = " + penulis);
            System.out.println("Judul        = " + judul);
            System.out.println("Penerbit     = " + penerbit);

            boolean isTambah = getYESorNO("Tambah Data KeDatabase = ");
            if (isTambah){
                bufferOut.write(PK + "," + tahun + "," + penulis + "," + penerbit + "," + judul);
                bufferOut.newLine();
                bufferOut.flush();
            }
        }else {
            System.err.println("\nBuku yang anda Akan Masukan Sudah Ada Di Database");
            cekBukuDatabase(keywords,true);
        }

        bufferOut.close();
    }

    private static long ambilEntryPerTahun(String penulis,String tahun) throws IOException{
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
        return entry;
    }

    private static String ambilTahun() throws IOException{

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

    private static void cariData()throws IOException{
        //====== Membaca Database |Ada / Tidak|

        try {
            File file = new File("database.txt");

        }catch (Exception e){
            System.err.println("Database Tidak Ditemukan");
            System.err.println("Silahkan Tambah Dahulu");
            return;
        }
        //====== Kita Ambil Keyword dari User
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukan Keyword : ");
        String cariString = terminalInput.nextLine();
        String[] keyword = cariString.split("\\s+");
        System.out.println(cariString);

        //====== Kita Cek Keyword diDatabase
        cekBukuDatabase(keyword,true);

    }

    private static boolean cekBukuDatabase(String[] keywords,boolean isDisplay) throws IOException{
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

    private static void tampilkanData() throws IOException  {
        FileReader fileInput ;
        BufferedReader bufferedInput;

        try {
            fileInput = new FileReader("database.txt");
            bufferedInput = new BufferedReader(fileInput);
        }catch (Exception e){
            System.err.println("Database Tidak Ditemukan");
            System.err.println("Silahkan Tambah Dahulu");
            return;
        }

        String data = bufferedInput.readLine();
        System.out.println("\n| No |\tTahun |\tPenulis              |\tPenerbit             |\tJudul Buku");
        System.out.println("-----------------------------------------------------------------------------");
        int nomorData = 0;
        while (data != null) {
            nomorData++;
            StringTokenizer stringToken = new StringTokenizer(data, ",");
            stringToken.nextToken();
            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%4s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s ", stringToken.nextToken());
            System.out.printf("|\t%-20s ", stringToken.nextToken());
            System.out.printf("|\t%s \n", stringToken.nextToken());
            data = bufferedInput.readLine();

        }
        System.out.println("Akhir Dari Database");
    }

    private static boolean getYESorNO(String message){
        Scanner consoleInput = new Scanner(System.in);
        System.out.print("\n" + message +" (Y/N)");
        String pilihanUser = consoleInput.next();;

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("Pilihan Anda Bukan Y/N !!...");
            System.out.print("\n" + message +" (Y/N) ? ");
            pilihanUser = consoleInput.next();;
        }

        return pilihanUser.equalsIgnoreCase("y");
    }

    private static void clearScreen(){
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
