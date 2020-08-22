package Belajar_JavaOOP_67_Collection.Map;

import java.util.HashMap;
import java.util.Map;

public class MapPlanet {
    public static void main(String[] args) {
        //Menggunakan HasMap
            // Map adalah struktur data dalam bentuk pasangan key-value.
        Map<String,Planet> planets = new HashMap<>();

        //Menggunakan put() untuk menambahkan object ke HashMap
        planets.put("key1",new Planet("Mercury",0.82));
        planets.put("key2",new Planet("Earth",0.82));
        planets.put("key3",new Planet("Venus",0.82));
        planets.put("key4",new Planet("Mars",0.82));

        //Menambahkan object dengan Key yang
            // sama maka value akan diganti
         planets.put("key4",new Planet("Jupiter",0.82));

        //Method .size() untuk mendapatkan ukuran Set
        System.out.println("Map planets awal Size = " + planets.size());
        for (String key:planets.keySet()) {
            //Looping key dari Map
            //Method keySet() untuk mengambil key di HasMap
            //Method get() untuk mengambil array berdasarkan key
            System.out.println(" " + key + " : " + planets.get(key));
        }

        //Method remove() untuk menghapus berdasarkan key
        planets.remove("key3");

        System.out.println("\nMap planets Akhir Size = " + planets.size());

        for (Planet planet: planets.values()) {
            //Looping value dari HasMap
            System.out.println(" " + planet);
        }
    }
}
