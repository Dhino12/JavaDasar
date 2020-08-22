package Belajar_JavaOOP_67_Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPlanet {
    public static void main(String[] args) {
        //==== Deklarasi Array ====
        String[] heroes = {"latina","hatena"};
        String[] people = new String[3];
        people[0] = "Kotoko";
        people[1] = "Chino";
        people[2] = "Yui";

        //Index Out Of Bonds lebih dari batas array
        // people[3] = "Cocoa";

        //==== Menggunakan ArrayList =====
        List<String> planets = new ArrayList<>();
        //Method add untuk menambah ke array 1 per satu
        planets.add("venus");
        planets.add("earth");
        planets.add("mars");

        System.out.println("List Planet awal: ");
        for (int i = 0 ; i < planets.size(); i++){
            //Method size untuk mendapatkan ukuran list
            //Method get() untuk melihat / mengambil isi list
            System.out.println(planets.get(i) + "\tindex ke " + "[ " + i + " ]" );
        }

        //Method remove untuk menghapus object dari list
        planets.remove("venus");

        System.out.println("\nList Planet Akhir: ");

        for (int i = 0 ; i < planets.size(); i++){
            //Method size untuk mendapatkan ukuran list
            //Method get() untuk melihat / mengambil isi list
            System.out.println(planets.get(i) + "\tindex ke " + "[ " + i + " ]" );
        }

    }
}

//Objek di dalam List bisa duplikat artinya objek yang
    // sama bisa dimasukkan beberapa kali ke dalam List dan
    // akan mempunyai index yang berbeda.