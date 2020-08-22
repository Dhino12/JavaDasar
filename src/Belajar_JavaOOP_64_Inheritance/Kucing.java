package Belajar_JavaOOP_64_Inheritance;

public class Kucing extends Hewan {
    public Kucing(){
        super();
        // Akan Tetap memanggil constructor dari parent Class yakni Hewan
        System.out.println("Construct Kucing");
    }
}
