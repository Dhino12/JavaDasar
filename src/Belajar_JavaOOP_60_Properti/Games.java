package Belajar_JavaOOP_60_Properti;

public class Games {

    //Properti atau Field
        //inisialisasi dengan nilai inisial
    String genre = "action";
    int tahunRilis = 2019;

    //Inisialisasi dengan constructor
    String platform;
    String namaGames;

    //Constructor dengan parameter
    Games(String platformGames,String namaGames){
        // variable platformGames = Parameter
        //variable platform = properti
        //gunakan 'this' untuk membedakan kedudukan
        this.platform = platformGames;
        this.namaGames = namaGames;

    }
    // Pemanggilan this ada di dalam konstruktor kelas Hewan.
    // Artinya nilai this mereferensikan objek Hewan.

    public void cetakInfo(){

        System.out.println("Nama Games: " + this.namaGames);
        System.out.println("Platform: " + this.platform);
        System.out.println("Genre: " + this.genre);
        System.out.println("Tahun Rilis: " + this.tahunRilis);

    }

    //Method / Function dengan kembalian
    String getNamaGames(){
        return namaGames;
    }

}
