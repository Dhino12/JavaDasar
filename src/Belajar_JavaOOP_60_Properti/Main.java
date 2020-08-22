package Belajar_JavaOOP_60_Properti;

public class Main {
    public static void main(String[] args) {
        //Menambahkan Argument untuk 2 variable pada constructor di Class Games
        Games theSims = new Games("PC / PS4","The Sims");
        theSims.cetakInfo();

        System.out.println();
        theSims.namaGames = "The Sims 2";
        theSims.tahunRilis = 2020;
        theSims.cetakInfo();

        System.out.println();
        Games zuma = new Games("PC","Zuma");
        zuma.genre = "Puzzle";
        zuma.cetakInfo();

        System.out.println("\nNama Games: " + theSims.getNamaGames());
    }
}
