package Belajar_JavaOOP_63_Interface_Implement;

public interface Hewan {
    //Sebuah kelas dapat mengimplementasikan lebih dari satu interface.
        // Kelas ini akan mendeklarasikan metode pada interface yang
        // dibutuhkan oleh kelas itu sekaligus mendefinisikan isinya
        // pada kode program.
    //didalam class interface
        //Modifier akan selalu bernilai Public , Static ,dan Final

    //Konstanta di kode Java biasanya ditulis dengan huruf besar
        // semuanya dan diberi pemisah underscore jika lebih dari 1 kata
    String respirasi = "oksigen";
    void makan();
}
