package Belajar_JavaOOP_67_Collection.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetPlanet {
    public static void main(String[] args) {
        //Menggunakan HashSet
        Set<String> planets = new HashSet<>();

        //Menambah Object menggunakan add();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");

        //Menambahkan object Earth beberapa kali !TIDAK BISA! karena Set
        //planets.add("Earth");
        //==============================================================
        planets.add("Mars");

        System.out.println("Set Planet Awal size: " + planets.size());
        for (String planet: planets) {
            System.out.println("\t" + planet);
        }

        //Menghapus Object Mars denga method .remove
        planets.remove("Mars");

        System.out.println("Set Planet Akhir size: " + planets.size());
        for (Iterator iterator = planets.iterator();iterator.hasNext();){
            //Looping menggunakan Iterator
            System.out.println("\t" + iterator.next());
            System.out.println("\t" + iterator.next());
        }
    }
}
//objek di dalam Set tidak bisa diduplikasi.
    // Yang artinya jika objek yang sama dimasukkan beberapa
    // kali ke dalam Set maka Set hanya akan menyimpan objek tersebut satu
    // kali saja.

// Ini yang dimaksud penyimpanan pada Set tidak teratur.
    // saat memasukan object ke dalam set menggunakan method add()
