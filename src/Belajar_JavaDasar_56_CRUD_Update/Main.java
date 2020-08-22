package Belajar_JavaDasar_56_CRUD_Update;

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
                    tampilkanData();
                    break;
                case "4":
                    System.out.println("==================");
                    System.out.println("Ubah Buku");
                    System.out.println("==================");
                    updateData();
                    break;
                case "5":
                    System.out.println("==================");
                    System.out.println("Hapus Buku");
                    System.out.println("==================");
                    deleteData();
                    break;
                default:
                    System.err.println(
                            "\nInput anda tidak ditemukan\nSilahkan Pilih [1 - 5]"
                    );
            }
            Lanjutkan = getYESorNO("Ingin Lanjut? ");
        }
    }

    private static void updateData()throws IOException{
        //Kita Ambil database Original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedIn = new BufferedReader(fileInput);

        //Kita Buat database Sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOut = new FileWriter(tempDB);
        BufferedWriter bufferedOut = new BufferedWriter(fileOut);

        //Tampilkan Data
        System.out.println("======= List Buku =======");
        tampilkanData();

        //Ambil user input
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nMasukan No Buku: ");
        int updateNum = terminalInput.nextInt();

        //tampilkan data yang ingin diupdate
        String data = bufferedIn.readLine();
        int entryCount = 0;
        while (data != null){
            entryCount++;
            StringTokenizer st = new StringTokenizer(data,",");

            //Tampilkan EntryCount == updateNum
            if (updateNum == entryCount){
                System.out.println("\nData yang diUpdate:");
                System.out.println("----------------------");
                System.out.println("Referensi\t :" + st.nextToken());
                System.out.println("Tahun\t\t :" + st.nextToken());
                System.out.println("Penulis\t\t :" + st.nextToken());
                System.out.println("Penerbit\t :" + st.nextToken());
                System.out.println("JudulBuku\t :" + st.nextToken());
                //====== Update Data ======

                //====== Mengambil Input User ======
                String[] fieldsData = {"tahun","penulis","penerbit","judul"};
                String[] tempData = new String[4];

                //========= Refresh Token =========
                st = new StringTokenizer(data,",");
                String originalData = st.nextToken();

                for (int i = 0 ; i < fieldsData.length; i++){
                    boolean isUpdate = getYESorNO("Ingin Rubah " + fieldsData[i] + " ? : ");
                    originalData = st.nextToken();

                    if(isUpdate){
                        //== User Input ===

                        if (fieldsData[i].equalsIgnoreCase("tahun")){
                            System.out.print("Masukan Tahun Terbit: ");
                            tempData[i] =  ambilTahun();
                        }else {
                            terminalInput = new Scanner(System.in);
                            System.out.print("\nMasukan " + fieldsData[i] + " : ");
                            tempData[i] = terminalInput.nextLine();
                        }
                    }else {
                        tempData[i]= originalData;
                    }
                }

                //=========== Tampilkan DataBaru ===========
                st = new StringTokenizer(data,",");
                st.nextToken();
                System.out.println("\nData Baru yang diUpdate:");
                System.out.println("----------------------");
                System.out.println("Tahun\t\t :" + st.nextToken() + "--> " + tempData[0]);
                System.out.println("Penulis\t\t :" + st.nextToken() + "--> " + tempData[1]);
                System.out.println("Penerbit\t :" + st.nextToken() + "--> " + tempData[2]);
                System.out.println("JudulBuku\t :" + st.nextToken() + "--> " + tempData[3]);

                boolean isUpdate = getYESorNO("Apakah Yakin ingin Update data? ");

                if(isUpdate){

                    //Cek Databaru Di Database
                    boolean isExist = cekBukuDatabase(tempData,false);
                    if (isExist){
                        System.err.println("Data Buku sudah Ada diDatabase");
                        System.err.println("Silahkan Delete Data Yang Bersangkutan");
                        bufferedOut.write(data);
                    }else {
                        //====== Format Data baru kedalam database
                        String tahun = tempData[0];
                        String penulis = tempData[1];
                        String penerbit = tempData[2];
                        String judul = tempData[3];

                        //========== Membuat Primary Key ==========
                        long noEntry = ambilEntryPerTahun(penulis,tahun) + 1;

                        String penulisTanpaSpasi = penulis.replaceAll("\\s+","");
                        String PK = penulisTanpaSpasi + "_" + tahun + "_" + noEntry;

                        //========== Tulis Ke Database ==========
                        bufferedOut.write(PK + "," + tahun + "," + penulis + "," + penerbit + "," + judul);
                    }

                }else {
                    //====== Copy Data ======
                    bufferedOut.write(data);
                }

            }else {

                //====== Copy Data ======
                bufferedOut.write(data);
            }
            bufferedOut.newLine();
            data = bufferedIn.readLine();
        }

        //======== Menulis Data Ke File ========
        bufferedOut.flush();

        //======== Delete Original Database ========
        bufferedIn.close();
        fileInput.close();
        bufferedOut.close();
        fileOut.close();

        System.gc();
        java.nio.file.Files.delete(database.toPath());
        database.delete();
        //======== Rename File tempDB menjadi database ========
        tempDB.renameTo(database);
    }

    public static void deleteData() throws IOException{
        //======= Ambil Database Original =======
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedIn = new BufferedReader(fileInput);

        //======= Database Sementara =======
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOut = new BufferedWriter(fileOutput);

        //======= Tampilkan Data =======
        System.out.println("====== List Buku ======");
        tampilkanData();

        //======= Ambil UserInput Delete Data =======
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nNomer Buku Di Hapus: ");
        int deleteNum = terminalInput.nextInt();

        //======= Looping untuk membaca tiap Data
            // baris dan Skip umtuk data yang didelete =======
        boolean isFound = false;
        int entryCounts = 0;

        String data = bufferedIn.readLine();
        while (data != null){
            entryCounts++;
            boolean isDeleted = false;

            StringTokenizer strToken = new StringTokenizer(data,",");


            //Tampilkan Data yang ingin dihapus
            if(deleteNum == entryCounts){
                System.out.println("Data Yang akan dihapus: ");
                System.out.println("========================");
                System.out.println("Referensi \t:"+strToken.nextToken());
                System.out.println("Tahun \t\t:"+strToken.nextToken());
                System.out.println("Penulis \t:"+strToken.nextToken());
                System.out.println("Penerbit \t:"+strToken.nextToken());
                System.out.println("Judul Buku \t:"+strToken.nextToken());
                isDeleted = getYESorNO("Yakin Ingin Delete Buku? : ");
                isFound = true;
            }
            if (isDeleted){
                //===== Skip Pindahkan data dari Ori Ke TempDB=====
                System.out.println("=== Data Berhasil DiHapus ===");
            }else {
                //===== Pindahkan Data dari Ori ke TempDB =====
                bufferedOut.write(data);
                bufferedOut.newLine();
            }
            data = bufferedIn.readLine();
        }

        if (!isFound){
            System.err.println("===== Buku Tidak Ditemukan =====");
        }

        // ===== Menulis Data keFile =====
        bufferedOut.flush();

        //===== Delete Original File =====
        bufferedOut.close();
        fileOutput.close();
        bufferedIn.close();
        fileInput.close();

        System.gc();
        java.nio.file.Files.delete(database.toPath());
        database.delete();
        //===== Rename file TempDB ke Database =====
        tempDB.renameTo(database);
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

        fileOutput.close();
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
        fileInput.close();
        bufferIn.close();
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
            tambahData();
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

    private static boolean cekBukuDatabase(String[] keywords, boolean isDisplay) throws IOException{
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
            tambahData();
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
        fileInput.close();
        bufferedInput.close();
        System.out.println("Akhir Dari Database");
    }

    private static boolean getYESorNO(String message){
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
