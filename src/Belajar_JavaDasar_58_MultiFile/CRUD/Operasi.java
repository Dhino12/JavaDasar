package Belajar_JavaDasar_58_MultiFile.CRUD;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Operasi {

    public static void updateData()throws IOException {
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
                    boolean isUpdate = Utility.getYESorNO("Ingin Rubah " + fieldsData[i] + " ? : ");
                    originalData = st.nextToken();

                    if(isUpdate){
                        //== User Input ===

                        if (fieldsData[i].equalsIgnoreCase("tahun")){
                            System.out.print("Masukan Tahun Terbit: ");
                            tempData[i] =  Utility.ambilTahun();
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

                boolean isUpdate = Utility.getYESorNO("Apakah Yakin ingin Update data? ");

                if(isUpdate){

                    //Cek Databaru Di Database
                    boolean isExist = Utility.cekBukuDatabase(tempData,false);
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
                        long noEntry = Utility.ambilEntryPerTahun(penulis,tahun) + 1;

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
                isDeleted = Utility.getYESorNO("Yakin Ingin Delete Buku? : ");
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

    public static void tambahData() throws IOException{
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
        tahun =  Utility.ambilTahun();

        //========== Cek Buku Database ==========

        String[] keywords = {tahun + "," + penulis + "," + penerbit + "," + judul};
        System.out.println(Arrays.toString(keywords));

        boolean isExist = Utility.cekBukuDatabase(keywords,false);
        //========== Menulis Buku DiDatabase ==========
        if(!isExist){

            System.out.println("PK = " + Utility.ambilEntryPerTahun(penulis ,tahun));
            long noEntry = Utility.ambilEntryPerTahun(penulis,tahun) + 1;

            String penulisTanpaSpasi = penulis.replaceAll("\\s+","");
            String PK = penulisTanpaSpasi + "_" + tahun + "_" + noEntry;

            System.out.println("\nData Yang Akan Anda Masukan adalah");
            System.out.println("=====================================");
            System.out.println("Primary Key  = " + PK);
            System.out.println("Tahun Terbit = " + tahun);
            System.out.println("Penulis      = " + penulis);
            System.out.println("Judul        = " + judul);
            System.out.println("Penerbit     = " + penerbit);

            boolean isTambah = Utility.getYESorNO("Tambah Data KeDatabase = ");
            if (isTambah){
                bufferOut.write(PK + "," + tahun + "," + penulis + "," + penerbit + "," + judul);
                bufferOut.newLine();
                bufferOut.flush();
            }
        }else {
            System.err.println("\nBuku yang anda Akan Masukan Sudah Ada Di Database");
            Utility.cekBukuDatabase(keywords,true);
        }

        fileOutput.close();
        bufferOut.close();
    }

    public static void tampilkanData() throws IOException  {
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

    public static void cariData()throws IOException{
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
        Utility.cekBukuDatabase(keyword,true);

    }
}
